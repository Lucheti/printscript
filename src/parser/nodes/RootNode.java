package parser.nodes;

import test.Expr;
import test.NodeVisitor;
import tokens.*;

import java.util.ArrayList;
import java.util.List;

public class RootNode extends ASTNode {
    List<ASTNode> nodeList = new ArrayList<>();

    public ASTNode consumeToken(ConstToken token) {
        ASTNode newNode = new StatementNode();
        nodeList.add(newNode);
        return newNode;
    }

    @Override
    public Expr visit(NodeVisitor visitor) {
        return visitor.execute(this);
    }

    @Override
    public List<ASTNode> getChilds(){
        return this.nodeList;
    }

}
