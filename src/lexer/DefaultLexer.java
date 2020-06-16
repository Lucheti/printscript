package lexer;

import tokens.*;
import tokenizer.Tokenizer;
import tokenParser.TokenParser;
import tokenParserFactory.TokenParserFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class DefaultLexer implements ILexer {
    Stack<Tokenizer> tokenizerStack;
    TokenParser tokenParser;


    public DefaultLexer() {
        tokenizerStack = new Stack<>();
//        tokenizerStack.push(new Tokenizer(Pattern.compile(";", Pattern.MULTILINE);
//        tokenizerStack.push(new Tokenizer(Pattern.compile(":", Pattern.MULTILINE);
//        tokenizerStack.push(new Tokenizer(Pattern.compile("let", Pattern.MULTILINE);
//        tokenizerStack.push(new Tokenizer(Pattern.compile("const", Pattern.MULTILINE);
//        tokenizerStack.push(new Tokenizer(Pattern.compile("=", Pattern.MULTILINE);
//        tokenizerStack.push(new Tokenizer(Pattern.compile("[0-9]+", Pattern.MULTILINE);
//        tokenizerStack.push(new Tokenizer(Pattern.compile("\".*\"", Pattern.MULTILINE);
//        tokenizerStack.push(new Tokenizer(Pattern.compile("true|false", Pattern.MULTILINE);
//        tokenizerStack.push(new Tokenizer(Pattern.compile("number", Pattern.MULTILINE);
//        tokenizerStack.push(new Tokenizer(Pattern.compile("string", Pattern.MULTILINE);
//        tokenizerStack.push(new Tokenizer(Pattern.compile("boolean", Pattern.MULTILINE);
//        tokenizerStack.push(new Tokenizer(Pattern.compile("[a-zA-Z]+", Pattern.MULTILINE);

        tokenizerStack.push(new Tokenizer(new EOLToken()));
        tokenizerStack.push(new Tokenizer(new TypeSeparatorToken()));
        tokenizerStack.push(new Tokenizer(new ConstToken()));
        tokenizerStack.push(new Tokenizer(new EqualsToken()));
        tokenizerStack.push(new Tokenizer(new StringTypeToken()));
        tokenizerStack.push(new Tokenizer(new StringValueToken()));
        tokenizerStack.push(new Tokenizer(new IdentifierToken()));

        tokenParser = TokenParserFactory.buildTokens(tokenizerStack);
    }

    public List<Token> lex(String str) {
        List<Token> tokens = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        Token currentToken = null;

        for (char ch: str.toCharArray()) {
            sb.append(ch);
            Token newToken = tokenParser.getToken(sb.toString());
            if (newToken == null && currentToken != null) {
                sb = new StringBuilder(("" + ch).trim());
                tokens.add(currentToken);
                currentToken = tokenParser.getToken(sb.toString());
            }
            else currentToken = newToken;
        }
        tokens.add(tokenParser.getToken(sb.toString()));
        return tokens;
    }
}

