package parser;

import exeptions.IllegalGrammarException;
import input.Input;
import parser.nodes.ASTNode;
import tokens.*;

public abstract class AbstractParserState implements IParserState, IParserVisitor {

    private Input<VisitableToken> input;

    @Override
    public ASTNode parse(Input<VisitableToken> input) {
        this.input = input;

        input.next().accept(this);

        return getNode();
    }

    public abstract ASTNode getNode();

    public Input<VisitableToken> getInput() {
        return this.input;
    }

    @Override
    public void visit(AssignationToken token) {
        throw new IllegalGrammarException(token.getLexeme());
    }

    @Override
    public void visit(ClosingParenthesisToken token) {
        throw new IllegalGrammarException(token.getLexeme());
    }

    @Override
    public void visit(DivisionToken token) {
        throw new IllegalGrammarException(token.getLexeme());
    }

    @Override
    public void visit(EOFToken token) {
        throw new IllegalGrammarException(token.getLexeme());
    }

    @Override
    public void visit(IdentifierToken token) {
        throw new IllegalGrammarException(token.getLexeme());
    }

    @Override
    public void visit(LetToken token) {
        throw new IllegalGrammarException(token.getLexeme());
    }

    @Override
    public void visit(MinusToken token) {
        throw new IllegalGrammarException(token.getLexeme());
    }

    @Override
    public void visit(MultiplicationToken token) {
        throw new IllegalGrammarException(token.getLexeme());
    }

    @Override
    public void visit(NumberValueToken token) {
        throw new IllegalGrammarException(token.getLexeme());
    }

    @Override
    public void visit(NumberTypeToken token) {
        throw new IllegalGrammarException(token.getLexeme());
    }

    @Override
    public void visit(OpenParenthesisToken token) {
        throw new IllegalGrammarException(token.getLexeme());
    }

    @Override
    public void visit(PlusToken token) {
        throw new IllegalGrammarException(token.getLexeme());
    }

    @Override
    public void visit(PrintToken token) {
        throw new IllegalGrammarException(token.getLexeme());
    }

    @Override
    public void visit(SemicolonToken token) {
        throw new IllegalGrammarException(token.getLexeme());
    }

    @Override
    public void visit(StringValueToken token) {
        throw new IllegalGrammarException(token.getLexeme());
    }

    @Override
    public void visit(StringTypeToken token) {
        throw new IllegalGrammarException(token.getLexeme());
    }

    @Override
    public void visit(TypeAssignationToken token) {
        throw new IllegalGrammarException(token.getLexeme());
    }

}
