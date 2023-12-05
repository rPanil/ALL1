import java.rmi.*;
import java.util.Scanner;

public class Client {
    public static void main(String args[]) throws Exception {

        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter the first number: ");
        int num1 = scanner.nextInt();


        System.out.print("Enter the second number: ");
        int num2 = scanner.nextInt();


        scanner.close();


        ProdI ProdIObj = (ProdI) Naming.lookup("POW");


        int res = ProdIObj.pow(num1, num2);


        System.out.println("\nResult of pow(" + num1 + ", " + num2 + ") = " + res);
    }
}

