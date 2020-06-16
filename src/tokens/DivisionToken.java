package tokens;

import parser.IParserVisitor;

import java.util.regex.Pattern;

public class DivisionToken extends Token {

    public DivisionToken() {
        super(Pattern.compile("/", Pattern.MULTILINE));
    }

    public DivisionToken(String value) {
        super(Pattern.compile("/", Pattern.MULTILINE), value);
    }

    @Override
    public Token withValue(String value) {
        return new DivisionToken(value);
    }

    @Override
    public void accept(IParserVisitor visitor) {
        visitor.visit(this);
    }

}
