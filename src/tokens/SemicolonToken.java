package tokens;

import parser.IParserVisitor;

import java.util.regex.Pattern;

public class SemicolonToken extends Token {

    public SemicolonToken() {
        super(Pattern.compile(";", Pattern.MULTILINE));
    }

    public SemicolonToken(String value) {
        super(Pattern.compile(";", Pattern.MULTILINE), value);
    }

    @Override
    public Token withValue(String value) {
        return new SemicolonToken(value);
    }

    @Override
    public void accept(IParserVisitor visitor) {
        visitor.visit(this);
    }

}
