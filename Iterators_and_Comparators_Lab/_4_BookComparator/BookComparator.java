package Iterators_and_Comparators_Lab._4_BookComparator;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {


    @Override
    public int compare(Book o1, Book o2)  {
        return o1.compareTo(o2);
    }
}
