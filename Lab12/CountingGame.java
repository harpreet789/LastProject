import java.io.*;
import java.util.*;

/**
 * CountingGame is a program that will simulate a children's counting game used to select
 * someone.
 * 
 * @author Charles Hoot
 * @version 4.0
 */
    
public class CountingGame
{

    public static void main(String args[])
    {
        ListInterface<Integer> players = null;
        ListInterface<String> rhyme = null;
        
        int max;
        int position = 1;       // always start with the first player
        
        System.out.println("Please enter the number of players.");
        max = getInt("   It should be an integer value greater than or equal to 2.");
        System.out.println("Constructing list of players");
        
        // ADD CODE HERE TO CREATE THE LIST OF PLAYERS
        players=new AList(max);
        for(int i=1;i<=max;i++)
        {
        	players.add(i);
        }
        
        System.out.println("The players list is " + players);
        
        rhyme = getRhyme();

        // ADD CODE HERE TO PLAY THE GAME
         int round=1;//to  track the no. of rounds
        while(players.getLength()>1)//continue rounds till we have only 1 player left in the game
        	{
        	   System.out.println("round : "+round);
        	   position=doRhyme(players,rhyme,position);
        	   round++;
        	}
        
        System.out.println("The winner is " + players.getEntry(1));
    }
    
    
    /**
     * Do the rhyme with the players in the list and remove the selected
     * player.
     *
     * @param  players   A list holding the players.
     * @param  rhyme   A list holding the words of the rhyme.
     * @param  startAt A position to start the rhyme at.
     * 
     * @return The position of the player eliminated.
     */
   public static int doRhyme(ListInterface<Integer> players, ListInterface<String> rhyme, int startAt)
    {
	   int no_of_players=players.getLength();
	   int length_of_rhyme=(rhyme.getLength())%(no_of_players+1);//to get the length of the rhyme
	   for(int i=1;i<=length_of_rhyme;i++)
	   {
		   System.out.println("Rhyme word is : "+ rhyme.getEntry(i) + " , player is : " + players.getEntry(startAt));
		   if(i==length_of_rhyme)
			   break;
		   startAt++;
		   startAt=startAt%(no_of_players+1);
		   startAt=startAt==0?1:startAt;
	   }
	   System.out.println(" the eliminated player is :" + players.getEntry(startAt));//removing the player
	   players.remove(startAt);
	   if(startAt==no_of_players)//selecting player which will start next round of game 
		   startAt=1;
	   return startAt;
	   
	  

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
    
    /**
     * getRhyme - Get the rhyme.
     *
     * @return    A list of words that is the rhyme.
     */
    private static ListInterface<String> getRhyme()
    {
        Scanner input;
        String inString = "";
        ListInterface<String> rhyme = new AList<String>();
        
        try
        {
            input = new Scanner( System.in );
            
            System.out.println("Please enter a rhyme");
            inString = input.nextLine().trim();
            
            Scanner rhymeWords = new Scanner(inString);
            while(rhymeWords.hasNext())
            {
                rhyme.add(rhymeWords.next());
            }
            
        }
        catch(Exception e)
        {
            System.out.println("There was an error with System.in");
            System.out.println(e.getMessage());
            System.out.println("Will use a rhyme of size one");
        }

        // Make sure there is at least one word in the rhyme
        if(rhyme.getLength() < 1)
            rhyme.add("Default");
            
        return (ListInterface<String>)rhyme;
                                    
    }
    
}
