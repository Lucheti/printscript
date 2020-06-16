package parser.nodes;

import parser.nodes.state.NodeState;
import test.Expr;
import test.NodeVisitor;

public class TypeNode extends ASTNode {
    public TypeNode(String value) {
        this.value = value;
    }

    @Override
    public Expr visit(NodeVisitor visitor) {
        return visitor.execute(this);
    }
}
