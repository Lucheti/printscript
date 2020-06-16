package parser;

import parser.nodes.ASTNode;
import parser.nodes.DeclarationNode;
import parser.nodes.ExpressionNode;
import parser.nodes.IdentifierNode;
import tokens.IdentifierToken;


public class DeclarationParserState extends AbstractParserState {

    private DeclarationNode declarationNode;

    @Override
    public ASTNode getNode() {
        return this.declarationNode;
    }

    @Override
    public void visit(IdentifierToken token) {
        getInput().consume();
        TypeAssignationParserState state = new TypeAssignationParserState();
        ExpressionNode type = (ExpressionNode) state.parse(getInput());

        this.declarationNode = new DeclarationNode(
                new IdentifierNode(token.getLexeme()),
                state.getType(),
                type);
    }
}
