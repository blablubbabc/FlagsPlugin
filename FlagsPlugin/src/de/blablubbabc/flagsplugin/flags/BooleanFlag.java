package de.blablubbabc.flagsplugin.flags;

import de.blablubbabc.flagsplugin.formatters.BooleanFormatter;
import de.blablubbabc.flagsplugin.formatters.Formatter;
import de.blablubbabc.flagsplugin.parsers.BooleanParser;
import de.blablubbabc.flagsplugin.parsers.Parser;
import de.blablubbabc.flagsplugin.serializers.BooleanSerializer;
import de.blablubbabc.flagsplugin.serializers.Serializer;

public class BooleanFlag extends AbstractFlag<Boolean> {

	public BooleanFlag(String name) {
		super(name);
	}

	@Override
	public Serializer<Boolean> getSerializer() {
		return BooleanSerializer.INSTANCE;
	}

	@Override
	public Parser<Boolean> getParser() {
		return BooleanParser.INSTANCE;
	}

	@Override
	public Formatter<Boolean> getFormatter() {
		return BooleanFormatter.INSTANCE;
	}
}
