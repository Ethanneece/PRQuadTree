import sun.invoke.empty.Empty;

public class InternalNode extends Node {

    Node NW;
    Node NE;
    Node SW;
    Node SE;

    public InternalNode()
    {
        NW = PRQuadTree.emptyLeaf;
        NE = PRQuadTree.emptyLeaf;
        SW = PRQuadTree.emptyLeaf;
        SE = PRQuadTree.emptyLeaf;
    }


    public Node getRegion(int region)
    {
        switch (region) {
            case PRQuadTree.NORTH_WEST:
                return NW;
            case PRQuadTree.NORTH_EAST:
                return NE;
            case PRQuadTree.SOUTH_WEST:
                return SW;
            default:
                return SE;
        }
    }

    public boolean containsInternal()
    {
        return NW instanceof InternalNode || NE instanceof InternalNode ||
                SW instanceof InternalNode || SE instanceof InternalNode;
    }

    public void setRegion(int region, Node quadNode)
    {
        switch (region) {
            case PRQuadTree.NORTH_WEST:
                NW = quadNode;
                break;
            case PRQuadTree.NORTH_EAST:
                NE = quadNode;
                break;
            case PRQuadTree.SOUTH_WEST:
                SW = quadNode;
                break;
            default:
                SE = quadNode;
        }
    }

    @Override
    public boolean isLeaf() {
        return false;
    }

    @Override
    public boolean isEmptyLeaf() {
        return false;
    }


    @Override
    public String toString() {
        return "Internal";
    }
}
