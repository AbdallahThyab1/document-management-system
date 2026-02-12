
package document_manipulation;

import java.time.LocalDate;

public class Email extends Document {
    private String subject;
    private String to [];

    public Email(String subject, String[] to, String title, LocalDate dateOfCreation, Author[] authors) {
        super(title, dateOfCreation, authors);
        this.subject = subject;
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String[] getTo() {
        return to;
    }

    public void setTo(String[] to) {
        this.to = to;
    }
     @Override
    public String toString(){
      return ("The Subject Of the Book is : " + this.subject);
    }
}
