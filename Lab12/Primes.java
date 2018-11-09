import java.io.*;
import java.util.*;

/**
 * Primes is a program that will compute prime numbers using the sieve of Eratosthenes.
 * 
 * @author Charles Hoot
  * @version 4.0
 */

    
public class Primes
{

    public static void main(String args[])
    {

        int max;
        
        System.out.println("Please enter the maximum value to test for primality");
        max = getInt("   It should be an integer value greater than or equal to 2.");
        
        // COMPLETE THE MAIN
        ListInterface<Integer>candidate=new AList(max-1);
        for(int i=2;i<=max;i++)
        	candidate.add(i);
        System.out.println("The candidate list is :");
        int len=candidate.getLength();//number  of candidate 
        for(int i=1;i<=len;i++)
        	System.out.print(" "+ candidate.getEntry(i));
        ListInterface<Integer>primes,composites;//prime and composite list
        primes=new AList(max-1);
        composites=new AList(max-1);
        while(candidate.getLength()>0)
        {
        	len=candidate.getLength();//get the new length
        	
        	int prime_no=candidate.getEntry(1);//this is the primes that we will use
        	candidate.remove(1);
        	getComposites(candidate,composites,prime_no);
        	len=candidate.getLength();//get the new length
        	
        	primes.add(prime_no);//add prime no. to the list
        	//printing the lists
        	int len1=composites.getLength(),len2=primes.getLength();
        	System.out.print("\nthe candidate list is :");
        	if(len>0)
        	{
        		for(int j=1;j<=len;j++)
        			System.out.print(" " + candidate.getEntry(j));
        	}
        	else
        	{
        		System.out.print("Empty" );
        	}
        	System.out.println(" ");
        	System.out.print("the composite list is :");
        	if(len1>0)
        	{
        		for(int j=1;j<=len1;j++)
        			System.out.print(" " + composites.getEntry(j));
        	}
        	else
        	{
        		System.out.print("Empty" );
        	}
        	System.out.println(" ");
        	System.out.print("the prime list is :");
        	if(len2>0)
        	{
        		for(int j=1;j<=len2;j++)
        			System.out.print(" " + primes.getEntry(j));
        	}
        	else
        	{
        		System.out.print("Empty" );
        	}
        	System.out.println(" ");
        	}
        }
        
        
        
    
    
    
    /**
     * getComposites - Remove the composite values from possibles list and
     * put them in the composites list.
     *
     * @param  candidates   A list of integers holding the possible values.
     * @param  composites   A list of integers holding the composite values.
     * @param  prime   An Integer that is prime.
     */
    public static void getComposites(ListInterface<Integer> candidates, ListInterface<Integer> composites, Integer prime)
    {
    	
        for(int i=1;i<=candidates.getLength();i++)
        {
        	int number=candidates.getEntry(i);//get current number
        	if(number% prime==0)//if current number is divisible by prime number,then it is composite
        	{
        		candidates.remove(i);//remove from the candidate list
        		composites.add(number);//add to composite list
        	}
        		
        		
        }
        	
    	
    }
    
    
    
    
    /**
     * Get an integer value.
     *
     * @return     An integer. 
     */
    private static int getInt(String rangePrompt)
    {
        Scanner input;
        int result = 10;        //Default value is 10
        try
        {
            input = new Scanner(System.in);
            System.out.println(rangePrompt);
            result = input.nextInt();
            
        }
        catch(NumberFormatException e)
        {
            System.out.println("Could not convert input to an integer");
            System.out.println(e.getMessage());
            System.out.println("Will use 10 as the default value");
        }        
        catch(Exception e)
        {
            System.out.println("There was an error with System.in");
            System.out.println(e.getMessage());
            System.out.println("Will use 10 as the default value");
        }
        return result;
                                    
    }    
    
}
