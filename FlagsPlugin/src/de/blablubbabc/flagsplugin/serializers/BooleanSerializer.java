package de.blablubbabc.flagsplugin.serializers;

public class BooleanSerializer implements Serializer<Boolean> {

	public static final BooleanSerializer INSTANCE = new BooleanSerializer();

	public BooleanSerializer() {
	}

	@Override
	public Object serialize(Boolean value) {
		return value;
	}

	@Override
	public Boolean deserialize(Object data) {
		if (data == null) return null;
		if (data instanceof Boolean) {
			return (Boolean) data;
		} else if (data instanceof String) {
			return Boolean.parseBoolean((String) data);
		}
		throw new IllegalArgumentException("Unexpected type of data (" + data.getClass().getSimpleName() + "): " + data);
	}
}
