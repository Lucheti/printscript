package tokens;

import parser.IParserVisitor;

import java.util.regex.Pattern;

public class StringValueToken extends Token {

    public StringValueToken() {
        super(Pattern.compile("\".*\"", Pattern.MULTILINE));
    }

    public StringValueToken(String value) {
        super(Pattern.compile("\".*\"", Pattern.MULTILINE), value);
    }

    @Override
    public Token withValue(String value) {
        return new StringValueToken(value);
    }
    @Override
    public void accept(IParserVisitor visitor) {
        visitor.visit(this);
    }

}
