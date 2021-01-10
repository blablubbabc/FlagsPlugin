package de.blablubbabc.flagsplugin.flagvalues;

import java.util.HashMap;
import java.util.Map;

import de.blablubbabc.flagsplugin.flags.Flag;

public class SimpleWorldFlagValues implements WorldFlagValues {

	private final Map<Flag<?>, Object> values = new HashMap<>();

	@SuppressWarnings("unchecked")
	@Override
	public <V> V getValue(Flag<V> flag) {
		return (V) values.get(flag);
	}

	@Override
	public <V> void setValue(Flag<V> flag, V value) {
		if (value == null) {
			values.remove(flag);
		} else {
			values.put(flag, value);
		}
	}
}
