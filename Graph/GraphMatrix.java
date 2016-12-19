package PracticeTest;

/**
 * Created by ignacioojanguren on 19/12/2016.
 *
 * Defining a graph by using a matrix.
 * There are two options,
 *  MATRIX: which you create a matrix with size of the number of vertices
 *          Disadvantages, about this type is that it uses more memory, as to store only ten elements the matrix
 *          will have 100 elements. Also it is harder to visualize the structure of the graph. The last disadvantage
 *          it has is that the matrix can not grow dynamically.
 *          Advantages, this method is faster and easier to implement. Faster because you access to the matrix by index.
 *
 *          0   1   2   3   4
 *          1   T   F   F   F
 *          2   F   T   T   F
 *          3   F   F   F   T
 *          4   F   F   T   F
 *
 *  LINKEDLIST: creating a linked list with pointers to the other vertices.
 *          Disadvantage, it is slower to access the values as the method would have to go over the elements in the linked list
 *          Advantage, the size is going to be smaller than the matrix.
 *
 *          1 -> 1 -> null
 *          2 -> 2 -> 3 -> null
 *          3 -> 4 -> null
 *          4 -> 3 -> null
 */

public class GraphMatrix<E> {

    private boolean[][] edges;
    private Object[] labels;

    public GraphMatrix(int size){
        edges = new boolean[size][size];
        labels = new Object[size];
    }

    /**
     * Changing the value from False to True, creating a new edge between two vertices.
     * @param source
     *  Which vertex is going to point to the other vertex.
     * @param target
     *  Target vertex that is going to be pointed.
     * @precondition
     *  The source and the target have to be valid values
     * @postcondition
     *  The value in the edge has changed to True
     * @throws IllegalArgumentException
     *  If the value of the edge does not exists throws the exception
     */
    public void addEdge(int source, int target){
        if(source > 0 && target > 0 && source <= labels.length && target <= labels.length)
            this.edges[source][target] = true;
        else
            throw new IllegalArgumentException("One or both of the edges introduced do not exist.");
    }

    /**
     * Changes the value from True to False in an edge.
     * @param source
     *  Vertex that is pointing to the next vertex
     * @param target
     *  Vertex that is been pointed
     * @precondition
     *  The source and the target have to have the same values
     * @postcondition
     *  The value has been changed to False
     * @throws IllegalArgumentException
     *  If the value of the edge does not exists throws the exception
     */
    public void removeEdge(int source, int target){
        if(source > 0 && target > 0 && source <= labels.length && target <= labels.length)
            this.edges[source][target] = false;
        else
            throw new IllegalArgumentException("One or both of the edges introduced do not exist.");
    }

    /**
     * Checks whether two vertices have an edge
     * @param source
     *  Vertex that is pointing to the next vertex
     * @param target
     *  Vertex that is been pointed
     * @precondition
     *  The source and the target have to have the same values
     * @return
     *  Returns true if there is an edge between those two edges
     *  Returns false if there is no edge in between them.
     * @throws IllegalArgumentException
     *  If the value of the edge does not exists throws the exception
     */
    public boolean isEdge(int source, int target){
        if(source > 0 && target > 0 && source <= labels.length && target <= labels.length)
            return this.edges[source][target];
        else
            throw new IllegalArgumentException("One or both of the edges introduced do not exist.");
    }

    /**
     * Gets the label a vertex has
     * @param vertex
     *  Position of the vertex we want to obtain the information on the label
     * @precondition
     *  The vertex has to exists
     * @return
     *  Returns the value of the label of that vertex
     * @throws IllegalArgumentException
     *  If the value of the edge does not exists throws the exception
     */
    public E getLabel(int vertex){
        if(vertex > 0 && vertex <= labels.length)
            return (E) labels[vertex];
        else
            throw new IllegalArgumentException("The vertex does not exists.");
    }

    /**
     * Sets a value to a vertex
     * @param vertex
     *  Position of the vertex we want to obtain the information on the label
     * @precondition
     *  The vertex has to exists
     * @postcondition
     *  The new value of the label has been changed
     * @throws IllegalArgumentException
     *  If the value of the edge does not exists throws the exception
     */
    public void setLabel(int vertex, E newLabel){
        if(vertex > 0 && vertex <= labels.length)
            labels[vertex] = newLabel;
        else
            throw new IllegalArgumentException("The vertex does not exists.");
    }

    /**
     * Gets the neighbors an edge has
     * @param vertex
     *  Vertex that we want to find the neighbors.
     * @precondition
     *  The vertex has to exists
     * @return
     *  Returns an array of integer with the number of the vertices the vertex is neighbor with.
     */
    public int[] neighbors(int vertex){
        int count = 0;
        int numberNeighbors[];
        if(vertex > 0 && vertex <= labels.length){
            for(int i = 0; i < edges[vertex].length; i++){
                if(edges[vertex][i])
                    count++;
            }

            numberNeighbors = new int[count];
            count = 0;
            for(int i = 0; i < edges[vertex].length; i++){
                if(edges[vertex][i])
                    numberNeighbors[count++] = i;
            }
            return numberNeighbors;
        }else
            throw new IllegalArgumentException("The vertex you introduced doesn't exist.");
    }

    /**
     * Gets the number of vertices there is in the graph.
     * @return
     *  Returns an integer with the number of vertices in the graph.
     */
    public int size(){
        return labels.length;
    }

}
