import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.jgrapht.DirectedGraph;
import org.jgrapht.alg.CycleDetector;
import org.jgrapht.alg.DijkstraShortestPath;
import org.jgrapht.graph.ClassBasedEdgeFactory;
import org.jgrapht.graph.DirectedSubgraph;
import org.jgrapht.graph.SimpleDirectedGraph;
import org.jgrapht.traverse.BreadthFirstIterator;

public class ComputeDominosGraph {

	private Set<String> pref;
	private Set<String> L;
	private Map<String, String> codeL = new HashMap<String, String>();
	DirectedGraph graph = new SimpleDirectedGraph<DominoVertex, DominoEdge>(
			new ClassBasedEdgeFactory<DominoVertex, DominoEdge>(
					DominoEdge.class));;

	// Compute dominos graph from a language
	public DirectedGraph compute(Set<String> _L, Map<String, String>_codeL) {
		L = _L;
		codeL = _codeL;
		// prefix of L
		int i =0;
		for (Iterator<String> count = L.iterator(); count.hasNext();) {
			 codeL.put(count.next(), ""+i);
			 i++;
			
		}

		pref = getPref();
		computeVertex();
		computeE1();
		computeE2();
		computeE3();
		computeE4();
		simplifyGraph();
		return graph;
	}

	// Compute vertex
	private void computeVertex() {
		DominoVertex vOpen = new DominoVertex("open", "");
		DominoVertex vClose = new DominoVertex("", "close");
		graph.addVertex(vOpen);
		graph.addVertex(vClose);
		// travelling prefix
		Iterator<String> prefItor = pref.iterator();
		while (prefItor.hasNext()) {
			String element = prefItor.next();
			DominoVertex v1 = new DominoVertex(element, "");
			DominoVertex v2 = new DominoVertex("", element);
			graph.addVertex(v1);
			graph.addVertex(v2);
		}
	}

	// Compute E1
	private void computeE1() {
		// all vertex
		Set<DominoVertex> vertex = graph.vertexSet();
		DominoVertex vOpen = null;

		for (Iterator<DominoVertex> vItor = vertex.iterator(); vItor.hasNext();) {
			DominoVertex element = vItor.next();
			if (element.getTop().equalsIgnoreCase("open")) {
				vOpen = element;
				break;
			}
		}

		for (Iterator<String> LItor = L.iterator(); LItor.hasNext();) {
			String element = LItor.next();
			for (Iterator<DominoVertex> vItor = vertex.iterator(); vItor
					.hasNext();) {
				DominoVertex vElement = vItor.next();
				if (vElement.getBottom().equalsIgnoreCase(element)) {
					graph.addEdge(vOpen, vElement,
							new DominoEdge<DominoVertex, DominoLabel>(vOpen,
									vElement, new DominoLabel(codeL.get(element), "")));
				}
			}
		}

	}

	// Compute E2
	private void computeE2() {
		// all vertex
		Set<DominoVertex> vertex = graph.vertexSet();
		DominoVertex vClose = null;

		for (Iterator<DominoVertex> vItor = vertex.iterator(); vItor.hasNext();) {
			DominoVertex element = vItor.next();
			if (element.getBottom().equalsIgnoreCase("close")) {
				vClose = element;
				break;
			}
		}

		for (Iterator<String> LItor = L.iterator(); LItor.hasNext();) {
			String element = LItor.next();
			for (Iterator<DominoVertex> vItor = vertex.iterator(); vItor
					.hasNext();) {
				DominoVertex vElement = vItor.next();
				if (vElement.getTop().equalsIgnoreCase(element)) {
					graph.addEdge(vElement, vClose,
							new DominoEdge<DominoVertex, DominoLabel>(
									vElement, vClose, new DominoLabel(codeL.get(element),
											"")));
				}
			}
		}

	}

	// Compute E3
	private void computeE3() {
		// all vertex
		Set<DominoVertex> vertex = graph.vertexSet();
		// all L
		for (Iterator<String> LItor = L.iterator(); LItor.hasNext();) {
			String element = LItor.next();
			// all vertex
			for (Iterator<DominoVertex> v1Itor = vertex.iterator(); v1Itor
					.hasNext();) {
				DominoVertex v1Element = v1Itor.next();
				// all vertex
				for (Iterator<DominoVertex> v2Itor = vertex.iterator(); v2Itor
						.hasNext();) {
					DominoVertex v2Element = v2Itor.next();
					// System.out.println("v1Element.getTop() + element = " +
					// v1Element.getTop() + element);
					if ((v1Element.getTop() + element)
							.equalsIgnoreCase(v2Element.getTop())
							&& !v1Element.getTop().equalsIgnoreCase("")) {
						DominoEdge edge = new DominoEdge<DominoVertex, DominoLabel>(
								v1Element, v2Element, new DominoLabel("",
										codeL.get(element)));
						graph.addEdge(v1Element, v2Element, edge);
					}
					// System.out.println("v1Element.getBottom() + element = " +
					// v1Element.getBottom() + element);
					if ((v1Element.getBottom() + element)
							.equalsIgnoreCase(v2Element.getBottom())
							&& !v1Element.getBottom().equalsIgnoreCase("")) {
						DominoEdge edge = new DominoEdge<DominoVertex, DominoLabel>(
								v1Element, v2Element, new DominoLabel(codeL.get(element),
										""));
						graph.addEdge(v1Element, v2Element, edge);
					}
				}

			}
		}
	}

