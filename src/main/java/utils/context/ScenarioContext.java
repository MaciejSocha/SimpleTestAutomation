package utils.context;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {
    private final Map<ContextKey, Object> data = new HashMap<>();

    public <T> void set(ContextKey key, T value) {
        data.put(key, value);
    }

    public <T> T get(ContextKey key) {
        return (T) data.get(key);
    }

    public boolean contains(ContextKey key) {
        return data.containsKey(key);
    }

    @Override
    public String toString() {
        return "Scenario Context contains:\n" + data;
    }
}
