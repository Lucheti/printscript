package tokenParserFactory;

import tokenizer.Tokenizer;
import tokenParser.BaseTokenParser;
import tokenParser.TokenParser;
import tokenParser.TokenParserDecorator;

import java.util.Stack;

public class TokenParserFactory {

    public static TokenParser buildTokens(Stack<Tokenizer> tokenizers) {
        return buildTokensHelper(tokenizers, new BaseTokenParser());
    }

    private static TokenParser buildTokensHelper(Stack<Tokenizer> tokenizers, TokenParser prevTokenParser) {
        if (tokenizers.isEmpty()) return prevTokenParser;
        TokenParser newTokenParser = new TokenParserDecorator(tokenizers.pop(), prevTokenParser);
        return buildTokensHelper(tokenizers, newTokenParser);
    }
}
