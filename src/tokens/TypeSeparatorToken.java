package tokens;

import parser.TokenVisitor;

import java.util.regex.Pattern;

public class TypeSeparatorToken extends Token {

    public TypeSeparatorToken() {
        super(Pattern.compile(":", Pattern.MULTILINE));
    }

    public TypeSeparatorToken(String value) {
        super(Pattern.compile(":", Pattern.MULTILINE), value);
    }

    @Override
    public Token withValue(String value) {
        return new TypeSeparatorToken(value);
    }

    @Override
    public void visit(TokenVisitor tokenVisitor) {
        tokenVisitor.parseToken(this);
    }
}
