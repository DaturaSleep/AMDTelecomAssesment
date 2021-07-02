package main.java.task4.parser.phone;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * RouteTokenParser class
 * Utility class for token parsing
 */
public class RouteTokenParser {

    private static final String ACCESS_TOKEN_REG_EXP = "\"access_token\":\"[A-Za-z0-9-]+\"";
    private static final String TOKEN_KEYWORD = "\"access_token\":";

    /**
     * parse method
     * method that parses String for any tokens
     *
     * @param stringToParse in which token contains at
     * @return String token without any additional characters
     */
    public String parse(String stringToParse) {
        Pattern pattern = Pattern.compile(ACCESS_TOKEN_REG_EXP);
        Matcher matcher = pattern.matcher(stringToParse);

        return matcher.find()
                ? stringToParse.substring(matcher.start() + TOKEN_KEYWORD.length(), matcher.end()).replace("\"", "")
                : "";
    }
}
