import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.LinkedHashMap;
import java.util.Map;

import org.jgrapht.DirectedGraph;
import org.jgrapht.ext.ComponentAttributeProvider;
import org.jgrapht.ext.DOTExporter;
import org.jgrapht.ext.IntegerNameProvider;

public class Exporter {

	// Export dominos graph to DOT file
	public void exportDOT(DirectedGraph graph, String fileName) {
		// writer
		StringWriter w = new StringWriter();
		// Vertex attribute provider
		ComponentAttributeProvider<DominoVertex> vertexAttributeProvider = new ComponentAttributeProvider<DominoVertex>() {
			public Map<String, String> getComponentAttributes(DominoVertex v) {
				Map<String, String> map = new LinkedHashMap<String, String>();
				map.put("label", v.getTop() + "/" + v.getBottom());
				return map;
			}
		};

		// Edge attribute provider
		ComponentAttributeProvider<DominoEdge<DominoVertex, DominoLabel>> edgeAttributeProvider 
																	= new ComponentAttributeProvider<DominoEdge<DominoVertex, DominoLabel>>() {
			public Map<String, String> getComponentAttributes(
					DominoEdge<DominoVertex, DominoLabel> e) {
				Map<String, String> map = new LinkedHashMap<String, String>();
				map.put("label", e.getLabel().getTop() + "/" + e.getLabel().getBottom());
				return map;
			}
		};

		DOTExporter<DominoVertex, DominoEdge<DominoVertex, DominoLabel>> exporter 
																= new DOTExporter<DominoVertex, DominoEdge<DominoVertex, DominoLabel>>(
				new IntegerNameProvider<DominoVertex>(), 
				null, 
				null,
				vertexAttributeProvider, 
				edgeAttributeProvider);
		exporter.export(w, graph);
		
		// Write to file
		try {
			FileWriter fileWriter = new FileWriter(new File(fileName));
			fileWriter.write(w.toString());
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//System.out.println("********************************");
		System.out.println(w.toString());
		//System.out.println("********************************");
		
	}
}
