package lexer;

import lexer.tokens.Token;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class DefaultLexerTest {

    Lexer lexer = new DefaultLexer();

    @Test
    public void lex() {
        String declaration = "let str: string = \"some string\";";
        List<Token> tokens = lexer.lex(declaration);
        Assert.assertEquals(tokens.size(), 8);
    }
}