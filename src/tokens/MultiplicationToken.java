package tokens;


import parser.IParserVisitor;

import java.util.regex.Pattern;

public class MultiplicationToken extends Token {

    public MultiplicationToken() {
        super(Pattern.compile("\\*", Pattern.MULTILINE));
    }

    public MultiplicationToken(String value) {
        super(Pattern.compile("\\*", Pattern.MULTILINE), value);
    }

    @Override
    public Token withValue(String value) {
        return new MultiplicationToken(value);
    }

    @Override
    public void accept(IParserVisitor visitor) {
        visitor.visit(this);
    }

}
