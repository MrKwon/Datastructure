//package michael.dsalgo.Chapter13;
//
//import java.util.LinkedList;
//
//public class EdgeListGraph<V, E> implements Graph<V, E>  {
//    public class VertexEle {
//        private V vO; // element
//        private Position<V> vP; // position
//
//        public VertexEle(V o, Position<V> vP) {
//            this.vO = o;
//            this.vP = vP;
//        }
//
//        public V getvO() {
//            return vO;
//        }
//
//        public void setvO(V vO) {
//            this.vO = vO;
//        }
//
//        public Position<V> getP() {
//            return vP;
//        }
//
//        public void setP(Position<V> vP) {
//            this.vP = vP;
//        }
//    }
//    public class EdgeEle {
//        E eO;
//        Position<E> eP;
//        VertexEle vertex1;
//        VertexEle vertex2;
//
//        public EdgeEle(E o, Position<E> eP, VertexEle vertex1, VertexEle vertex2) {
//            this.eO = o;
//            this.eP = eP;
//            this.vertex1 = vertex1;
//            this.vertex2 = vertex2;
//        }
//
//        public E geteO() {
//            return eO;
//        }
//
//        public void seteO(E eO) {
//            this.eO = eO;
//        }
//
//        public Position<E> geteP() {
//            return eP;
//        }
//
//        public void seteP(Position<E> eP) {
//            this.eP = eP;
//        }
//
//        public VertexEle getVertex1() {
//            return vertex1;
//        }
//
//        public void setVertex1(VertexEle vertex1) {
//            this.vertex1 = vertex1;
//        }
//
//        public VertexEle getVertex2() {
//            return vertex2;
//        }
//
//        public void setVertex2(VertexEle vertex2) {
//            this.vertex2 = vertex2;
//        }
//    }
//
//    private LinkedList<VertexEle> vertexList;
//    private LinkedList<EdgeEle> edgeList;
//
//    public EdgeListGraph(LinkedList<VertexEle> vertexList, LinkedList<EdgeEle> edgeList) {
//        this.vertexList = vertexList;
//        this.edgeList = edgeList;
//    }
//
//    @Override
//    public Iterable<V> vertices() {
//        LinkedList<V> vertices = new LinkedList<>();
//        for (VertexEle vertex : this.vertexList) {
//            vertices.add(vertex.vO);
//        }
//        return vertices;
//    }
//
//    @Override
//    public Iterable<E> edges() {
//        LinkedList<E> edges = new LinkedList<>();
//        for (EdgeEle edge : this.edgeList) {
//            edges.add(edge.eO);
//        }
//        return edges;
//    }
//
//    @Override
//    public Iterable<E> incidentEdges(V v) {
//        LinkedList<E> incidentEdges = new LinkedList<>();
//        for (EdgeEle edge : this.edgeList)
//            if (edge.vertex1 == v || edge.vertex2 == v)
//                incidentEdges.add(edge.eO);
//        return incidentEdges;
//    }
//
//    @Override
//    public V opposite(V v, E e) {
//        this.edgeList.indexOf(v)
//
//        return null;
//    }
//
//    @Override
//    public ArrayList<V> endVertices(E e) {
//        ArrayList<V> vertices = new ArrayList<>();
//        for (EdgeEle edge : this.edgeList)
//            if (edge.eO == e) {
//                vertices.add(edge.vertex1.vO);
//                vertices.add(edge.vertex2.vO);
//            }
//        return vertices;
//    }
//
//    @Override
//    public void replaceVertex(V v, Object x) {
//
//    }
//
//    @Override
//    public void replaceEdge(E e, Object x) {
//
//    }
//
//    @Override
//    public V insertVertex(Object x) {
//        return null;
//    }
//
//    @Override
//    public E insertEdge(V v, V w, Object x) {
//        return null;
//    }
//
//    @Override
//    public V removeVertex(V v) {
//        return null;
//    }
//
//    @Override
//    public E removeEdge(E e) {
//        return null;
//    }
//}
