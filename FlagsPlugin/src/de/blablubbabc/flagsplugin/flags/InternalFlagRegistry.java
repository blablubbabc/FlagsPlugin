package de.blablubbabc.flagsplugin.flags;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class InternalFlagRegistry implements FlagRegistry {

	private final Map<String, AbstractFlag<?>> flags = new HashMap<>();
	private final Collection<AbstractFlag<?>> flagsView = Collections.unmodifiableCollection(flags.values());

	public void register(AbstractFlag<?> flag) {
		flags.put(flag.getName(), flag);
	}

	@Override
	public Collection<AbstractFlag<?>> getRegisteredFlags() {
		return flagsView;
	}
}
