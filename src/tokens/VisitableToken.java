package tokens;


import parser.IParserVisitor;

public interface VisitableToken {
    void accept(IParserVisitor visitor);
}
