public class HW1App {

    public static void main(String[] args) throws Exception {

        Graph G = new Graph(false);

        Node a = G.node("A");
        Node b = G.node("B");
        Node c = G.node("C");
        Node d = G.node("D");
        Node e = G.node("E");
        Node f = G.node("F");
        Node g = G.node("G");
        Node h = G.node("H");
        Node i = G.node("I");
        Node j = G.node("J");
        Node k = G.node("K");
        Node l = G.node("L");
        Node m = G.node("M");
        Node n = G.node("N");
        Node o = G.node("O");

        G.connect(a,b).connect(a,o)
         .connect(b,n).connect(b,d)
         .connect(n,o).connect(d,c)
         .connect(d,m).connect(d,e)
         .connect(e,k)
         .connect(k,l).connect(k,j)
         .connect(l,j)
         .connect(j,i)
         .connect(i,f).connect(i,h)
         .connect(f,g).connect(g,h);

        G.dfs();
    }
}
