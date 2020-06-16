package tokenizer.state;

import tokenizer.ITokenizer;

public interface TokenizerState extends ITokenizer {
    boolean isValid();
    TokenizerState change(String str);
}
