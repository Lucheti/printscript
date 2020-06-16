package parser;

import parser.nodes.ASTNode;
import parser.nodes.ExpressionNode;
import tokens.AssignationToken;

public class AssignationParserState extends AbstractParserState {

    private ExpressionNode expressionNode;

    @Override
    public ASTNode getNode() {
        return this.expressionNode;
    }

    @Override
    public void visit(AssignationToken token) {
        getInput().consume();
        this.expressionNode = (ExpressionNode) new ExpressionParserState().parse(getInput());
    }
}
