package tdd.args;

import com.google.common.primitives.Booleans;

import java.util.HashMap;
import java.util.Map;

import static java.util.Arrays.asList;

public class Schema {
    private Map<String, String> keyTypeMap;

    public Schema(String schemaConfig) {
        keyTypeMap = new HashMap<>();
        asList(schemaConfig.split(","))
                .forEach(keyTypePair -> {
                    String[] nameValue = keyTypePair.split(":");
                    keyTypeMap.put(nameValue[0], nameValue[1]);
                });
    }

    public Object getValueInType(String name, String valueInText) {
        if (keyTypeMap.containsKey(name)) {
            String type = keyTypeMap.get(name);
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
        if (isaBoolean(value.toLowerCase())) {
            return Boolean.valueOf(value);
        } else {
            return "只能输入Boolean类型的值";
        }
    }

    private boolean isaBoolean(String lowerCaseValue) {
        return lowerCaseValue.equals("true") || lowerCaseValue.equals("false");
    }

    private boolean isEmpty(String value) {
        return value == null || "".equals(value);
    }
}
