graph4j
=======

Be gentle, this entire codebase (all 3 classes) were written in about half an hour
to test some theories regarding graphs.  Hopefully this will come in handy in the
future and I may even convert these to Scala if the mood strikes me.

Also, I'm aware that there are lots of graphing libraries out there.  But this
one is mine.  And it's a good learning tool.

Two classes:

Graph - represents a graph.  indicate in the constructor whether or not the 
edges are directed

Node - use Graph.node(), don't build your own,  See below

## Construction ##

* .node(name:String) <-- adds a new node to the graph and returns a reference
* .connect(u:Node,v:Node) <-- connects the two nodes
* .adj(n:Node) <-- returns the nodes adjacent to n

## Inspection ##
.dfs()
perform a depth-first search on each node in the graph outputing
the pre and post-visit times for each to standard out

## Example Use ##

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

This will output the following (only showing output for A)

	DFS(A) =>
        	A [1,30]
        	B [2,29]
        	D [3,24]
        	C [4,5]
        	M [6,7]
        	E [8,23]
        	K [9,22]
        	L [10,21]
        	J [11,20]
        	I [12,19]
        	H [13,18]
        	G [14,17]
        	F [15,16]
        	N [25,28]
        	O [26,27]


## Future Possibilities ##

* Add BFS support for shortest path checking
* Dijkstra support for route optimization
* Improved rendering of searches (a la ASCII art)

