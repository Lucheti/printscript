package input;

import tokens.Token;

import java.util.Iterator;
import java.util.List;

public class TokenInput implements Input<Token> {

    private Iterator<Token> tokenIterator;
    private Token current;


    public TokenInput(List<Token> tokens) {
        this.tokenIterator = tokens.iterator();
        this.consume();
    }

    @Override
    public void consume() {
        this.current = this.tokenIterator.next();
    }

    @Override
    public Token next() {
        return this.current;
    }

    @Override
    public boolean hasNext() {
        return tokenIterator.hasNext();
    }
}
