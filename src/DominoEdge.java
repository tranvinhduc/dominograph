import org.jgraph.graph.DefaultEdge;

// Labeled Edge
public class DominoEdge<V, L> extends DefaultEdge {
	private V v1;
	private V v2;
	private L label;

	public DominoEdge() {}	
	
	public DominoEdge(V v1, V v2, L label) {
		this.v1 = v1;
		this.v2 = v2;
		this.label = label;
	}

	public V getV1() {
		return v1;
	}

	public V getV2() {
		return v2;
	}
	
	public L getLabel() {
		return label;
	}

	public void setLabel(L label) {
		this.label = label;
	}

	public void setV1(V v1) {
		this.v1 = v1;
	}

	public void setV2(V v2) {
		this.v2 = v2;
	}
	
	public String toString() {
		return v1.toString() + "--" + label.toString() + "-->" + v2.toString() + ": ";
	}
}
