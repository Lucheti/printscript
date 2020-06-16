package lexer;

import tokens.Token;

import java.util.List;

public interface ILexer {
    List<Token> lex(String str);
}
