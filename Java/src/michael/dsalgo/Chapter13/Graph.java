package michael.dsalgo.Chapter13;

import java.util.ArrayList;

public interface Graph<V, E> {
    Iterable<V> vertices();
    Iterable<E> edges();
    Iterable<E> incidentEdges(V v);
    V opposite(V v, E e);
    ArrayList<V> endVertices(E e);
    void replaceVertex(V v, Object x);
    void replaceEdge(E e, Object x);
    V insertVertex(Object x);
    E insertEdge(V v, V w, Object x);
    V removeVertex(V v);
    E removeEdge(E e);
}
