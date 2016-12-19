package PracticeTest;

/**
 * Created by ignacioojanguren on 19/12/2016.
 *
 * This contains a deapth search from all the elements given a vertex.
 */
public class DepthSearch {

    public static <E> void depthFirstPrint(GraphMatrix<E> g, int start){
        boolean [] marked = new boolean[g.size()];

        depthFirstRecursive(g, start, marked);
    }

    public static <E> void depthFirstRecursive(GraphMatrix<E> g, int start, boolean[] marked){
        int [] connections = g.neighbors(start);

        marked[start] = true;
        System.out.println(g.getLabel(start));

        for(int nextNeighbor : connections){
            if(!marked[nextNeighbor])
                depthFirstRecursive(g, nextNeighbor, marked);
        }

    }

}
