package tdd.args;

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

    public Object getValueInType(String name, String valueInText) {
        if (schames.containsKey(name)) {
            String type = schames.get(name);
            return getValueByType(valueInText, type);
        }
        return "Please enter a valid command";
    }

    private Object getValueByType(String valueInText, String type) {
        switch (type) {
            case "boolean":
                return getBooleanValue(valueInText);
            case "int":
                return getIntValue(valueInText);
            default:
                return getStringValue(valueInText);
        }
    }

    private Object getStringValue(String value) {
        if (isEmpty(value)) {
            return "default";
        }
        return value;
    }

    private Object getIntValue(String value) {
        if (isEmpty(value)) {
            return 0;
        }
        try {
            Integer.parseInt(value);
        } catch (Exception e) {
            return "只能输入Integer类型的值";
        }

        return Integer.parseInt(value);
    }

    private Object getBooleanValue(String value) {
        if (isEmpty(value)) {
            return Boolean.FALSE;
        }
        if (!value.toLowerCase().equals("true") && !value.toLowerCase().equals("false")) {
            return "只能输入Boolean类型的值";
        } else {
            return "true".equalsIgnoreCase(value);
        }
    }

    private boolean isEmpty(String value) {
        return value == null || "".equals(value);
    }
}
