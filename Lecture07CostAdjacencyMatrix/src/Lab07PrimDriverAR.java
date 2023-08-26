public class Lab07PrimDriverAR 
{
	public static void main(String[] args)
	{
		MCSTPrim t = new MCSTPrim(); // A  B  C  D  E
		int graph[][] = new int[][] { { 0, 2, 0, 6, 0 }, 	// A
									  { 2, 0, 3, 8, 5 },	// B
									  { 0, 3, 0, 0, 7 },	// C
									  { 6, 8, 0, 0, 9 },	// D
									  { 0, 5, 7, 9, 0 } };  // E
		/*
		 * A -> B = 2
		 * A -> D = 6
		 * B -> A = 2
		 * B -> C = 3
		 * B -> D = 8
		 * B -> E = 5
		 * C -> B = 3
		 * C -> E = 7
		 * D -> A = 6
		 * D -> B = 8
		 * D -> E = 9
		 * E -> B = 5
		 * E -> C = 7
		 * E -> D = 9
		 */
		// Print the solution
		System.out.println("Following are the edges of the constructed MST:");
		t.primMCST(graph);
	}
}
