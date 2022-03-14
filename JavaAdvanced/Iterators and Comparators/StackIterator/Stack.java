package StackIterator;

import java.util.Iterator;

public class Stack implements Iterable<Integer> {
    private Node top;
    private int size;

    private static class Node {

        private int element;
        private Node prev;

        private Node(int element) {
            this.element = element;
        }

    }

    public Stack() {
    }

    public void push(int element) {
        Node newNode = new Node(element);
        if (this.top != null) {
            newNode.prev = this.top;
        }

        this.top = newNode;
        this.size++;
    }

    public int pop() {
        if (this.top == null) {
            return -1;
        }

        int popped = this.top.element;

        this.top = this.top.prev;
        this.size--;

        return popped;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private Node current = top;

            @Override
            public boolean hasNext() {
                return this.current != null;
            }

            @Override
            public Integer next() {
                Integer currentValue = this.current.element;
                this.current = this.current.prev;
                return currentValue;
            }
        };
    }
}
