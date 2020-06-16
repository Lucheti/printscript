package parser;

import common.provider.Provider;
import parser.nodes.ASTNode;
import lexer.tokens.VisitableToken;

public interface ParserState {
    ASTNode parse(Provider<VisitableToken> input);
}
