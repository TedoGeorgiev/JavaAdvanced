package Iterators_and_Comparators_Exercises._2_Collection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ListyIterator implements Iterable<String> {

    private int internalIndex;
    private List<String> data;

    public ListyIterator (String... data) {
        this.data = Arrays.asList(data);
        internalIndex = 0;
    }

    public boolean move () {
        if (hasNext()) {
            this.internalIndex++;
            return true;
        }
        return false;
    }

    public boolean hasNext() {
        return internalIndex + 1 < data.size();
    }

    public void print () {
        if (data.isEmpty()) {
            throw new IllegalStateException("Invalid Operation!");

        } else {
            System.out.println(data.get(internalIndex));
        }
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return index < data.size();
            }

            @Override
            public String next() {
                String element = data.get(index);
                index++;
                return element;
            }
        };
    }

}
