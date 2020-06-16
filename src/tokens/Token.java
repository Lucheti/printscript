package tokens;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Token implements VisitableToken {
    final Pattern pattern;
    final String value;

    Token(Pattern pattern) {
        this.pattern = pattern;
        this.value = null;
    }

    Token(Pattern pattern, String value) {
        this.pattern = pattern;
        this.value = value;
    }

    public Matcher getMatcher(String string){
        return pattern.matcher(string);
    }

    public String getValue() {
        return value;
    }

    public abstract Token withValue(String value);

    @Override
    public String toString() {
        return "Token{" +
                "pattern=" + pattern +
                ", value='" + value + '\'' +
                '}';
    }
}
