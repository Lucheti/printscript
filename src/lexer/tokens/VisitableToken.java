package lexer.tokens;


import parser.TokenVisitor;

public interface VisitableToken {
    void accept(TokenVisitor visitor);
}
