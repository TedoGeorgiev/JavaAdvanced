package Iterators_and_Comparators_Exercises._3_Stack_Iterator;

import java.util.Iterator;

public class StackIterator  implements Iterable<Integer>{

    private Integer [] elements;
    private int internalIndex;

    public StackIterator(int... elements) {
        this.elements = new Integer[16];
        this.internalIndex = 0;
    }

    public void push (int element) {
        this.elements[this.internalIndex ++] = element;
    }

    public Integer pop() {
        if(this.internalIndex == 0) {
            throw new IllegalStateException("No elements");
        }
        Integer element = this.elements[this.internalIndex - 1];
        this.elements[this.internalIndex - 1] = null;
        internalIndex--;
        return element;
    }


    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {

            int index = internalIndex - 1;

            @Override
            public boolean hasNext() {
                return index >= 0;
            }

            @Override
            public Integer next() {
                return elements[this.index--];
            }
        };
    }
}
