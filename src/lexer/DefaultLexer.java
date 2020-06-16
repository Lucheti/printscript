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

        //symbols
        tokenizerStack.push(new Tokenizer(new EOFToken()));
        tokenizerStack.push(new Tokenizer(new SemicolonToken()));
        tokenizerStack.push(new Tokenizer(new TypeAssignationToken()));
        tokenizerStack.push(new Tokenizer(new LetToken()));
        tokenizerStack.push(new Tokenizer(new StringTypeToken()));
        tokenizerStack.push(new Tokenizer(new NumberTypeToken()));
        tokenizerStack.push(new Tokenizer(new AssignationToken()));
        tokenizerStack.push(new Tokenizer(new ClosingParenthesisToken()));
        tokenizerStack.push(new Tokenizer(new OpenParenthesisToken()));
        tokenizerStack.push(new Tokenizer(new DivisionToken()));
        tokenizerStack.push(new Tokenizer(new MinusToken()));
        tokenizerStack.push(new Tokenizer(new PlusToken()));
        tokenizerStack.push(new Tokenizer(new MultiplicationToken()));
        tokenizerStack.push(new Tokenizer(new PrintToken()));

        //values
        tokenizerStack.push(new Tokenizer(new NumberValueToken()));
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
        tokens.add(new EOFToken());
        return tokens;
    }
}

