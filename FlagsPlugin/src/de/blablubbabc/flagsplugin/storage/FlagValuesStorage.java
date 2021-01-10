package de.blablubbabc.flagsplugin.storage;

import de.blablubbabc.flagsplugin.flagvalues.FlagValues;

public interface FlagValuesStorage {

	public void save(FlagValues values);

	public void load(FlagValues values);
}
