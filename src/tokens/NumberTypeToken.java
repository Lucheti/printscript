package tokens;


import parser.IParserVisitor;

import java.util.regex.Pattern;

public class NumberTypeToken extends Token {

    public NumberTypeToken() {
        super(Pattern.compile("number", Pattern.MULTILINE));
    }

    public NumberTypeToken(String value) {
        super(Pattern.compile("number", Pattern.MULTILINE), value);
    }

    @Override
    public Token withValue(String value) {
        return new NumberTypeToken(value);
    }

    @Override
    public void accept(IParserVisitor visitor) {
        visitor.visit(this);
    }
}
