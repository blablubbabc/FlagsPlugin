package de.blablubbabc.flagsplugin.flags;

import de.blablubbabc.flagsplugin.formatters.Formatter;
import de.blablubbabc.flagsplugin.parsers.Parser;

public interface Flag<V> {

	public String getName();

	public Parser<V> getParser();

	public Formatter<V> getFormatter();
}
