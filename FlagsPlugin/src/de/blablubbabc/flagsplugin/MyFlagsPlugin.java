package de.blablubbabc.flagsplugin;

import java.io.File;

import org.bukkit.plugin.java.JavaPlugin;

import de.blablubbabc.flagsplugin.flagvalues.FlagValues;
import de.blablubbabc.flagsplugin.flagvalues.SimpleFlagValues;
import de.blablubbabc.flagsplugin.storage.FlagValuesStorage;
import de.blablubbabc.flagsplugin.storage.yaml.YamlFlagValuesStorage;

public class MyFlagsPlugin extends JavaPlugin {

	private final FlagValues flagValues = new SimpleFlagValues();
	private FlagValuesStorage storage;

	public void onEnable() {
		storage = new YamlFlagValuesStorage(new File(this.getDataFolder(), "flags.yml"));
		storage.load(flagValues);
	}

	public void onDisable() {
		storage.save(flagValues);
	}

	public FlagValues getFlagValues() {
		return flagValues;
	}
}
