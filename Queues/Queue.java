/**
 * Created by ignacioojanguren on 2/11/16.
 *
 * This class is a Queue of elements.
 * A Queue is a data structure were data in inserted at the end and removed from the other end
 *
 *  A <(Front)- B|C|D|E <(Rear)- F
 *
 */
public class Queue<E> {

    private Node<E> front;
    private Node<E> rear;
    private int size;

    public static class Node<E>{
        private E valueNode;
        private Node<E> prevLink;
        private Node<E> nextLink;

        public Node(E valueNode){
            this.valueNode = valueNode;
            this.prevLink = null;
            this.nextLink = null;
        }

        /**
         * Sets the value of the node
         * @param valueNode
         *  Value of the node it can be any type
         */
        public void setValueNode(E valueNode){
            this.valueNode = valueNode;
        }

        /**
         * Sets the node previous to the current one.
         * @param prevLink
         *  Node located before
         */
        public void setPrevLink(Node<E> prevLink){
            this.prevLink = prevLink;
        }

        /**
         * Sets the next node to the previous one.
         * @param nextLink
         *  It is the node that will follow the next node.
         */
        public void setNextLink(Node<E> nextLink){
            this.nextLink = nextLink;
        }

        /**
         * @return
         *  the value of the current node is returned
         */
        public E getValueNode(){
            return this.valueNode;
        }

        /**
         * @return
         *  the value of the previous node is returned
         */
        public Node<E> getPrevLink(){
            return this.prevLink;
        }

        /**
         * @return
         *  the value of the next node
         */
        public Node<E> getNextLink(){
            return this.nextLink;
        }
    }

    public Queue(){
        this.front = null;
        this.rear = null;
        size = 0;
    }

    /**
     * Adds a new node to the Queue
     * @param item
     *  item is the new node that will be added in the Queue
     */
    public void add(Node<E> item){
        if(this.front.equals(null) && this.rear.equals(null)){
            this.front = item;
            this.rear = item;
            size++;
        }else{
            this.rear = item;
            size++;
        }
    }

    /**
     * Checks if the Queue is empty
     * @return
     *  True is the Queue is empty
     *  False if the Queue is not empty
     */
    public boolean isEmpty(){
        if(size == 0 && this.rear.equals(null)) return true;
        else return false;
    }

    /**
     * Removes the element in the front of the Queue
     * @return
     *  Returns the Node removed from the front of the Queue
     */
    public Node<E> remove(){
        Node <E> removedElement;
        if(this.front.equals(null) && this.rear.equals(null))
            throw new IllegalArgumentException("The Queue is empty");
        else{
            removedElement = this.front;
            this.front = removedElement.getNextLink();
            size--;
        }
        return removedElement;
    }

    /**
     * Indicates the size of the Queue
     * @return
     *  An integer with the size of the Queue.
     */
    public int size(){
        return this.size;
    }
}
