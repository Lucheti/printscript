package tokens;

import parser.TokenVisitor;

import java.util.regex.Pattern;

public class EqualsToken extends Token {

    public EqualsToken() {
        super(Pattern.compile("=", Pattern.MULTILINE));
    }

    public EqualsToken(String value) {
        super(Pattern.compile("=", Pattern.MULTILINE), value);
    }

    @Override
    public Token withValue(String value) {
        return new EqualsToken(value);
    }

    @Override
    public void visit(TokenVisitor tokenVisitor) {
        tokenVisitor.parseToken(this);
    }
}
