
// Java program for client application
import java.rmi.*;
import java.util.*;
public class client
{
    public static void main(String args[])
    {
    int num1 = 5,num2 = 7,answer;
    Scanner sc= new Scanner(System.in);
    System.out.println("Enter the first number...");
                num1= sc.nextInt(); 

                System.out.println("Enter the second number...");
                num2= sc.nextInt(); 

        String value="A raised to B";
        try
        {
            // lookup method to find reference of stub remote object
            search access =
                (search)Naming.lookup("rmi://localhost:1900"+
                                      "/server");
                                      
            answer = access.ans(num1,num2);
            System.out.println("Anwer of " + value +
                            " " + answer+" .");
        }
        catch(Exception ae)
        {
            System.out.println(ae);
        }
    }
}

