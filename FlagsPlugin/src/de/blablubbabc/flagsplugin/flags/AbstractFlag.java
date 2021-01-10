package de.blablubbabc.flagsplugin.flags;

import de.blablubbabc.flagsplugin.serializers.Serializer;

public abstract class AbstractFlag<V> implements Flag<V> {

	private final String name;

	protected AbstractFlag(String name) {
		this.name = name;
	}

	@Override
	public final String getName() {
		return name;
	}

	// TODO Yaml specific .. :/
	public abstract Serializer<V> getSerializer();
}
