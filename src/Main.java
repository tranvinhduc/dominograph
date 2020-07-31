import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import org.jgrapht.DirectedGraph;


public class Main {
	
	// Main
	public static void main(String[] args) {
		
		Set<String> L = new LinkedHashSet<String>();
		 Map<String, String> codeL = new HashMap<String, String>(); //  coding function
		
		Exporter exporter = new Exporter();
		ComputeDominosGraph computeDominosGraph = new ComputeDominosGraph();

		// Get input string
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(
					System.in));
			System.out.print("Input:");
			String input = in.readLine();
			// System.out.println("InputString: " + input);
			
			int i = 0;
			StringTokenizer tokenizer = new StringTokenizer(input);
			while (tokenizer.hasMoreTokens()) {
				String element = tokenizer.nextToken();
				L.add(element);
				 codeL.put(element, ""+i);
				 i++;
			}
		} catch (IOException io) {
			io.printStackTrace();
		}
		
		// Compute dominos graph
		DirectedGraph graph = computeDominosGraph.compute(L, codeL);
		// Exporting
		exporter.exportDOT(graph, "graph.dot");
	}


}
