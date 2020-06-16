package parser.nodes;

import interpreter.ASTVisitor;

public interface ASTNode {
    void accept(ASTVisitor visitor);
}
