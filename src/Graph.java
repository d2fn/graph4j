import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class Graph {

    final boolean directed;
    final List<Node> nodes;
    final Map<Node,Set<Node>> adjacency;

    Graph(boolean directed) {

        this.directed = directed;
        nodes = new ArrayList<Node>();

        // connections are stored
        adjacency = new HashMap<Node,Set<Node>>();
    }

    Node node(String name) {
        Node n = new Node(this,name);
        nodes.add(n);
        return n;
    }

    Graph connect(Node u, Node v) {

        Set<Node> edges = adj(u);
        edges.add(v);

        if(!directed && !adj(v).contains(u)) {
            connect(v,u);
        }

        return this;
    }

    Set<Node> adj(Node n) {
        if(!adjacency.containsKey(n)) {
            adjacency.put(n,new HashSet<Node>(nodes.size()));
        }
        return adjacency.get(n);
    }

    void dfs() {
        System.out.println("*** Beginning DFS on whole graph ***\n\n");

        for(Node n : nodes) {
            System.out.println("DFS("+n.name+") =>");
            // pre-visit times for all nodes
            Map<Node,Long> pre  = new HashMap<Node,Long>(nodes.size());
            // post-visit times for all nodes
            Map<Node,Long> post = new HashMap<Node,Long>(nodes.size());
            dfs(n,new HashSet<Node>(nodes.size()),pre,post,new AtomicLong(0));
            outputPrePost(pre,post);
            System.out.println();
            System.out.println();
        }

        System.out.println("*** Completed DFS ***");
    }

    // invariant - pre and post contain the same nodes as keys
    void outputPrePost(Map<Node,Long> pre, Map<Node,Long> post) {

        List<Map.Entry<Node,Long>> preEntries =
                new ArrayList<Map.Entry<Node,Long>>(pre.size());
        preEntries.addAll(pre.entrySet());
        Collections.sort(
                preEntries,
                new Comparator<Map.Entry<Node,Long>>() {
                    public int compare(Map.Entry<Node, Long> e1, Map.Entry<Node, Long> e2) {
                        if(e1.getValue().intValue() < e2.getValue().intValue()) {
                            return -1;
                        }
                        // never return 0
                        else return 1;
                    }
                });

        for(Map.Entry<Node,Long> entry : preEntries) {
            Node key = entry.getKey();
            long preTS = pre.get(key);
            long postTS = post.get(key);
            System.out.println("\t"+key.name + " ["+preTS+","+postTS+"]");
        }
    }

    void dfs(Node u, Set<Node> visited, Map<Node,Long> pre, Map<Node,Long> post, AtomicLong time) {

        visited.add(u);
        pre.put(u,time.incrementAndGet());

        for(Node n : adj(u)) {
            if(!visited.contains(n)) {
                dfs(n,visited,pre,post,time);
            }
        }

        post.put(u,time.incrementAndGet());
    }
}
