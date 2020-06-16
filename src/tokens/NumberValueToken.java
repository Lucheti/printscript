package tokens;

import parser.IParserVisitor;

import java.util.regex.Pattern;

public class NumberValueToken extends Token {

    public NumberValueToken() {
        super(Pattern.compile("[0-9]+", Pattern.MULTILINE));
    }

    public NumberValueToken(String value) {
        super(Pattern.compile("[0-9]+", Pattern.MULTILINE), value);
    }

    @Override
    public Token withValue(String value) {
        return new NumberValueToken(value);
    }

    @Override
    public void accept(IParserVisitor visitor) {
        visitor.visit(this);
    }
}
