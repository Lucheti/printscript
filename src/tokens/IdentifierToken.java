package tokens;

import parser.TokenVisitor;

import java.util.regex.Pattern;

public class IdentifierToken extends Token {

    public IdentifierToken() {
        super(Pattern.compile("[a-zA-Z]+", Pattern.MULTILINE));
    }

    public IdentifierToken(String value) {
        super(Pattern.compile("[a-zA-Z0-9]+", Pattern.MULTILINE), value);
    }

    @Override
    public Token withValue(String value) {
        return new IdentifierToken(value);
    }

    @Override
    public void visit(TokenVisitor tokenVisitor) {
        tokenVisitor.parseToken(this);
    }
}
