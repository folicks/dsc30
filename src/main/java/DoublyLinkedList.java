/*
 * NAME: Felix Najera
 * PID: A17618969
 */

import java.util.AbstractList;

/**
 * TODO
 * @author Felix Najera
 * @since ${8/8/24}
 */
public class DoublyLinkedList<T> extends AbstractList<T> {

    /* DLL instance variables */
    private int size;
    private Node<T> head; // This will be our dummy head
    private Node<T> tail;

    /**
     * Node for chaining together to create a linked list
     */
    protected class Node<T> {

        /* Node instance variables */
        private T element;
        private Node<T> next;
        private Node<T> prev;

        /**
         * Constructor to create singleton Node
         */
        private Node(T element) {
            // TODO: complete constructor
            this.element = element;
            this.next = null;
            this.prev = null;

            
        }

        /**
         * Constructor to create singleton link it between previous and next
         *
         * @param element  Element to add, can be null
         * @param nextNode successor Node, can be null
         * @param prevNode predecessor Node, can be null
         */
        private Node(T element, Node<T> nextNode, Node<T> prevNode) {
            // TODO: complete implementation
            this.element = element;
            this.next = nextNode;
            this.prev = prevNode;


            
        }

        /**
         * Set the element
         *
         * @param element new element
         */
        public void setElement(T element) {
            // TODO: complete implementation
            this.element = element;
        }

        /**
         * Accessor to get the Nodes Element
         */
        public T getElement() {
            // TODO: complete implementation
            return this.element;
        }

        /**
         * Set the next node in the list
         *
         * @param n new next node
         */
        public void setNext(Node<T> n) {
            // TODO: complete implementation
            this.next = n;
        }

        /**
         * Get the next node in the list
         *
         * @return the successor node
         */
        public Node<T> getNext() {
            // TODO: complete implementation
            return this.next;
        }

        /**
         * Set the previous node in the list
         *
         * @param p new previous node
         */
        public void setPrev(Node<T> p) {
            // TODO: complete implementation
            this.prev = p;
        }


        /**
         * Accessor to get the prev Node in the list
         *
         * @return predecessor node
         */
        public Node<T> getPrev() {
            // TODO: complete implementation
            return this.prev;
        }

        /**
         * Remove this node from the list.
         * Update previous and next nodes
         */
        public void remove() {
            // TODO: complete implementation
            if (this.prev != null) {
                this.prev.next = this.next;
            }
            if (this.next != null) {
                this.next.prev = this.prev;
            }
            this.prev = null;
            this.next = null;
        }
    }

/*ENNNND OF FIRST CLASSSSSS 
 * prococoodeeee
*/

    
    /**
     * Creates a new, empty doubly-linked list.
     */
    public DoublyLinkedList() {
        // TODO: complete default constructor

        head = new Node<>(null);
        tail = new Node<>(null);
        // Link them together
        head.setNext(tail);
        tail.setPrev(head);
        size = 0;
    }

    /**
     * Add an element to the end of the list
     *
     * @param element data to be added
     * @return whether or not the element was added
     * @throws NullPointerException if data received is null
     */
    @Override
    public boolean add(T element) throws NullPointerException {
        // TODO: Implementation for throwing exceptions followed by
        // implementation of adding the new data
         if (element == null) {
            throw new NullPointerException("Cannot add null element");
        }
        Node<T> newNode = new Node<>(element);
        Node<T> lastNode = tail.getPrev();
        newNode.setPrev(lastNode);
        newNode.setNext(tail);
        lastNode.setNext(newNode);
        tail.setPrev(newNode);
        size++;
        return true;
    }


