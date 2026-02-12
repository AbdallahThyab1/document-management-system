package document_manipulation;

import java.time.LocalDate;
import java.util.Scanner;

public class Document_Manipulation {
    
    private static Document documents[];
    static Scanner input = new Scanner(System.in);

    public static void createNewDocuments() { // Method to Create List of Documents
        
        System.out.println("#######  CREATE NEW DOCUMENTS  ######");
        
        System.out.println("Enter here the number of Document : ");
        int sizeDocument = Integer.parseInt(input.nextLine());
        documents = new Document[sizeDocument];  // step 1 : create List of Documents each Document has Title & Date & List of Author
        
        
        for (int j = 0; j < sizeDocument; j++) { // Loop to Create a List of Documents :
            
            System.out.println("Enter here the Title : "); // title of Document
            String title = input.nextLine();
            
            System.out.println("Enter here the date as (yyyy-mm-dd) : "); // date of Document
            String Datestring = input.nextLine();
            LocalDate Date = LocalDate.parse(Datestring);
            
            System.out.println("Enter here the Number of Author : "); // list of Author for each Document :
            int sizeAuthorList = Integer.parseInt(input.nextLine());
            Author ListAuthor[] = new Author[sizeAuthorList];
            
            
            System.out.println("####################################");
            
            for (int i = 0; i < sizeAuthorList; i++) { // step 2 : create List of Authors each Author has Name & Date 
                System.out.println("Enter here The Name of Author " + (i + 1) + " : ");
                String Name = input.nextLine();
                System.out.println("Enter here the date as (yyyy-mm-dd) for the Author " + (i + 1) + " : ");
                String DateString = input.nextLine();
                LocalDate authorDOB = LocalDate.parse(DateString);
                ListAuthor[i] = new Author(Name, authorDOB);
            }
            
            
            System.out.println("####################################");
            
            System.out.println("Enter here Your Selected , 1 is Email , 0 is Book"); // step 3 : choose type of Document if : 1 Email , 0 Book
            int choose = Integer.parseInt(input.nextLine());
            
            if (choose == 1) { // create Email each Email has Subject & ToList & ALL Attributs from Document
                System.out.println("Enter here the Subject of Email : ");
                String Subjet = input.nextLine();
                
                System.out.println("Enter here Number of To_List : ");
                int sizeTOList = Integer.parseInt(input.nextLine());
                
                String ListTO[] = new String[sizeTOList];
                
                for (int i = 0; i < sizeTOList; i++) {
                    System.out.println("Enter here String TO : ");
                    ListTO[i] = input.nextLine();
                }
                documents[j] = new Email(Subjet, ListTO, title, Date, ListAuthor);
            }
            
            else if (choose == 0) { // create Book each Email has Edition & ALL Attributs from Document
                System.out.println("Enter here the Edition of Book : ");
                String edition = input.nextLine();
                documents[j] = new Book(edition, title, Date, ListAuthor);

            }
            System.out.println("####################################");
        }
    }

    public static Book[] searchForABook(String title) {
        System.out.println("####################################");
        System.out.println("Searching for book with title: '" + title + "'");
        
        int countBook = 0;
        Book ListBookReturn[];
        for (int i = 0; i < documents.length; i++) {
            if (documents[i] instanceof Book) {
                countBook++;
            }
        }
        ListBookReturn = new Book[countBook];
        for (int i = 0, j = 0; i < documents.length; i++) {
            if (documents[i] instanceof Book && (documents[i].getTitle()).equals(title)) {
                ListBookReturn[j++] = (Book) documents[i];
            }
        }
        return ListBookReturn;
    }

    public static Email[] searchForAnEmail(String Supject) {
        System.out.println("####################################");
        System.out.println("Searching for email with subject: '" + Supject + "'");
        int countEmail = 0;
        Email ListEmailReturn[];
        for (int i = 0; i < documents.length; i++) {
            if (documents[i] instanceof Email) {
                countEmail++;
            }
        }
        ListEmailReturn = new Email[countEmail];
        for (int i = 0, j = 0; i < documents.length; i++) {
            if (documents[i] instanceof Email && (documents[i].getTitle()).equals(Supject)) {
                ListEmailReturn[j++] = (Email) documents[i];
            }
        }
        return ListEmailReturn;
    }

    public static void main(String[] args) {      
        System.out.println("#####################################");
        createNewDocuments();
        Book ListOfBook [] = searchForABook("Java Book");
        Email ListOfEmail [] = searchForAnEmail("Java Test Email");
        Document Book1 = new Book("A", "B", null, null);
        
    }

}


