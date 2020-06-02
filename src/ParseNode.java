public class ParseNode {
    ParseNode left;
    ParseNode right;
    String elem;

    public ParseNode() {
    }

    public ParseNode(ParseNode left, ParseNode right, String elem) {
        this.left = left;
        this.right = right;
        this.elem = elem;
    }
}
