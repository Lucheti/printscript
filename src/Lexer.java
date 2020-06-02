import token.Token;
import tokenParser.TokenParser;
import tokenParserBuilder.TokenParserBuilder;
import java.util.Stack;
import java.util.regex.Pattern;


public class Lexer {
    Stack<Token> tokenStack;
    TokenParser tokenParser;


    public Lexer() {
        tokenStack = new Stack<>();
        tokenStack.push(new Token(Pattern.compile(";", Pattern.MULTILINE),"EOL"));
        tokenStack.push(new Token(Pattern.compile(":", Pattern.MULTILINE),"TYPE_SYMBOL"));
        tokenStack.push(new Token(Pattern.compile("let", Pattern.MULTILINE),"LET"));
        tokenStack.push(new Token(Pattern.compile("const", Pattern.MULTILINE),"CONST"));
        tokenStack.push(new Token(Pattern.compile("=", Pattern.MULTILINE),"EQUAL_OPERATOR"));
        tokenStack.push(new Token(Pattern.compile("[0-9]+", Pattern.MULTILINE),"NUMBER"));
        tokenStack.push(new Token(Pattern.compile("\".*\"", Pattern.MULTILINE),"STRING"));
        tokenStack.push(new Token(Pattern.compile("true|false", Pattern.MULTILINE),"BOOLEAN"));
        tokenStack.push(new Token(Pattern.compile("number", Pattern.MULTILINE),"NUMBER_TYPE"));
        tokenStack.push(new Token(Pattern.compile("string", Pattern.MULTILINE),"STRING_TYPE"));
        tokenStack.push(new Token(Pattern.compile("boolean", Pattern.MULTILINE),"BOOLEAN_TYPE"));
        tokenStack.push(new Token(Pattern.compile("[a-zA-Z]+", Pattern.MULTILINE),"NAME"));

        tokenParser = TokenParserBuilder.buildTokens(tokenStack);
    }

    void tokenize(String str) {
        StringBuilder sb = new StringBuilder();
        Token currentToken = null;

        for (char ch: str.toCharArray()) {
            sb.append(ch);
            Token newToken = tokenParser.getToken(sb.toString());
            boolean noNewMatches = newToken == null && currentToken != null;
            boolean newMatchHasLowerPriority = currentToken != null && newToken != null && newToken.getPriority() > currentToken.getPriority();

            if (noNewMatches || newMatchHasLowerPriority) {
                sb = new StringBuilder(("" + ch).trim());
                System.out.println(currentToken);
                currentToken = tokenParser.getToken(sb.toString());
            }
            else currentToken = newToken;

        }
        System.out.println(tokenParser.getToken(sb.toString()));
    }
}

