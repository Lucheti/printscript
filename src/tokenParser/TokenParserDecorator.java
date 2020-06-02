package tokenParser;
import token.Token;

import java.util.regex.Matcher;

public class TokenParserDecorator implements TokenParser {

    private Token token;
    private TokenParser decoratedTokenParser;

    public TokenParserDecorator(Token token, TokenParser decoratedTokenParser) {
        this.token = token;
        this.decoratedTokenParser = decoratedTokenParser;
    }


    @Override
    public Token getToken(String str) {
        Matcher matcher = token.getPattern().matcher(str);
        if (matcher.find() && matcher.group(0).equals(str)) {
            return token.withValue(str);
        }
        return decoratedTokenParser.getToken(str);
    }
}
