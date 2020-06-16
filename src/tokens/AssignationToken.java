package tokens;

import parser.IParserVisitor;

import java.util.regex.Pattern;

public class AssignationToken extends Token {

    public AssignationToken() {
        super(Pattern.compile("=", Pattern.MULTILINE));
    }

    public AssignationToken(String value) {
        super(Pattern.compile("=", Pattern.MULTILINE), value);
    }

    @Override
    public Token withValue(String value) {
        return new AssignationToken(value);
    }

    @Override
    public void accept(IParserVisitor visitor) {
        visitor.visit(this);
    }
}