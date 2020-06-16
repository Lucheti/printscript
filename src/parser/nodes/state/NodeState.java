package parser.nodes.state;

import parser.nodes.ASTNode;
import tokens.*;

import java.util.ArrayList;
import java.util.List;

public abstract class NodeState {
    List<ASTNode> childs = new ArrayList<>();

    //constructors
    public NodeState() { }
    public NodeState(List<ASTNode> childs) {
        this.childs = childs;
    }


    //method's
    public NodeState nextState(EOLToken token){ throw new RuntimeException("invalidNode"); };
    public NodeState nextState(EqualsToken token){ throw new RuntimeException("invalidNode"); };
    public NodeState nextState(IdentifierToken token){ throw new RuntimeException("invalidNode"); };
    public NodeState nextState(StringTypeToken token){ throw new RuntimeException("invalidNode"); };
    public NodeState nextState(StringValueToken token){ throw new RuntimeException("invalidNode"); };
    public NodeState nextState(TypeSeparatorToken token){ throw new RuntimeException("invalidNode"); };
    public NodeState nextState(ConstToken token){ throw new RuntimeException("invalidNode"); };


    public List<ASTNode> getChilds() {
        return childs;
    }

    @Override
    public String toString() {
        return "NodeState{" +
                "childs=" + childs +
                '}';
    }
}
