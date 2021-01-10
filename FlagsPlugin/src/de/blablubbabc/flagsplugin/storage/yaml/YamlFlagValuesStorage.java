package de.blablubbabc.flagsplugin.storage.yaml;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import de.blablubbabc.flagsplugin.flags.Flag;
import de.blablubbabc.flagsplugin.flags.Flags;
import de.blablubbabc.flagsplugin.flagvalues.FlagValues;
import de.blablubbabc.flagsplugin.flagvalues.WorldFlagValues;
import de.blablubbabc.flagsplugin.serializers.Serializer;
import de.blablubbabc.flagsplugin.storage.FlagValuesStorage;

public class YamlFlagValuesStorage implements FlagValuesStorage {

	private final File file;

	public YamlFlagValuesStorage(File file) {
		this.file = file;
	}

	private String getPath(String worldName, Flag<?> flag) {
		return worldName + ":" + flag.getName();
	}

	private FileConfiguration prepareConfig() {
		FileConfiguration config = new YamlConfiguration();
		config.options().pathSeparator(':'); // Avoid conflicts with world names that contain dots
		return config;
	}

	@Override
	public void save(FlagValues values) {
		FileConfiguration config = this.prepareConfig();
		for (String worldName : values.getWorldNames()) {
			WorldFlagValues worldFlagValues = values.forWorld(worldName);
			for (Flag<?> flag : Flags.getRegisteredFlags()) {
				Object data = this.serialize(flag, worldFlagValues);
				if (data != null) {
					config.set(this.getPath(worldName, flag), data);
				}
			}
		}

		try {
			config.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private <V> Object serialize(Flag<V> flag, WorldFlagValues worldFlagValues) {
		V value = worldFlagValues.getValue(flag);
		Serializer<V> serializer = flag.getSerializer();
		return serializer.serialize(value);
	}

	@Override
	public void load(FlagValues values) {
		FileConfiguration config = this.prepareConfig();
		try {
			config.load(file);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

		for (String worldName : config.getKeys(false)) {
			WorldFlagValues worldFlagValues = values.forWorld(worldName);
			for (Flag<?> flag : Flags.getRegisteredFlags()) {
				Object data = config.get(this.getPath(worldName, flag));
				this.loadFlagValue(flag, data, worldFlagValues);
			}
		}
	}

	private <V> void loadFlagValue(Flag<V> flag, Object data, WorldFlagValues worldFlagValues) {
		V value = this.deserializeFlagValue(flag, data);
		worldFlagValues.setValue(flag, value);
	}

	private <V> V deserializeFlagValue(Flag<V> flag, Object data) {
		return flag.getSerializer().deserialize(data);
	}
}
