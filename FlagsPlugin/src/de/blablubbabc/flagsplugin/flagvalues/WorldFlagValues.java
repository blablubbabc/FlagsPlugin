package de.blablubbabc.flagsplugin.flagvalues;

import de.blablubbabc.flagsplugin.flags.Flag;

public interface WorldFlagValues {

	public <V> V getValue(Flag<V> flag);

	public <V> void setValue(Flag<V> flag, V value);
}
