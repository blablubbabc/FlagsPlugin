package de.blablubbabc.flagsplugin.flags;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Flags {

	private Flags() {
	}

	private static final Map<String, Flag<?>> flags = new HashMap<>();
	private static final Collection<Flag<?>> flagsView = Collections.unmodifiableCollection(flags.values());

	static {
		register(new BooleanFlag("deny-mob-spawning"));
	}

	private static void register(Flag<?> flag) {
		flags.put(flag.getName(), flag);
	}

	public static Collection<Flag<?>> getRegisteredFlags() {
		return flagsView;
	}
}
