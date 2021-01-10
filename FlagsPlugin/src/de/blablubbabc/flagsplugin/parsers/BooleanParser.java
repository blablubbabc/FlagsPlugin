package de.blablubbabc.flagsplugin.parsers;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class BooleanParser implements Parser<Boolean> {

	public static final BooleanParser INSTANCE = new BooleanParser();

	private static final Map<String, Boolean> booleans = new HashMap<>();
	static {
		booleans.put("true", true);
		booleans.put("yes", true);
		booleans.put("y", true);
		booleans.put("1", true);
		booleans.put("enable", true);
		booleans.put("enabled", true);

		booleans.put("false", false);
		booleans.put("no", false);
		booleans.put("n", false);
		booleans.put("0", false);
		booleans.put("disable", false);
		booleans.put("disabled", false);
	}

	// Returns null if it cannot parse the value. Maybe throw an exception instead.
	@Override
	public Boolean parse(String string) {
		return booleans.get(string.toLowerCase(Locale.ROOT));
	}
}
