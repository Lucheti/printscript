package parser;

import parser.nodes.ASTNode;
import parser.nodes.ExpressionNode;
import lexer.tokens.ClosingParenthesisToken;
import lexer.tokens.IdentifierToken;
import lexer.tokens.NumberValueToken;
import lexer.tokens.StringValueToken;

public class OpenParenthesisParserState extends AbstractParserState {

    private ASTNode expressionNode;

    @Override
    public ASTNode getNode() {
        return this.expressionNode;
    }

    @Override
    public void visit(StringValueToken token) {
        assignExpression();
    }

    @Override
    public void visit(NumberValueToken token) {
        assignExpression();
    }

    @Override
    public void visit(IdentifierToken token) {
        assignExpression();
    }

    @Override
    public void visit(ClosingParenthesisToken token) {
        getTokenProvider().next();
        this.expressionNode = new ExpressionNode();
    }

    private void assignExpression() {
        this.expressionNode = new ExpressionParserState().parse(getTokenProvider());
    }
}
