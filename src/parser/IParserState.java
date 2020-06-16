package parser;

import input.Input;
import parser.nodes.ASTNode;
import tokens.VisitableToken;

public interface IParserState {
    ASTNode parse(Input<VisitableToken> input);
}
