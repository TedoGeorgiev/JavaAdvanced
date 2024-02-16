package Iterators_and_Comparators_Lab._4_BookComparator;

import java.util.Iterator;

public class Library implements Iterable<Book>{
    private Book[] books;

    public Library(Book... books) {
        this.books = books;
    }

    @Override
    public Iterator<Book> iterator() {
        return new LibIterator();
    }

    private final class LibIterator implements Iterator<Book>{
        private int position = 0;

        @Override
        public boolean hasNext() {
            return position < books.length;
        }

        @Override
        public Book next() {
            return books[position++];
        }
    }


}
