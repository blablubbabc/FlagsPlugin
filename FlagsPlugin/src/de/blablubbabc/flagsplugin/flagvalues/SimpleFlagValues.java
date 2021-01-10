package de.blablubbabc.flagsplugin.flagvalues;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SimpleFlagValues implements FlagValues {

	private final Map<String, WorldFlagValues> valuesByWorld = new HashMap<>();
	private final Set<String> worldNamesView = Collections.unmodifiableSet(valuesByWorld.keySet());

	@Override
	public WorldFlagValues forWorld(String worldName) {
		return valuesByWorld.computeIfAbsent(worldName, (wName) -> new SimpleWorldFlagValues());
	}

	@Override
	public Set<String> getWorldNames() {
		return worldNamesView;
	}
}
