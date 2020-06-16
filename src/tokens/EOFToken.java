package tokens;


import parser.IParserVisitor;

import java.util.regex.Pattern;

public class EOFToken extends Token {

    public EOFToken() {
        super(Pattern.compile("EOF", Pattern.MULTILINE));
    }

    public EOFToken(String value) {
        super(Pattern.compile("EOF", Pattern.MULTILINE), value);
    }

    @Override
    public Token withValue(String value) {
        return new EOFToken(value);
    }

    @Override
    public void accept(IParserVisitor visitor) {
        visitor.visit(this);
    }
}
