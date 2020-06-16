package tokens;

import parser.TokenVisitor;

import java.util.regex.Pattern;

public class ConstToken extends Token {

    public ConstToken() {
        super(Pattern.compile("const", Pattern.MULTILINE));
    }

    public ConstToken(String value) {
        super(Pattern.compile("const", Pattern.MULTILINE), value);
    }

    @Override
    public Token withValue(String value) {
        return new ConstToken(value);
    }

    @Override
    public void visit(TokenVisitor tokenVisitor) {
        tokenVisitor.parseToken(this);
    }
}
