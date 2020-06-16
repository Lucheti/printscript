import common.FileReader.FileReader;
import common.FileReader.DefaultFileReader;
import common.provider.Provider;
import common.provider.TokenProvider;
import interpreter.Interpreter;
import interpreter.Terminal;
import lexer.DefaultLexer;
import parser.Parser;
import parser.nodes.ASTNode;
import lexer.tokens.Token;

import java.util.List;

public class CLI {
    public static void main(String[] args) {
        DefaultLexer lexer = new DefaultLexer();
        Parser parser = new Parser();
        Interpreter interpreter = new Interpreter(new Terminal());

        FileReader fileReader = new DefaultFileReader();
        List<Token> tokenStream = lexer.lex(fileReader.readFile("resources/FirstTry.ps"));
        Provider input = new TokenProvider(tokenStream);
        ASTNode ast = parser.parse(input);
        interpreter.start(ast);
    }
}
