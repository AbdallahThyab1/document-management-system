
package document_manipulation;

import java.time.LocalDate;

public class Book extends Document{
    private String edition;

    public Book(String edition, String title, LocalDate dateOfCreation, Author[] authors) {
        super(title, dateOfCreation, authors);
        this.edition = edition;
    }


    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }
    
    @Override
    public String toString(){
      return ("The Edition Of the Book is : " + this.edition);
    }
}
