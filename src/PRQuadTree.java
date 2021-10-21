import java.util.ArrayList;

public class PRQuadTree {

    public Node head;

    public static final int NORTH_WEST = 0;
    public static final int NORTH_EAST = 1;
    public static final int SOUTH_WEST = 2;
    public static final int SOUTH_EAST = 3;

    public static final Node emptyLeaf = new EmptyLeafNode();
    private Rectangle worldBox;

    public PRQuadTree(Rectangle rectangle) {
        worldBox = rectangle;

        head = new EmptyLeafNode();
    }

    public void insert(Point point) {

        head = insertHelp(head, point, worldBox);
    }

    private Node insertHelp(Node root, Point point, Rectangle region)
    {
        if (root instanceof EmptyLeafNode)
        {
            return new LeafNode(point);
        }

        if (root instanceof LeafNode)
        {
            LeafNode leaf = (LeafNode) root;
            leaf.add(point);

            if (leaf.canDecomp())
            {
                ArrayList<Point> points = leaf.getPoints();

                InternalNode node = new InternalNode();
                for (Point p : points)
                {
                    insertHelp(node, p, region);
                }

                return node;
            }
            return leaf;
        }


        InternalNode internal = (InternalNode) root;
        Rectangle[] rectangles = region.splitIntoRegions();

        for (int i = 0; i < rectangles.length; i++)
        {
            if (rectangles[i].contains(point))
            {
                internal.setRegion(i, insertHelp(internal.getRegion(i), point, rectangles[i]));
                break;
            }
        }

        return internal;
    }

    public Node getHead() {
        return head;
    }

    public Point remove(Point point)
    {
        return remove(point.getX(), point.getY());
    }

    public Point remove(int x, int y)
    {
        Point[] points = new Point[1];
        Point point = new Point(x, y);
        head = removeHelp(head, point, worldBox, points);
        return points[0];
    }

    private Node removeHelp(Node root, Point point, Rectangle region, Point[] rtn)
    {
        if (root instanceof EmptyLeafNode)
        {
            return emptyLeaf;
        }

        if (root instanceof LeafNode)
        {
            LeafNode leaf = (LeafNode) root;
            for (int i = 0; i < leaf.getPoints().size(); i++)
            {
                if(point.compareTo(leaf.getPoints().get(i)) == 0)
                {
                    rtn[0] = leaf.getPoints().remove(i);
                    break;
                }
            }

            if (leaf.getPoints().size() == 0)
            {
               return emptyLeaf;
            }

            return leaf;
        }

        InternalNode internalNode = (InternalNode) root;
        Rectangle[] rectangles = region.splitIntoRegions();

        for (int i = 0; i < rectangles.length; i++)
        {
            if (rectangles[i].contains(point))
            {
                internalNode.setRegion(i, removeHelp(internalNode.getRegion(i), point, rectangles[i], rtn));
                break;
            }
        }

        if (!internalNode.containsInternal())
        {
            int totalPoints = 0;
            int differentPoints = 0;
            for (int i = 0; i < 4; i++)
            {
                if (internalNode.getRegion(i) instanceof LeafNode)
                {
                    LeafNode leaf = (LeafNode) internalNode.getRegion(i);
                    totalPoints += leaf.getPoints().size();
                    differentPoints++;
                }
            }

            if (totalPoints < 4 || differentPoints < 2)
            {
                LeafNode leaf = new LeafNode();

                for (int i = 0; i < 4; i++)
                {
                    if(internalNode.getRegion(i) instanceof LeafNode)
                    {
                        LeafNode leafNode = (LeafNode) internalNode.getRegion(i);

                        for (Point p : leafNode.getPoints())
                        {
                            leaf.add(p);
                        }
                    }
                }

                return leaf;
            }
        }

        return internalNode;
    }

    public int regionSearch(Rectangle region, ArrayList<Point> points)
    {
        return regionSearchHelper(head, worldBox, points, region);
    }

    private int regionSearchHelper(Node root, Rectangle world, ArrayList<Point> points, Rectangle region)
    {
        if (root instanceof EmptyLeafNode)
        {
            return 0;
        }

        if (root instanceof LeafNode)
        {
            LeafNode leaf = (LeafNode) root;
            for (Point point : leaf.getPoints())
            {
                if (region.contains(point))
                {
                    points.add(point);
                }
            }

            return 1;
        }

        InternalNode internal = (InternalNode) root;

        Rectangle[] rectangles = world.splitIntoRegions();

        for (int i = 0; i < rectangles.length; i++)
        {
            if (region.compareTo(rectangles[i]) > 0)
            {
                return 1 + regionSearchHelper(internal.getRegion(i), rectangles[i], points, region);
            }
        }

        return 1;
    }

    public ArrayList<Point> duplicates()
    {
        ArrayList<Point> points = new ArrayList<>();

        duplicateHelper(head, points);
        return points;
    }

    private void duplicateHelper(Node root, ArrayList<Point> points)
    {
        if (root instanceof EmptyLeafNode)
        {
            return;
        }

        if (root instanceof LeafNode)
        {
            LeafNode leaf = (LeafNode) root;

            for (int i = 0; i < leaf.getPoints().size(); i++)
            {
                for (int k = i + 1; k < leaf.getPoints().size(); k++)
                {
                    if (leaf.getPoints().get(i).compareTo(leaf.getPoints().get(k)) == 0)
                    {
                        points.add(leaf.getPoints().get(i));
                    }
                }
            }

            return;
        }

        InternalNode internalNode = (InternalNode) root;

        for(int i = 0; i < 4; i++)
        {
            duplicateHelper(internalNode.getRegion(i), points);
        }
    }

    public void dump()
    {
    }
}
