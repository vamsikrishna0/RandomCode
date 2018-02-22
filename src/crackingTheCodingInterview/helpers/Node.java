package crackingTheCodingInterview.helpers;

import java.util.ArrayList;

/**
 * Created by Vamsi on 1/13/2017.
 */
public class Node {
    int id;
    int length;

    public Node(int id, int length) {
        this.id = id;
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    ArrayList<Node> adjacent = new ArrayList<Node>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Node> getAdjacent() {
        return adjacent;
    }

    public void setAdjacent(ArrayList<Node> adjacent) {
        this.adjacent = adjacent;
    }

}
