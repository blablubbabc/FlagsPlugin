package de.blablubbabc.flagsplugin.flags;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public class DefaultFlags {

	private DefaultFlags() {
	}

	private static final Set<AbstractFlag<?>> DEFAULT_FLAGS = new LinkedHashSet<>();
	private static final Set<AbstractFlag<?>> DEFAULT_FLAGS_VIEW = Collections.unmodifiableSet(DEFAULT_FLAGS);

	public static final Flag<Boolean> DENY_MOB_SPAWNING = add(new BooleanFlag("deny-mob-spawning"));

	private static <V> Flag<V> add(AbstractFlag<V> flag) {
		DEFAULT_FLAGS.add(flag);
		return flag;
	}

	public static Set<? extends Flag<?>> getAll() {
		return DEFAULT_FLAGS_VIEW;
	}

	// Internal use only.
	public static void register(InternalFlagRegistry flagRegistry) {
		for (AbstractFlag<?> flag : DEFAULT_FLAGS_VIEW) {
			flagRegistry.register(flag);
		}
	}
}
