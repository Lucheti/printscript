package parser;

import parser.nodes.ASTNode;
import parser.nodes.ExpressionNode;
import parser.nodes.PrintNode;
import tokens.OpenParenthesisToken;

public class PrintParserState extends AbstractParserState {

    private PrintNode printNode;

    public PrintParserState() {
        this.printNode = new PrintNode();
    }

    @Override
    public ASTNode getNode() {
        return this.printNode;
    }

    @Override
    public void visit(OpenParenthesisToken token) {
        getInput().consume();
        this.printNode.setExpressionNode((ExpressionNode) new OpenParenthesisParserState().parse(getInput()));
    }
}
