package parser.nodes.state;

import parser.nodes.ASTNode;
import parser.nodes.TypeNode;
import tokens.EqualsToken;
import tokens.StringTypeToken;

import java.util.List;

public class TypeDeclarationState extends NodeState {

    TypeDeclarationState(List<ASTNode> childs) {
        super(childs);
    }

    @Override
    public NodeState nextState(StringTypeToken token) {
        this.childs.add(new TypeNode(token.getValue()));
        return this;
    }

    @Override
    public NodeState nextState(EqualsToken node) {
        return new AssignmentState(this.childs);
    }
}
