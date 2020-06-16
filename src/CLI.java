import FileReader.FileReader;
import FileReader.DefaultFileReader;
import lexer.DefaultLexer;
import parser.Parser;
import parser.nodes.ASTNode;
import tokens.Token;

import java.util.List;

public class CLI {
    public static void main(String[] args) {
        DefaultLexer lexer = new DefaultLexer();
        Parser parser = new Parser();

        FileReader fileReader = new DefaultFileReader();
        List<Token> tokenStream = lexer.lex(fileReader.readFile("resources/FirstTry.ps"));
        ASTNode ast = parser.parse(tokenStream);
    }
}
