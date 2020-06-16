package tokenizer;

import tokens.Token;

public interface ITokenizer {
    boolean isValid();
    ITokenizer change(String str);
    Token getToken();
}
