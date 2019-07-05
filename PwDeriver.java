/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pwderiver;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author jody
 */
public class PwDeriver {

    /**
     * @param args the command line arguments
     */
    
    // our marble collection.  zero is no marble, 1 = white, 2 = black
   
    public static void main(String[] args) {

        // format:          pullnumber, result, 
        int pullCount = 0;
        int numberOfRuns = 1000;
        
        // create a bag of Marbles
        // Marble has one attribute: Color
        int numberOfMarbles = 30;
        int marblesRemaining = numberOfMarbles;
        List<Integer> bag = new ArrayList<Integer>();
        //System.out.println("created bag");
    
        // which marble we will pick
         int reachIntoBag = 0;
         
         // generate header
         System.out.print("Run#,");
         for(int hdr=0;hdr<numberOfMarbles*2;hdr++) {
             System.out.print("pull#"+hdr+","+"Marble#,Color,#left,");
         }
         // run simulation and generate data outer loop
         for(int runs=0;runs<numberOfRuns;runs++) {
            System.out.print(runs+",");
            // fill bag
            for(int i=0;i<numberOfMarbles;i++) {
                bag.add(i,1);
            }
            
            pullCount = 0;
            marblesRemaining = numberOfMarbles;
            //System.out.println("filled bag with "+numberOfMarbles+" marbles.");
   
            Random randomGenerator = new Random();

            // repeat until bag is empty
             do {
                 
                    System.out.print(pullCount+",");
                    // pull a random marble from the bag
                    reachIntoBag = randomGenerator.nextInt(marblesRemaining);
                    System.out.print(reachIntoBag+","+bag.get(reachIntoBag)+",");
                    

                    if(bag.get(reachIntoBag) == 1) { // white marble
                        bag.set(reachIntoBag, 2); // replace with black marble
                    }
                    else {
                        bag.remove(reachIntoBag); // don't put the black marble back
                        marblesRemaining--;
                    }
                    System.out.print(marblesRemaining+",");
                    pullCount++;
            } while(marblesRemaining > 0);
             
            System.out.println();
        }
    }
}