	// Compute E4
	private void computeE4() {

		Set<DominoVertex> vertex = graph.vertexSet();
		// all L
		for (Iterator<String> LItor = L.iterator(); LItor.hasNext();) {
			String element = LItor.next();
			// all vertex
			for (Iterator<DominoVertex> v1Itor = vertex.iterator(); v1Itor
					.hasNext();) {
				DominoVertex v1Element = v1Itor.next();
				// all vertex
				for (Iterator<DominoVertex> v2Itor = vertex.iterator(); v2Itor
						.hasNext();) {
					DominoVertex v2Element = v2Itor.next();
					// System.out.println("v1Element.getTop() + element = " +
					// v1Element.getTop() + element);
					if ((v1Element.getTop() + v2Element.getBottom())
							.equalsIgnoreCase(element)
							&& !v1Element.getTop().equalsIgnoreCase("")
							&& !v2Element.getBottom().equalsIgnoreCase("")) {
						DominoEdge edge = new DominoEdge<DominoVertex, DominoLabel>(
								v1Element, v2Element, new DominoLabel(codeL.get(element),
										""));
						graph.addEdge(v1Element, v2Element, edge);
					}
					// System.out.println("v1Element.getBottom() + element = " +
					// v1Element.getBottom() + element);
					if ((v1Element.getBottom() + v2Element.getTop())
							.equalsIgnoreCase(element)
							&& !v1Element.getBottom().equalsIgnoreCase("")
							&& !v2Element.getTop().equalsIgnoreCase("")) {
						DominoEdge edge = new DominoEdge<DominoVertex, DominoLabel>(
								v1Element, v2Element, new DominoLabel("",
										codeL.get(element)));
						graph.addEdge(v1Element, v2Element, edge);
					}

				}

			}
		}
	}

	// Simplify
	private void simplifyGraph() {
		// first vertex
		DominoVertex vOpen = null;
		DominoVertex vClose = null;
		Set<DominoVertex> openConnectedSet = new LinkedHashSet<DominoVertex>();

		for (Iterator<DominoVertex> vItor = graph.vertexSet().iterator(); vItor
				.hasNext();) {
			DominoVertex element = vItor.next();
			if (element.getTop().equalsIgnoreCase("open")) {
				vOpen = element;
			}
			if (element.getBottom().equalsIgnoreCase("close")) {
				vClose = element;
			}
		}
		// get set of vertex connected from vOpen
		BreadthFirstIterator<DominoVertex, DominoEdge> breadthItor = new BreadthFirstIterator<DominoVertex, DominoEdge>(
				graph, vOpen);
		while (breadthItor.hasNext()) {
			openConnectedSet.add(breadthItor.next());
		}
		openConnectedSet.add(vClose);
		// Delete all vertex and its connecting edges which don't belong to
		// openConnectedSet
		graph = new DirectedSubgraph<DominoVertex, DominoEdge<DominoVertex, DominoLabel>>(
				graph, openConnectedSet, graph.edgeSet());

		// new all vertex
		Set<DominoVertex> allVertex = graph.vertexSet();
		// Get all vertex which connect to vClose
		Set<DominoVertex> vertexToClose = new LinkedHashSet<DominoVertex>();
		for (Iterator<DominoVertex> vItor = allVertex.iterator(); vItor.hasNext();) {
			DominoVertex element = vItor.next();
			if (DijkstraShortestPath.findPathBetween(graph, element, vClose) != null) {
				vertexToClose.add(element);
			}
		}
		// Get all left loop vertex
		//CycleDetector<DominoVertex, DominoEdge>
		CycleDetector<DominoVertex, DominoEdge> cycleDetector = new CycleDetector<DominoVertex, DominoEdge>(graph);
		Set<DominoVertex> loopVertex = cycleDetector.findCycles();
		
		// Get all left vertex which connect to all loop vertex
		Set<DominoVertex> vertexToLoop = new LinkedHashSet<DominoVertex>();
		for (Iterator<DominoVertex> vItor = allVertex.iterator(); vItor.hasNext();) {
			DominoVertex element = vItor.next();
			for (Iterator<DominoVertex> lItor = loopVertex.iterator(); lItor.hasNext();) {
				DominoVertex elementLoop = lItor.next();
				if (DijkstraShortestPath.findPathBetween(graph, element, elementLoop) != null) {
					vertexToLoop.add(element);
					break;
				}
			}
		}
		// Final graph
		Set<DominoVertex> selectedVertex = new LinkedHashSet<DominoVertex>();
		selectedVertex.addAll(vertexToClose);
		selectedVertex.addAll(loopVertex);
		selectedVertex.addAll(vertexToLoop);
		selectedVertex.add(vOpen);
		graph = new DirectedSubgraph<DominoVertex, DominoEdge<DominoVertex, DominoLabel>>(
				graph, selectedVertex, graph.edgeSet());
	}

	// Getting pref of string
	private Set<String> getPref() {
		Set<String> ret = new LinkedHashSet<String>();
		Iterator<String> itor = L.iterator();
		while (itor.hasNext()) {
			String str = itor.next();
			for (int i = 1; i <= str.length(); i++) {
				ret.add(str.substring(0, i));
			}
		}
		return ret;
	}
}
