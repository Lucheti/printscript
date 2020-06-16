package tokens;

import parser.TokenVisitor;

import java.util.regex.Pattern;

public class EOLToken extends Token{
    public EOLToken() {
        super(Pattern.compile(";", Pattern.MULTILINE));
    }

    public EOLToken(String value) {
        super(Pattern.compile(";", Pattern.MULTILINE), value);
    }

    @Override
    public Token withValue(String value) {
        return new EOLToken(value);
    }

    @Override
    public void visit(TokenVisitor tokenVisitor) {
        tokenVisitor.parseToken(this);
    }
}
