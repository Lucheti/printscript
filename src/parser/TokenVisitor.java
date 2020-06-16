package parser;

import tokens.*;


public interface TokenVisitor {
    void parseToken(ConstToken token);
    void parseToken(EOLToken token);
    void parseToken(EqualsToken token);
    void parseToken(IdentifierToken token);
    void parseToken(StringTypeToken token);
    void parseToken(StringValueToken token);
    void parseToken(TypeSeparatorToken token);
}
