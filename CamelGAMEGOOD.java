/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package camelgamegood;
import java.util.Scanner;
/**
 *
 * @author atkins4440j
 */
public class CamelGAMEGOOD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner game = new Scanner(System.in);
        System.out.println("Are you ready to play? 1) Yes, 2) No");
        int select = game.nextInt();
        if (select == 1) {
            System.out.println("Loading game...");
            Game();
        }
        else if (select != 1) {
            System.out.println("Shutting down...");
            System.exit(0);
        }
        // TODO code application logic here
    }
    public static void Game() {
        Scanner select = new Scanner (System.in);
        boolean playing = true;
        int thirst = 5;
        int nativedist = -20;
        int distancetravelled = 0;
        int gameFinished = 0;
        int canteen = 5;
        while(playing) {
            System.out.println("Select an action");
            System.out.println("1: Drink from canteen, 2: Half Speed Ahead, 3: Full Speed Ahead, 4: Check Status, 5: Stop and Rest, 6: Quit");
        int choice = select.nextInt();
        switch(choice) {
            case 1:
                if (canteen > 0) {
                    thirst++;
                    nativedist += (int)(Math.random()*6) + 5;
                }
                else if (canteen <= 0) {
                    System.out.println("You are out of water. You are dead, RIP!");
                    System.exit(0);
                }
                break;
            case 2:
                distancetravelled += (Math.random()*6) + 8;
                nativedist += (Math.random()*6 + 5);
                thirst--;
                break;
            case 3:
                distancetravelled += (Math.random()*6) + 13;
                nativedist += (Math.random()*6 + 5);
                thirst -= 0.5;
                break;
            case 4:
                System.out.println("You have " + canteen + " drinks left.");
                System.out.println("You thirst level is at " + thirst);
                System.out.println("You have travelled " + distancetravelled + " miles.");
                System.out.println("The natives are " + (distancetravelled - nativedist) + " miles behind you.");
                break;
            case 5:
                nativedist += (Math.random()*6 + 5);
                canteen += 1.0;
                break;
            case 6: 
                System.out.println("Game quitting...");
                System.exit(0);
                break;
            case 7: 
                if (distancetravelled > 200) {
                    System.out.println("YOU WON! YOU OUTRAN THE GUARDS!");
                    System.exit(0);
                }
                break;
                

        }
            if ((distancetravelled - nativedist) <= 12 && (distancetravelled - nativedist) >= 1) {
                System.out.println("Guards are getting quite close to you!");
            }
            if ((distancetravelled - nativedist) == 0) {
                System.out.println("You lost and were captured by the natives.");
                playing = false;
                System.exit(0);
            }
            if (thirst <= 0) {
                System.out.println("You died from dehydration. Game over.");
                playing = false;
                System.exit(0);
            }
        
        }   
    }
    
}
