package warmup;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class PatternUtils {

    private final static String CUSTOM_DELIMITER = "//(.)\n(.*)";
    private static Matcher matcher;

    public static PatternUtils create(String input) {
        PatternUtils utils = new PatternUtils();
        Pattern pattern = Pattern.compile(CUSTOM_DELIMITER);
        matcher = pattern.matcher(input);
        return utils;
    }

    public boolean find() {
        return matcher.find();
    }

    public String getDelimiter() {
        return matcher.group(1);
    }

    public String getValue() {
        return matcher.group(2);
    }
}
