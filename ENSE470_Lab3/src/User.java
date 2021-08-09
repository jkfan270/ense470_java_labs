
/**
 *
 * @author jkfan
 */
public class User extends Game
{
    @Override
    public void updateScore(int hScore, int visScore, int currPeriod)
    {
        System.out.println("User found out the score are:" + hScore + visScore + currPeriod);
    }
    
}
