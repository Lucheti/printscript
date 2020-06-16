package parser;

import common.provider.Provider;
import parser.nodes.ASTNode;
import lexer.tokens.VisitableToken;

public class Parser implements ParserState {

    private ParserState state;

    public Parser() {
        this.state = new ProgramParserState();
    }

    @Override
    public ASTNode parse(Provider<VisitableToken> input) {
        return this.state.parse(input);
    }

}
