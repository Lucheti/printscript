package parser.nodes.state;

import parser.nodes.ASTNode;
import tokens.EOLToken;

import java.util.List;

public class EndOfStatementState extends NodeState {

    public EndOfStatementState(List<ASTNode> childs) {
        super(childs);
    }

    public NodeState nextState(EOLToken token){
        System.out.println("end of line");
        return this;
    };

}
