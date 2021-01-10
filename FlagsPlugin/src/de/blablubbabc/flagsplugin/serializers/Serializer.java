package de.blablubbabc.flagsplugin.serializers;

public interface Serializer<V> {

	public Object serialize(V value);

	public V deserialize(Object data);
}
