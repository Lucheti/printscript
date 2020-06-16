package tokenParser;

import tokens.Token;

public interface TokenParser {
    public Token getToken(String str);
}
