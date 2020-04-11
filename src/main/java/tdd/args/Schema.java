package tdd.args;

import com.google.common.base.Strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Schema {
    Map<String, String> schames;

    public Schema(String schameConfig) {

        schames = new HashMap<>();
        Arrays.asList(schameConfig.split(","))
                .forEach(flag -> {
                    String[] nameValue = flag.split(":");
                    schames.put(nameValue[0], nameValue[1]);
                });

    }

    public Object getValue(String name, String value) {
        if (!schames.containsKey(name)) {
            return "Please enter a valid command";
        }
        String type = schames.get(name);
        switch (type) {
            case "boolean":
                if (isEmpty(value)) {
                    return Boolean.FALSE;
                }
                if (!value.toLowerCase().equals("true") && !value.toLowerCase().equals("false")) {
                    return "只能输入Boolean类型的值";
                } else {
                    return "true".equalsIgnoreCase(value);
                }
            case "int":
                if (isEmpty(value)) {
                    return 0;
                }
                try {
                    Integer.parseInt(value);
                } catch (Exception e) {
                    return "只能输入Integer类型的值";
                }

                return Integer.parseInt(value);
            default:
                if (isEmpty(value)) {
                    return "default";
                }
                return value;
        }
    }

    private boolean isEmpty(String value) {
        return value == null || "".equals(value);
    }
}
