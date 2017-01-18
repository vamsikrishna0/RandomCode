package crackingTheCodingInterview.helpers;

import java.util.ArrayList;

/**
 * Created by Vamsi on 1/12/2017.
 */
public class Graph {
    ArrayList<Node> nodes = new ArrayList<Node>();
    Node createNode(int id, int length){
        return new Node(id, length);
    }
}
