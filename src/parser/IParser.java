package parser;

import parser.nodes.ASTNode;
import tokens.Token;

import java.util.List;

public interface IParser {
    public ASTNode parse(List<Token> tokenStream);
}
