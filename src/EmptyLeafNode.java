public class EmptyLeafNode extends Node {

    public EmptyLeafNode()
    {
    }

    @Override
    public boolean isLeaf() {
        return true;
    }

    @Override
    public boolean isEmptyLeaf() {
        return true;
    }

    @Override
    public String toString() {
        return "Empty";
    }
}
