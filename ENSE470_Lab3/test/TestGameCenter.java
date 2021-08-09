
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestGameCenter {
	
	public static GameCenter gc;
	
	@BeforeClass
	public static void onceExecutedBeforeAll() 
	{
		System.out.println("@BeforeClass: onceExecutedBeforeAll");
		gc = new GameCenter();
		gc.addGame(new Game(gc.getTeamID("Toronto Maple Leafs"), gc.getTeamID("Montreal Canadiens")));
		gc.addGame(new Game(gc.getTeamID("Vancouver Canucks"), gc.getTeamID("Ottawa Senators")));
		gc.addGame(new Game(gc.getTeamID("Calgary Flames"), gc.getTeamID("Edmonton Oilers")));
		
		
		//Register observers etc..
		
		
	}

	
	/**
	 * Test method for {@link com.trevordouglas.nhlobserver.GameCenter#getTeamID(java.lang.String)}.
	 */
	@Test
	public void testGetTeamID() {
		
		//System.out.println(gc.getTeamID("Toronto Maple Leafs"));
		assertEquals(1, gc.getTeamID("Toronto Maple Leafs"));
		assertEquals(2, gc.getTeamID("Montreal Canadiens"));
		assertEquals(3, gc.getTeamID("Edmonton Oilers"));
		assertEquals(4, gc.getTeamID("Vancouver Canucks"));
		assertEquals(5, gc.getTeamID("Calgary Flames"));
		assertEquals(6, gc.getTeamID("Ottawa Senators"));
		
	}
	
	
	
	@Test
	public void testGameUpdates()
	{
		//Stimulate game plan
		ArrayList<Game> todaysGames = gc.getTodaysGames();
		System.out.println("Updating Game1");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		todaysGames.get(0).updateScore(3, 2, 1);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Updating Game2");
		
		todaysGames.get(1).updateScore(3, 2, 1);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Updating Game3");
		todaysGames.get(2).updateScore(3, 2, 1);
		
	}

}
