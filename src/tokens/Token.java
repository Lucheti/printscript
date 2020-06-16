package tokens;

import parser.IParserVisitor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Token implements VisitableToken {

    private Pattern pattern;
    private String lexeme;
    private Integer line;
    private Integer column;

    Token(Pattern pattern) {
        this.pattern = pattern;
        this.lexeme = null;
    }

    Token(Pattern pattern, String lexeme) {
        this.pattern = pattern;
        this.lexeme = lexeme;
    }

    public Matcher getMatcher(String string){
        return pattern.matcher(string);
    }

    public abstract Token withValue(String value);

    public Integer getLine() {
        return line;
    }

    public void setLine(Integer line) {
        this.line = line;
    }

    public Integer getColumn() {
        return column;
    }

    public void setColumn(Integer column) {
        this.column = column;
    }

    public String getLexeme() {
        return lexeme;
    }

    public void setLexeme(String lexeme) {
        this.lexeme = lexeme;
    }
}
