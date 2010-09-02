public class Node implements Comparable {

    Graph g;
    String name;

    public Node(Graph g, String name) {
        this.g = g;
        this.name = name;
    }

    public int compareTo(Object o) {
        return name.compareTo(((Node)o).name);
    }
}
