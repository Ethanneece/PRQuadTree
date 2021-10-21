import java.util.ArrayList;

public class LeafNode extends Node {

    private ArrayList<Point> points;

    public LeafNode()
    {
        points = new ArrayList<>();
    }

    public LeafNode(Point point)
    {
        points = new ArrayList<Point>();
        points.add(point);
    }

    public void add(Point point)
    {
        points.add(point);
    }

    public boolean canDecomp()
    {

        if (points.size() < 4)
        {
            return false;
        }

        Point duplicate = points.get(0);

        for (int i = 1; i < points.size(); i++)
        {
            if (duplicate.compareTo(points.get(i)) != 0)
            {
                return true;
            }
        }

        return false;
    }

    public ArrayList<Point> getPoints()
    {
        return points;
    }

    @Override
    public boolean isLeaf() {
        return true;
    }

    @Override
    public boolean isEmptyLeaf() {
        return false;
    }

    @Override
    public String toString() {
        return "Leaf";
    }
}
