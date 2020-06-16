package parser;

import parser.nodes.ASTNode;
import parser.nodes.RootNode;
import tokens.*;

import java.util.Iterator;
import java.util.List;

public class Parser implements IParser, TokenVisitor {

    private ASTNode root = new RootNode();
    private ASTNode currentNode;
    private Iterator<Token> iterator;

    @Override
    public ASTNode parse(List<Token> tokens) {
        this.iterator = tokens.iterator();
        currentNode = root;
        iterator.next().visit(this);
        return root;
    }

    @Override
    public void parseToken(ConstToken token) {
        currentNode = currentNode.consumeToken(token);
        next();
    }

    @Override
    public void parseToken(EOLToken token) {
        currentNode.consumeToken(token);
        currentNode = root;
        next();
    }

    @Override
    public void parseToken(EqualsToken token) {
        currentNode.consumeToken(token);
        next();
    }

    @Override
    public void parseToken(IdentifierToken token) {
        currentNode.consumeToken(token);
        next();
    }

    @Override
    public void parseToken(StringTypeToken token) {
        currentNode.consumeToken(token);
        next();
    }

    @Override
    public void parseToken(StringValueToken token) {
        currentNode.consumeToken(token);
        next();
    }

    @Override
    public void parseToken(TypeSeparatorToken token) {
        currentNode.consumeToken(token);
        next();
    }

    private void next() {
        if (iterator.hasNext()) iterator.next().visit(this);;
    }
}
