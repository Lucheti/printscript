package parser.nodes;

import parser.nodes.state.NodeState;
import tokens.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

abstract public class ASTNode implements VisitableNode {
    NodeState state;
    String value;

    public ASTNode consumeToken(ConstToken token){ throw new RuntimeException("Unexpected token"); }
    public ASTNode consumeToken(EOLToken token){ throw new RuntimeException("Unexpected token"); }
    public ASTNode consumeToken(EqualsToken token){ throw new RuntimeException("Unexpected token"); }
    public ASTNode consumeToken(IdentifierToken token){ throw new RuntimeException("Unexpected token"); }
    public ASTNode consumeToken(StringTypeToken token){ throw new RuntimeException("Unexpected token"); }
    public ASTNode consumeToken(StringValueToken token){ throw new RuntimeException("Unexpected token"); }
    public ASTNode consumeToken(TypeSeparatorToken token){ throw new RuntimeException("Unexpected token"); }

    public List<ASTNode> getChilds(){
        return state.getChilds();
    }

    public String getValue(){
        return this.value;
    }
}
