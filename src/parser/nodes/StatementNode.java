package parser.nodes;

import parser.nodes.state.IdentifierDeclarationState;
import parser.nodes.state.NodeState;
import test.Expr;
import test.NodeVisitor;
import tokens.*;

public class StatementNode extends ASTNode {
    public StatementNode() {
        this.state = new IdentifierDeclarationState();
    }

    public ASTNode consumeToken(ConstToken token){
        this.state = this.state.nextState(token);
        return this;
    }

    public ASTNode consumeToken(IdentifierToken token){
        this.state = this.state.nextState(token);
        return this;
    }

    public ASTNode consumeToken(StringTypeToken token){
        this.state = this.state.nextState(token);
        return this;
    }

    public ASTNode consumeToken(TypeSeparatorToken token){
        this.state = this.state.nextState(token);
        return this;
    }

    public ASTNode consumeToken(EqualsToken token){
        this.state = this.state.nextState(token);
        return this;
    }
    public ASTNode consumeToken(StringValueToken token){
        this.state = this.state.nextState(token);
        return this;
    }

    public ASTNode consumeToken(EOLToken token){
        this.state = this.state.nextState(token);
        return this;
    }

    @Override
    public Expr visit(NodeVisitor visitor) {
        return visitor.execute(this);
    }
}
