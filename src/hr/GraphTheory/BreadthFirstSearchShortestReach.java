package hr.GraphTheory;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;


/**
 * @author Vamsi
 *
 *This is shortest path using only BFS. 
 * .The elements are added to the queue while BFS traversal
 * .after each level of graph(from the start) an element is polled from the queue and the loop continues
 * .The loop stops once the queue is empty.
 */
public class BreadthFirstSearchShortestReach {

	static HashMap<Integer, HashSet<Integer>> graph;
	static int[] shortestDistances;
	static boolean[] seen;
	static LinkedList<Integer> queue;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();

			shortestDistances = new int[n + 1];
			graph = new HashMap<>();
			queue = new LinkedList<>();
			seen = new boolean[n + 1];
			seen[0] = true;
			while (m > 0) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				if (!graph.containsKey(a))
					graph.put(a, new HashSet<>());
				graph.get(a).add(b);

				if (!graph.containsKey(b))
					graph.put(b, new HashSet<>());
				graph.get(b).add(a);
				m--;
			}
			int start = sc.nextInt();
			seen[start] = true;
			queue.add(start);
			shortestDistanceUsingBFS();

			for (int i = 0; i < shortestDistances.length; i++) {
				if (i == start || i == 0)
					continue;
				if (shortestDistances[i] == 0)
					System.out.print(-1 + " ");
				else
					System.out.print(shortestDistances[i] + " ");
			}
			System.out.println();
			t--;
		}

		sc.close();
	}

	private static void shortestDistanceUsingBFS() {
		int start;
		while (!queue.isEmpty()) {
			start = queue.poll();
			if (graph.containsKey(start)) {
				for (int b : graph.get(start)) {
					if (!seen[b]) {
						seen[b] = true;
						queue.add(b);
						shortestDistances[b] = shortestDistances[start] + 6;
					}
				}	
			}
		}
	}

}
