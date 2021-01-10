package de.blablubbabc.flagsplugin.formatters;

public class BooleanFormatter implements Formatter<Boolean> {

	public static final BooleanFormatter INSTANCE = new BooleanFormatter();

	@Override
	public String format(Boolean value) {
		return String.valueOf(value);
	}
}
