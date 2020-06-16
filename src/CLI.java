import FileReader.FileReader;
import FileReader.DefaultFileReader;
import input.Input;
import input.TokenInput;
import interpreter.Interpreter;
import interpreter.Terminal;
import lexer.DefaultLexer;
import parser.Parser;
import parser.nodes.ASTNode;
import tokens.Token;
import tokens.VisitableToken;

import java.util.List;

public class CLI {
    public static void main(String[] args) {
        DefaultLexer lexer = new DefaultLexer();
        Parser parser = new Parser();
        Interpreter interpreter = new Interpreter(new Terminal());

        FileReader fileReader = new DefaultFileReader();
        List<Token> tokenStream = lexer.lex(fileReader.readFile("resources/FirstTry.ps"));
        Input input = new TokenInput(tokenStream);
        ASTNode ast = parser.parse(input);
        interpreter.start(ast);
    }
}
