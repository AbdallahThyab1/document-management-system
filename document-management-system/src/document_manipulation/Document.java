package document_manipulation;

import java.time.LocalDate;
import java.util.ArrayList;

public class Document {

    private String title;
    private LocalDate dateOfCreation;
    private Author authors[];

    public Document(String title, LocalDate dateOfCreation, Author authors[]) {
        this.title = title;
        this.dateOfCreation = dateOfCreation;
        this.authors = authors;
    }

    public Document(LocalDate dateOfCreation, String title, Author authors[]) {
        this.title = title;
        this.dateOfCreation = dateOfCreation;
        this.authors = authors;
    }

    public Document(Author authors[], String title, LocalDate dateOfCreation) {
        this.title = title;
        this.dateOfCreation = dateOfCreation;
        this.authors = authors;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setDateOfCreation(LocalDate dateOfCreation) {
        this.dateOfCreation = dateOfCreation;
    }

    public LocalDate getdateOfCreation() {
        return this.dateOfCreation;
    }

    public void setAuthor(Author authors[]) {
        this.authors = authors;
    }

    public Author[] getAuthors() {
        return this.authors;
    }

    public boolean addAuthor(Author author) {
        for (int i = 0; i < authors.length; i++) {
            if (authors[i] == null) {
                authors[i] = author;
                return true;
            }
        }
        return false;
    }

    private int getAuthorCount() {
        int count = 0;
        for (Author author : authors) {
            if (author != null) {
                count++;
            }
        }
        return count;
    }

    public boolean dropAuthor(Author author) {
        int countAuthor = getAuthorCount();
        if (countAuthor == 0 || author == null) {
            return false;
        }

        boolean is_delete = false;
        Author temp[] = new Author[authors.length];

        for (int i = 0, j = 0; i < authors.length; i++) {
            if (authors[i] != null && authors[i].equals(author)) {
                is_delete = true;
            } else {
                temp[j++] = authors[i];
            }
        }
        if (is_delete) {
            authors = temp;
        }
        return is_delete;

    }
}
