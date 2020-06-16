package tokens;

import parser.TokenVisitor;
import parser.nodes.ASTNode;

import java.util.Iterator;

public interface VisitableToken {
    void visit(TokenVisitor tokenVisitor);
}
