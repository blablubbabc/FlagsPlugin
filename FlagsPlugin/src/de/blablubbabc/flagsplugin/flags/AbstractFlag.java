package de.blablubbabc.flagsplugin.flags;

public abstract class AbstractFlag<V> implements Flag<V> {

	private final String name;

	protected AbstractFlag(String name) {
		this.name = name;
	}

	@Override
	public final String getName() {
		return name;
	}
}
