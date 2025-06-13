package utils;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {

    private final Map<String, Object> data = new HashMap<>();

    // Generic set method
    public <T> void set(String key, T value) {
        data.put(key, value);
    }

    // Generic get method with Class<T> to enable safe casting
    public <T> T get(String key, Class<T> clazz) {
        Object value = data.get(key);
        if (value == null) {
            throw new IllegalArgumentException("No value found in context for key: " + key);
        }
        if (!clazz.isInstance(value)) {
            throw new ClassCastException("Value for key '" + key + "' is not of type " + clazz.getSimpleName());
        }
        return clazz.cast(value);
    }

    public void clear() {
        data.clear();
    }

    public boolean contains(String key) {
        return data.containsKey(key);
    }
}
