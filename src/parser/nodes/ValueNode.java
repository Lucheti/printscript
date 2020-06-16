package parser.nodes;

import test.Expr;
import test.NodeVisitor;
import tokens.*;

public class ValueNode extends ASTNode {
    public ValueNode(String value) {
        this.value = value;
    }

    @Override
    public Expr visit(NodeVisitor visitor) {
        return visitor.execute(this);
    }
}
