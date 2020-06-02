package token;

import java.util.regex.Pattern;

public class Token {
    private String token;
    private String value;
    private Pattern pattern;
    private int priority;

    public Token(Pattern pattern, String token) {
        this.token = token;
        this.pattern = pattern;
    }

    private Token(String token, String value, Pattern pattern, int priority) {
        this.token = token;
        this.value = value;
        this.pattern = pattern;
        this.priority = priority;
    }

    public Token withValue(String value) {
        return new Token(token, value, pattern, priority);
    }

    public Token withPriority(int priority) {
        return new Token(token, value, pattern, priority);
    }

    public String getToken() {
        return token;
    }

    public String getValue() {
        return value;
    }

    public Pattern getPattern() {
        return pattern;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "Token{" +
                "token='" + token + '\'' +
                ", value='" + value + '\'' +
                ", pattern=" + pattern +
                ", priority=" + priority +
                '}';
    }
}
