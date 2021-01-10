package de.blablubbabc.flagsplugin.flags;

import de.blablubbabc.flagsplugin.formatters.Formatter;
import de.blablubbabc.flagsplugin.parsers.Parser;
import de.blablubbabc.flagsplugin.serializers.Serializer;

public interface Flag<V> {

	public String getName();

	// TODO Yaml specific .. :/
	public Serializer<V> getSerializer();

	public Parser<V> getParser();

	public Formatter<V> getFormatter();
}
