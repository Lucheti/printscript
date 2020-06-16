package tokenParser;
import tokenizer.ITokenizer;
import tokenizer.Tokenizer;
import tokens.Token;

public class TokenParserDecorator implements TokenParser {

    private ITokenizer tokenizer;
    private TokenParser decoratedTokenParser;

    public TokenParserDecorator(Tokenizer tokenizer, TokenParser decoratedTokenParser) {
        this.tokenizer = tokenizer;
        this.decoratedTokenParser = decoratedTokenParser;
    }


    @Override
    public Token getToken(String str) {
        this.tokenizer = tokenizer.change(str);
        if (tokenizer.isValid()) {
            return tokenizer.getToken();
        }
        else return decoratedTokenParser.getToken(str);
    }
}
