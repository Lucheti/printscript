package parser;

import parser.nodes.ASTNode;
import parser.nodes.ExpressionNode;
import lexer.tokens.AssignationToken;

public class AssignationParserState extends AbstractParserState {

    private ExpressionNode expressionNode;

    @Override
    public ASTNode getNode() {
        return this.expressionNode;
    }

    @Override
    public void visit(AssignationToken token) {
        getTokenProvider().next();
        this.expressionNode = (ExpressionNode) new ExpressionParserState().parse(getTokenProvider());
    }
}
