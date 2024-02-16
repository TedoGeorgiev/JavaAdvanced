package Iterators_and_Comparators_Lab._3_ComparableBook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Book implements Comparable<Book>{
    //title: String
    //year: int
    //authors: List<String>

    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... authors) {
        this.setTitle(title);
        this.setYear(year);
        this.setAuthors(authors);
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public List<String> getAuthors() {
        return authors;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    private void setYear(int year) {
        this.year = year;
    }

    private void setAuthors(String... authors) {
        if (authors.length == 0) {
            this.authors = new ArrayList<>();
        } else {
            this.authors = new ArrayList<>(Arrays.asList(authors));
        }

    }

    @Override
    public int compareTo(Book other) {
         int resultByTitle = this.getTitle().compareTo(other.getTitle());
         if (resultByTitle == 0) {
             return Integer.compare(this.getYear(), other.getYear());
         }
         return resultByTitle;
    }

    @Override
    public String toString() {
        return String.format("%s %d with authors: %s", this.getTitle(), this.getYear(), this.getAuthors());
    }
}
