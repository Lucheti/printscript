package tokenizer;

import tokens.Token;
import tokenizer.state.InvalidState;
import tokenizer.state.TokenizerState;

public class Tokenizer implements ITokenizer {

    private TokenizerState state;

    public Tokenizer(Token token) {
        this.state = new InvalidState(token);
    }

    public Tokenizer(TokenizerState state) {
        this.state = state;
    }

    public boolean isValid() {
        return this.state.isValid();
    }

    public ITokenizer change(String str) {
        return new Tokenizer(this.state.change(str));
    }

    @Override
    public Token getToken() {
        return this.state.getToken();
    }

    @Override
    public String toString() {
        return "Tokenizer{" +
                "state=" + state +
                '}';
    }
}
