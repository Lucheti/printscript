package parser.nodes.state;

import parser.nodes.ASTNode;
import parser.nodes.IdentifierNode;
import tokens.ConstToken;
import tokens.IdentifierToken;
import tokens.TypeSeparatorToken;

import java.util.List;

public class IdentifierDeclarationState extends NodeState {

    public IdentifierDeclarationState(List<ASTNode> childs) {
        super(childs);
    }

    public IdentifierDeclarationState() {}

    @Override
    public NodeState nextState(IdentifierToken token) {
        this.childs.add(new IdentifierNode(token.getValue()));
        return this;
    }

    @Override
    public NodeState nextState(ConstToken token) {
        return this;
    }

    @Override
    public NodeState nextState(TypeSeparatorToken token) {
        return new TypeDeclarationState(this.childs);
    }


}
