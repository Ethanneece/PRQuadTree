import java.util.ArrayList;

public class Point2 {

    public static void main(String[] args) {
        Rectangle worldBox = new Rectangle(0, 0, 1024, 1024);
        PRQuadTree tree = new PRQuadTree(worldBox);

        Point point = new Point("hi", 1, 1);

        tree.insert(point);
        tree.insert(point);
        tree.insert(point);
        tree.insert(point);

        tree.insert(new Point("hi", 700, 700));

        ArrayList<Point> points = tree.duplicates();

        System.out.println(tree.getHead());
    }
}
