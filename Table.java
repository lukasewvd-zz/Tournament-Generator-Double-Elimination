import java.util.Scanner;

class Table {
    Player p1;
    Player p2;
    Player p3;
    Player p4;
    
    Table(Player p1, Player p2, Player p3, Player p4) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
    }
    
    public void setPlacement() {
        System.out.println("");
        for(int i = 1; i < 5; i++) {
            System.out.println("Who got: " + i + ". place:");
            playerSelecter(i);
        }
    }
    
    private void playerSelecter(int place) {
        Scanner in = new Scanner(System.in);
        int selection = -1;
        
        while (selection != 0) {
            System.out.println("1. " + p1.getName());
            System.out.println("2. " + p2.getName());
            System.out.println("3. " + p3.getName());
            System.out.println("4. " + p4.getName());
    
            
            System.out.println("\nChoose a number between 1-4: ");
            selection = in.nextInt();
            
            switch(selection) {
                case 1: p1.setPlacement(place); return;
                case 2: p2.setPlacement(place); return;
                case 3: p3.setPlacement(place); return;
                case 4: p4.setPlacement(place); return;
                default: System.out.println("\nUse a number between 1-4!\n");				
                    
            }
        }
    }
}