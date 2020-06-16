package parser.nodes.state;

import parser.nodes.ASTNode;
import parser.nodes.IdentifierNode;
import parser.nodes.ValueNode;
import tokens.StringValueToken;

import java.util.List;

public class AssignmentState extends NodeState {
    public AssignmentState(List<ASTNode> childs) {
        super(childs);
    }

    @Override
    public NodeState nextState(StringValueToken token) {
        this.childs.add(new ValueNode(token.getValue()));
        return new EndOfStatementState(this.childs);
    }

}
