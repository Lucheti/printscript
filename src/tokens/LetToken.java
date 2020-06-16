package tokens;

import parser.IParserVisitor;

import java.util.regex.Pattern;

public class LetToken extends Token {

    public LetToken() {
        super(Pattern.compile("let", Pattern.MULTILINE));
    }

    public LetToken(String value) {
        super(Pattern.compile("let", Pattern.MULTILINE), value);
    }

    @Override
    public Token withValue(String value) {
        return new LetToken(value);
    }

    @Override
    public void accept(IParserVisitor visitor) {
        visitor.visit(this);
    }

}
