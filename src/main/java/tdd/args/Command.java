package tdd.args;

import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;

import static java.lang.Character.isDigit;
import static java.util.Arrays.asList;

public class Command {
    public static final String PARAM_NAME_PREFIX = "-";
    private Map<String, String> keyValueMap;

    public Command(String commandLine) {
        keyValueMap = new HashMap<>();
        parse(commandLine);
    }

    private void parse(String commandLine) {
        ListIterator<String> commandIterator = asList(commandLine.split("\\s+")).listIterator();
        while (commandIterator.hasNext()) {
            String name = commandIterator.next().substring(PARAM_NAME_PREFIX.length());
            if (!commandIterator.hasNext()) {
                break;
            }
            String nextString = commandIterator.next();
            if (isValue(nextString)) {
                keyValueMap.put(name, nextString);
            } else {
                commandIterator.previous();
            }
        }
    }

    public String getStringValue(String name) {
        return keyValueMap.get(name);
    }

    private boolean isValue(String string) {
        if (string.startsWith(PARAM_NAME_PREFIX)) {
            if (string.length() > 2) {
                return true;
            }
            return isDigit(string.charAt(1));
        }
        return true;
    }

}
