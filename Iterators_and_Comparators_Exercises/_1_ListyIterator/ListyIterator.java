package Iterators_and_Comparators_Exercises._1_ListyIterator;

import java.util.Arrays;
import java.util.List;

public class ListyIterator {

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

}
