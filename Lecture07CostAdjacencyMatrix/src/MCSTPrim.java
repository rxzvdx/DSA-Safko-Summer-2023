/*
 * SOURCE: geeksforgeeks.org; Aakash Hasija
 * A Java program for Prim's Minimum Spanning Tree (MST)
 * algorithm. The program is for adjacency matrix
 * representation of the graph
 * 
 * 
 * 2. What is the process for generating on MCST using Prim's Algorithm?
	(Prim starts with vertices), pick the node to begin with, then starting
	from said node and continue adding nodes while not forming a cycle.
	
   3. ..... Kruskal's algorithm?
	(Kruskal starts with edges; lowest edge), build from there and do
	not form a cycle.
 */

import java.io.*;
import java.lang.*;
import java.util.*;
@SuppressWarnings("unused")

/**
 * This class implements Prim's Minimum Spanning Tree (MST) algorithm
 * for a graph represented using an adjacency matrix. It can find the
 * minimum spanning tree of the given graph and print the edges and
 * their corresponding weights in the MST.
 */
public class MCSTPrim
{

	// Number of vertices in the graph
	private static final int V = 5;

	/**
	 * Finds the vertex with the minimum key value from the set of vertices
	 * not yet included in the Minimum Spanning Tree (MST).
	 *
	 * @param key An array of key values for each vertex.
	 * @param mstSet An array indicating whether a vertex is already in the MST.
	 * @return The index of the vertex with the minimum key value.
	 */
	public int minKey(int key[], Boolean mstSet[])
	{
		// Initialize min value
		int min = Integer.MAX_VALUE, min_index = -1;

		for (int v = 0; v < V; v++)
			if (mstSet[v] == false && key[v] < min) 
			{
				min = key[v];
				min_index = v;
			}

		return min_index;
	}

	/**
	 * Prints the edges and their corresponding weights of the constructed
	 * Minimum Spanning Tree (MST) stored in the parent array.
	 *
	 * @param parent An array representing the parent of each vertex in the MST.
	 * @param graph An adjacency matrix representation of the graph.
	 */
	public void printMCST(int parent[], int graph[][])
	{
		int cost = 0;
		System.out.println("Edge \tWeight");
		for (int i = 1; i < V; i++)
		{
			System.out.println(parent[i] + " -- " + i + "\t"
					+ graph[i][parent[i]]);
			cost += graph[i][parent[i]];
		}
		System.out.println("Total cost of MST: " + cost);

	}

	/**
	 * Constructs and prints the Minimum Spanning Tree (MST) for a graph
	 * represented using an adjacency matrix representation.
	 *
	 * @param graph An adjacency matrix representation of the graph.
	 */
	public void primMCST(int graph[][])
	{
		// Array to store constructed MST
		int parent[] = new int[V];

		// Key values used to pick minimum weight edge in
		// cut
		int key[] = new int[V];

		// To represent set of vertices included in MST
		Boolean mstSet[] = new Boolean[V];

		// Initialize all keys as INFINITE
		for (int i = 0; i < V; i++) 
		{
			key[i] = Integer.MAX_VALUE;
			mstSet[i] = false;
		}

		// Always include first 1st vertex in MST.
		// Make key 0 so that this vertex is
		// picked as first vertex
		key[0] = 0;

		// First node is always root of MST
		parent[0] = -1;

		// The MST will have V vertices
		for (int count = 0; count < V - 1; count++) 
		{

			// Pick the minimum key vertex from the set of
			// vertices not yet included in MST
			int u = minKey(key, mstSet);

			// Add the picked vertex to the MST Set
			mstSet[u] = true;

			// Update key value and parent index of the
			// adjacent vertices of the picked vertex.
			// Consider only those vertices which are not
			// yet included in MST
			for (int v = 0; v < V; v++)

				// graph[u][v] is non zero only for adjacent
				// vertices of m mstSet[v] is false for
				// vertices not yet included in MST Update
				// the key only if graph[u][v] is smaller
				// than key[v]
				if (graph[u][v] != 0 && mstSet[v] == false
				&& graph[u][v] < key[v]) 
				{
					parent[v] = u;
					key[v] = graph[u][v];
				}
		}
		// Print the constructed MST
		printMCST(parent, graph);
	}
}