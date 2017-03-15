import java.util.Scanner;

class Table {
    Player p1;
    Player p2;
    Player p3;
    Player p4;
    
    Player[] placements;
    boolean placementSet;
    int amtSetPRun;
    
    Table(Player p1, Player p2, Player p3, Player p4) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
        
        placements = new Player[4];
        placementSet = false;
        amtSetPRun = 0;
    }
    
    public void setPlacement() {
        System.out.println("");
        for(int i = 0; i < 4; i++) {
            System.out.println("Who got " + (i + 1) + ". place:");
            playerSelecter(i);
        }
        placementSet = true;
        amtSetPRun++;
    }
    
    //Fill Array with placements 1th on 0, 2nd on 1, etc.
    
    private void playerSelecter(int place) {
        Scanner in = new Scanner(System.in);
        int selection = -1;
        
        if(amtSetPRun >= 1) {
            placements[2].timesLost -= 1;
            placements[3].timesLost -= 1;
        }
        
        while (selection != 0) {
            System.out.println("1. " + p1.getName());
            System.out.println("2. " + p2.getName());
            System.out.println("3. " + p3.getName());
            System.out.println("4. " + p4.getName());
    
            
            System.out.println("\nChoose a number between 1-4: ");
            selection = in.nextInt();
            
            switch(selection) {
                case 1: 
                    placements[place] = p1;
                    if(place >= 2) {
                        p1.timesLost++;
                    }
                    return;
                case 2: 
                    placements[place] = p2;
                    if(place >= 2) {
                        p2.timesLost++;
                    }
                    return;
                case 3: 
                    placements[place] = p3;
                    if(place >= 2) {
                        p3.timesLost++;
                    }
                    return;
                case 4:
                    placements[place] = p4;
                    if(place >= 2) {
                        p4.timesLost++;
                    }
                    return;
                default: System.out.println("\nUse a number between 1-4!\n");				
                    
            }
        }
    }
}