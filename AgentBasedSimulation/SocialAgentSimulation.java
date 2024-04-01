/**
 * File: SocialAgent.java
 * Author: Junnan Shimizu
 * Date: 10/23/2021
 */

import java.util.Random;

public class SocialAgentSimulation {
    // similar to the LandscapeDisplay main method, however calls the advance method, repaint method, and sleep method
    public static void main(String[] args) throws InterruptedException {
        Landscape scape = new Landscape(500,500);
        Random gen = new Random();

        for(int i=0;i<200;i++) {
            scape.addAgent( new SocialAgent( gen.nextDouble() * scape.getWidth(),
                    gen.nextDouble() * scape.getHeight(),
                    15) );
        }

        LandscapeDisplay display = new LandscapeDisplay(scape);

        for(int x = 0; x < 200; x++){
            scape.updateAgents();
            display.repaint();
            Thread.sleep(100);
        }
    }
}
