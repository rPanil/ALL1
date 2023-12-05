
// Client Code
//RMIClient//

import java.sql.*;
import java.rmi.*;
import java.io.*;
import java.util.*;
import java.util.Vector.*;
import java.lang.*;
import java.rmi.registry.*;
public class Client
{ 
	static String name1,name2,name3;
	
	public static boolean isReverse(String s1, String s2) {
        // Check if s2 is the reverse of s1
        return new StringBuilder(s1).reverse().toString().equals(s2);
    }
	public static void main(String args[])
	{
	
		Client c=new Client();
		BufferedReader b = new BufferedReader(new
		InputStreamReader(System.in));

 		int ch;

 		try { 
 			Registry r1 = LocateRegistry.getRegistry ( "localhost", 1030);
 			DBInterface DI=(DBInterface)r1.lookup("DBServ");
 			do
 			{
 				System.out.println("1.send input stings\n2.Display Result \nEnter ur choice");
 				ch= Integer.parseInt(b.readLine());
 				switch(ch)
 				{
 				case 1:
 					System.out.println(" \n Enter first string:");
 					name1=b.readLine();
 					System.out.println(" \n Enter second string:");
					name2=b.readLine();
 					name3=DI.input(name1,name2);
 					
 						
 					
 					break;
			       case 2:
 					//display
 					System.out.println("\n Check the Reverse of first string is equal to second string : ");
					
					if(isReverse(name1,name2))
					{
						System.out.println("Yes, Reverse of first string is equals to second string.");
					}
					else
					{
						System.out.println("No");
					}

 					break;
 				}
 			}while(ch>0);

 		}	
 		catch (Exception e)
 		{
 			// System.out.println("ERROR: " +e.getMessage());
 		}
	}
}

