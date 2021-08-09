
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

public class Lab00fan270 {

public static void main(String[] args) {
    System.out.println("User1: Please enter a secrect word: ");
    Scanner sc=new Scanner(System.in);
    String word = sc.next();
    Guess g = new Guess();
    g.guess(word);

}
}