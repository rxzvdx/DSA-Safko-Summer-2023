/*
 * SOURCE: geeksforgeeks.org; Salvino D'sa
 * Java program for Kruskal's algorithm, creating a 
 * Minimum Spanning Tree (MST)
 * 
 * 2. What is the process for generating on MCST using Prim's Algorithm?
	(Prim starts with vertices), pick the node to begin with, then starting
	from said node and continue adding nodes while not forming a cycle.

   3. ..... Kruskal's algorithm?
	(Kruskal starts with edges; lowest edge), build from there and do
	not form a cycle.
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MCSTKruskal 
{
	// Defines edge structure
	static class Edge 
	{
		int src, dest, weight;

		/**
		 * Constructs an edge with source, destination, and weight.
		 *
		 * @param src    Source vertex of the edge.
		 * @param dest   Destination vertex of the edge.
		 * @param weight Weight of the edge.
		 */
		public Edge(int src, int dest, int weight)
		{
			this.src = src;
			this.dest = dest;
			this.weight = weight;
		}
	}

	/*
	 * Defines the structure of a subset element.
	 */
	static class Subset 
	{
		int parent, rank;
		/**
		 * Constructs a subset element with parent and rank.
		 *
		 * @param parent Parent index of the subset element.
		 * @param rank   Rank of the subset element.
		 */
		public Subset(int parent, int rank)
		{
			this.parent = parent;
			this.rank = rank;
		}
	}

	/**
	 * Calculates the minimum spanning tree (MST) of a graph using Kruskal's algorithm.
	 * 
	 * Kruskal's algorithm finds the MST of a connected, undirected graph by iteratively
	 * adding edges with the smallest weights while avoiding the creation of cycles.
	 * 
	 * @param V The number of vertices in the graph.
	 * @param graph A 2D array representing the graph's edge weights. graph[i][j] represents
	 *              the weight of the edge between vertex i and vertex j. A weight of 0
	 *              indicates no edge between the vertices.
	 * @return A list of edges that form the minimum spanning tree of the graph.
	 */
	public List<Edge> kruskals(int V, int[][] graph) 
	{
		List<Edge> mstEdges = new ArrayList<>();
		Subset subsets[] = new Subset[V];

		for (int i = 0; i < V; i++) 
		{
			subsets[i] = new Subset(i, 0);
		}

		List<Edge> edges = new ArrayList<>();
		for (int i = 0; i < V; i++) 
		{
			for (int j = i + 1; j < V; j++) 
			{
				if (graph[i][j] != 0) 
				{
					edges.add(new Edge(i, j, graph[i][j]));
				}
			}
		}
		edges.sort(Comparator.comparingInt(edge -> edge.weight)); // Sort edges by weight
		for (Edge edge : edges) 
		{
			int x = findRoot(subsets, edge.src);
			int y = findRoot(subsets, edge.dest);

			if (x != y) 
			{
				mstEdges.add(edge);
				union(subsets, x, y);
			}
		}
		return mstEdges;
	}

	/**
	 * Function to unite two disjoint sets using union-by-rank heuristic.
	 *
	 * @param subsets Array representing subsets.
	 * @param x       Index of the first element.
	 * @param y       Index of the second element.
	 */
	private static void union(Subset[] subsets, int x, int y)
	{
		int rootX = findRoot(subsets, x);
		int rootY = findRoot(subsets, y);

		if (subsets[rootY].rank < subsets[rootX].rank) 
		{
			subsets[rootY].parent = rootX;
		}

		else if (subsets[rootX].rank < subsets[rootY].rank) 
		{
			subsets[rootX].parent = rootY;
		}

		else 
		{
			subsets[rootY].parent = rootX;
			subsets[rootX].rank++;
		}
	}

	/**
	 * Function to find the root of a subset using path compression heuristic.
	 *
	 * @param subsets Array representing subsets.
	 * @param i       Index of the element.
	 * @return Root index of the subset.
	 */
	private static int findRoot(Subset[] subsets, int i)
	{
		if (subsets[i].parent == i)
			return subsets[i].parent;

		subsets[i].parent = findRoot(subsets, subsets[i].parent);
		return subsets[i].parent;
	}
}
