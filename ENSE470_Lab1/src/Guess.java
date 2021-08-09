
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jkfan
 */
import java.util.Scanner;

public class Guess
{
    public void guess(String word)
    {
        Scanner sc=new Scanner(System.in);
        StringBuilder randomIndex = new StringBuilder(word.length());
        
         for(int i=0;i<word.length();i++)        
              randomIndex.append("*");
              char[] Str = word.toCharArray();        
              
    int wordNow = word.length();
    
    int userTimes = 5;
    
    while(wordNow >= 0)
    {

        System.out.println("Current word is :" + randomIndex.toString());
        System.out.println("User2: Please guess a letter :");
        
        char letter = sc.next().toCharArray()[0];
        
        int nIndex = word.indexOf(letter);
        
         if(nIndex<0)
            {
                userTimes--;
                System.out.println("Wrong guess.");
                System.out.println("You have "+userTimes+" times remain.");
                if(userTimes==0)
                {
                    System.out.println("Game Over.");
                    System.exit(0);
                }
            }
    else
         {

        for(int i=0;i<Str.length;i++)
        {
           if(letter==Str[i])
           {
                randomIndex.setCharAt(i,letter);         
            }

             }
        
        String finalWord = String.valueOf(randomIndex.toString());
        if(!finalWord.contains("*"))
        {
            System.out.println("You won.");
            System.out.println("The right answer is "+randomIndex.toString());
            break;
        }
    }
    }
    }
    
}