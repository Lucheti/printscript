package parser;

import input.Input;
import parser.nodes.ASTNode;
import tokens.VisitableToken;

public class Parser implements IParserState {

    private IParserState state;

    public Parser() {
        this.state = new ProgramParserState();
    }

    @Override
    public ASTNode parse(Input<VisitableToken> input) {
        return this.state.parse(input);
    }

}
