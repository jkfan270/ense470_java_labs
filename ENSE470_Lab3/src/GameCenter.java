/**
 * 
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Map;


public class GameCenter{
	
	private Hashtable<String, Integer> teams;
	private ArrayList<Game> todaysGames;
        private String str;
        private int hScore;
        private int visScore;
        private int currPeriod;

	public GameCenter()
	{
		teams  = new Hashtable<String, Integer>();
		teams.put("Toronto Maple Leafs", 1);
		teams.put("Montreal Canadiens", 2);
		teams.put("Edmonton Oilers", 3);	
		teams.put("Vancouver Canucks", 4);
		teams.put("Calgary Flames",  5);
		teams.put("Ottawa Senators", 6);
                
		todaysGames = new ArrayList<Game>();
		
	}
        

        
       public void doNotify()
        {
             Game g = new Game();
         Set<String> keys = teams.keySet();
            Iterator<String> it = keys.iterator();
            while (it.hasNext()) 
            {
		str = it.next();
		g.updateScore(hScore, visScore, currPeriod);
            }
        }
       
         public void showGame()
        {
            for(Map.Entry m:teams.entrySet())
            {
            System.out.println("Teams: " + m.getKey() + " | Number: " +m.getValue());
            }
       
        }
       
       public void setScore(int newH, int newV, int newC)
       {
           System.out.println("Game center setting home score to " + newH);
           System.out.println("Game center setting vistor score to " + newV);
           System.out.println("Game center setting current period to " + newC);
           hScore = newH;
           visScore = newV;
           currPeriod = newC;
           doNotify();
       }	
       

	public int getTeamID(String teamName)
	{
		Integer n =teams.get(teamName);
		return n.intValue();
		
	}
	
	public void addGame(Game g)
	{
		
		todaysGames.add(g);
		
	}

        public void removeGame(Game g)
        {
            todaysGames.remove(g);
        }

	public void addTeam(String teamName, int state)
	{
		
		teams.put(teamName,state);
		
	}
	
	public ArrayList<Game> getTodaysGames()
	{
		return todaysGames;
	}



	

}

