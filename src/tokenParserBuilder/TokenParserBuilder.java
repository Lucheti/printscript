package tokenParserBuilder;

import token.Token;
import tokenParser.BaseTokenParser;
import tokenParser.TokenParser;
import tokenParser.TokenParserDecorator;

import java.util.Stack;

public class TokenParserBuilder {

    public static TokenParser buildTokens(Stack<Token> tokens) {
        return buildTokensHelper(tokens, new BaseTokenParser());
    }

    private static TokenParser buildTokensHelper(Stack<Token> tokens, TokenParser prevTokenParser) {
        if (tokens.isEmpty()) return prevTokenParser;
        TokenParser newTokenParser = new TokenParserDecorator(tokens.pop().withPriority(tokens.size()), prevTokenParser);
        return buildTokensHelper(tokens, newTokenParser);
    }
}
