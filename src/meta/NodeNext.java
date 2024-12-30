package meta;

public class NodeNext {
    public int val;
    public NodeNext next;

    public NodeNext() {}

    public NodeNext(int _val) {
        val = _val;
    }

    public NodeNext(int _val, NodeNext _next) {
        val = _val;
        next = _next;
    }
}
