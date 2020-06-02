import FileReader.FileReader;
import FileReader.DefaultFileReader;

public class CLI {
    public static void main(String[] args) {
        String asd = "asdasdas";

        Lexer lexer = new Lexer();
        FileReader fileReader = new DefaultFileReader();
        lexer.tokenize(fileReader.readFile("resources/printScript.ps"));
    }
}
