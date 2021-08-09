/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jkfan
 */


public class Client {
    
    public static int num_tank = 5;

    
    public void test_damage(Tank t)
    {
        int damage = 100;
	int penetration = 0;
        int getHit = 0;
        
        System.out.println("Current tank information:");
        System.out.println("Tank name: "+ t.getName());
        System.out.println("Made in: "+ t.getCountry());
        System.out.println("Hit points: "+ t.getHitPoints());
        System.out.println("Armor remain: "+ t.getArmor());

        while(!t.getDestroyed()) 
        {
            int initialStatus = t.getCurrentHealth();
            t.receiveHit(damage, penetration);
            getHit++;
            int outputDmg = damage * (penetration - t.getArmor())/100;
            if(outputDmg<0){
                outputDmg =0;
            }
            System.out.println( "Current Penetration = "+penetration+"\n"+"Enemy Armour = "+t.getArmor()+"\n"+"Damage = "+ outputDmg +"\n" +  "Current Health = "+initialStatus);
          

            penetration = penetration + 5;
        }
    }
    
    public static void main(String[] args)
    {
        System.out.println("Welcome to the World of Tanks");
        Client c = new Client();
        tankFactory tf = new tankFactory();
        
        for(int i=0;i<num_tank;i++)
        {
            c.test_damage(tf.tankType(i));
        }
        System.out.println("Game Over.");
        
    }
    
}

