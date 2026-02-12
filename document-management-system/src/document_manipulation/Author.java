package document_manipulation;

import java.time.*;

public class Author {

    private static int c = 0;
    private final int authorID;
    private String authorName;
    private LocalDate authorDOB;
    
    
    private int assignID(){
    return ++c;
    }
    
    public Author(String authorName , LocalDate authorDOB){
        this.authorName = authorName;
        this.authorDOB = authorDOB;
        this.authorID = assignID();
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public LocalDate getAuthorDOB() {
        return authorDOB;
    }

    public void setAuthorDOB(int year , int month , int day) {
        this.authorDOB = LocalDate.of(year, month, day);
    }
    
    public int getAuthorID(){
    return authorID;
    }
    
    @Override
    public String toString(){
    return "Author [ID: " + authorID + ", Name: " + authorName + ", DOB: " + authorDOB + "]";
    }
    
    
}
