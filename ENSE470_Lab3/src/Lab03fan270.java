
import java.util.Scanner;

/**
 *
 * @author jkfan
 */
public class Lab03fan270
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        GameCenter gameCenter = new GameCenter();
        User user = new User();
        
        gameCenter.showGame();
        
        
        for(int i=0;i<=6;i++)
        {
             System.out.println("Please enter a team number that you would like to watch: (1-6)");
        
             int num = sc.nextInt();
             
        if(num<=6)
        {
             gameCenter.addGame(user);

             gameCenter.setScore(30, 20, 10);
        
             gameCenter.removeGame(user);
        
            gameCenter.setScore(50,40,30);
        }
        }

    }
}