    /**
     * Adds an element to a certain index in the list, shifting exist elements
     * create room. Does not accept null values.
     *
     * 
     */
    @Override
    public void add(int index, T element)
            throws IndexOutOfBoundsException, NullPointerException {
        // TODO: Implementation for throwing exceptions followed by
        // implementation of adding the new data
        // if (index < 0 || index > size) {
        //     throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        // }
        // if (element == null) {
        //     throw new NullPointerException("Cannot add null element");
        // }
        // if (index == size) {
        //     add(element);
        //     return;
        // }
        
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (element == null) {
            throw new NullPointerException("Cannot add null element");
        }
        Node<T> newNode = new Node<>(element);
        Node<T> nextNode = (index == size) ? tail : getNth(index);
        Node<T> prevNode = nextNode.getPrev();
        newNode.setPrev(prevNode);
        newNode.setNext(nextNode);
        prevNode.setNext(newNode);
        nextNode.setPrev(newNode);
        size++;
        
    }

    /**
     * Clear the linked list
     */
    @Override
    public void clear() {
        // TODO: implement clear
        head.setNext(tail);
        tail.setPrev(head);
        size = 0;
    }

    /**
     * Determine if the list contains the data element anywhere in the list.
     *
     * TODO: Javadoc comments
     */
    @Override
    public boolean contains(Object element) {
        T data = (T) element;
        // TODO: Fill in implementation
        Node<T> current = head.getNext();
    while (current != tail) {
        if (current.getElement() != null && current.getElement().equals(data)) {
            return true;
        }
        current = current.getNext();
    }
    return false;
    }

    /**
     * Retrieves the element stored with a given index on the list.
     *
     * TODO: Javadoc comments
     */
    @Override
    public T get(int index) throws IndexOutOfBoundsException {
        // TODO: Fill in implementation to get the node at index
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (T) getNth(index).getElement();
    }

    /**
     * Helper method to get the Nth node in our list
     *
     * TODO: Javadoc comments
     */
    private Node getNth(int index) {
        // TODO: implement
        Node<T> current;
        if (index < size / 2) {
            current = head.getNext();
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
        } else {
            current = tail.getPrev();
            for (int i = size - 1; i > index; i--) {
                current = current.getPrev();
            }
        }
        return current;
    }

    /**
     * Determine if the list empty
     *
     * TODO: javadoc comments
     */
    @Override
    public boolean isEmpty() {
        // TODO: implement isEmpty
        return size == 0;
    }

    /**
     * Remove the element from position index in the list
     *
     * TODO: javadoc comments
     */
    @Override
    public T remove(int index) throws IndexOutOfBoundsException {
        // TODO: Fill in implementation
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<T> nodeToRemove = getNth(index);
        T removedElement = nodeToRemove.getElement();
        nodeToRemove.getPrev().setNext(nodeToRemove.getNext());
        nodeToRemove.getNext().setPrev(nodeToRemove.getPrev());
        size--;
        return removedElement;
    }

    /**
     * Set the value of an element at a certain index in the list.
     *
     * TODO: javadoc comments
     */
    @Override
    public T set(int index, T element)
            throws IndexOutOfBoundsException, NullPointerException {
        // TODO: Fill in implmentation
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (element == null) {
            throw new NullPointerException("Cannot set null element");
        }
        Node<T> node = getNth(index);
        T oldElement = node.getElement();
        node.setElement(element);
        return oldElement;
    }

    /**
     * Retrieves the amount of elements that are currently on the list.
     *
     * TODO: javadoc comments
     */
    @Override
    public int size() {
        // TODO: complete implementation
        return size;
    }

    /**
     * String representation of this list in the form of:
     * "[(head) -> elem1 -> elem2 -> ... -> elemN -> (tail)]"
     *
     * TODO: javadoc comments
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[(head) -> ");
        Node<T> current = head.getNext();
        while (current != tail) {
            sb.append(current.getElement());
            if (current.getNext() != tail) {
                sb.append(" -> ");
            }
            current = current.getNext();
        }
        sb.append(" -> (tail)]");
        return sb.toString();
    }

    /* ==================== EXTRA CREDIT ==================== */

    /**
     * Remove nodes whose index is a multiple of base
     *
     * TODO: javadoc comments
     */
    public void removeMultipleOf(int base) {
        // TODO: complete implementation       
    }

    /**
     * Swap the nodes between index [0, splitIndex] of two lists
     *
     * TODO: javadoc comments
     */
    public void swapSegment(DoublyLinkedList<T> other, int splitIndex) {
        // TODO: complete implementation
    }

}
