package Context;

import java.util.HashMap;
import java.util.Map;

public class Context {

    Map<String, Object> variables = new HashMap<>();

    void declareVariable (String name) {
        variables.put(name, null);
    }

    void assignValue (String name, Object o) {
        variables.put(name, o);
    }
}
