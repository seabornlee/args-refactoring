package tdd.args;

import java.util.Arrays;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;

public class Command {
    Map<String, String> commands;

    public Command(String commandLine) {
        commands = new HashMap<>();
        ListIterator<String> commandIterator = Arrays.asList(commandLine.split("\\s+")).listIterator();
        while (commandIterator.hasNext()) {
            String name = commandIterator.next().substring(1);
            if (commandIterator.hasNext()) {
                String value = commandIterator.next();
                if (isValue(value)) {
                    commands.put(name, value);
                } else {
                    commandIterator.previous();
                }
            }
        }
    }

    public String getValue(String name) {
        return commands.get(name);
    }

    private boolean isValue(String value) {
        if (value.charAt(0) == '-') {
            if (value.length() > 2) {
                return true;
            }
            return value.charAt(1) >= '0' && value.charAt(1) <= '9';
        }
        return true;
    }


}
