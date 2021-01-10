package de.blablubbabc.flagsplugin.flagvalues;

import java.util.Set;

public interface FlagValues {

	public WorldFlagValues forWorld(String worldName);

	public Set<String> getWorldNames();
}
