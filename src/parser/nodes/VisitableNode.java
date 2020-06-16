package parser.nodes;

import parser.nodes.state.NodeState;
import test.Expr;
import test.NodeVisitor;

public interface VisitableNode {
    public Expr visit(NodeVisitor visitor);
}
