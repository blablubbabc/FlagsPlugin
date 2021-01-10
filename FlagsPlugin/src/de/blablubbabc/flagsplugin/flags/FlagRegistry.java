package de.blablubbabc.flagsplugin.flags;

import java.util.Collection;

public interface FlagRegistry {

	public Collection<? extends Flag<?>> getRegisteredFlags();
}
