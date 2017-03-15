import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

class GameManager {
    Player[] players;
    Table[] tables;
    
    int roundNumber;
    String filename;
    
    GameManager(String filename) {
        players = new Player[16];
        
        for(int i = 0; i < players.length; i++) {
            players[i] = new Player("NO PLAYER");
        } 
        
        tables = new Table[14];
        
        roundNumber = 1;
        this.filename = filename;
        
        readFromFile();
        tableGenerator();
        //System.out.println(tables[0].p1.name);
        //System.out.println(tables[1].p1.name);
        showMenu();
    }
         
    void showMenu() {
        Scanner in = new Scanner(System.in);
        int selection = -1;
        
	    while (selection != 0) {
	        System.out.println("\n\n\t\t***Menu***\n");
	        System.out.println("Current round: " + roundNumber);
			System.out.println("1. Show matches for this round");
			System.out.println("2. Register placements");
			System.out.println("3. Next round");
			System.out.println("4. SORT");
			System.out.println("5. Lost?");
			System.out.println("6. Kast ut leietager.");
			System.out.println("7. Ok husleien.");
			System.out.println("8. Avslutt systemet.");
			
	        System.out.println("\nChoose a number between 1-8: ");
	        selection = in.nextInt();
			
			switch(selection) {
				case 1: showMatchesforCurrentRound(); break;
				case 2: registerPlacement(); clearScreen(); break;
				case 3: nextRound(); clearScreen(); break;
				case 4: sortPlacement(1, roundNumber + 1); break;
				case 5: break;
				case 6: break;
				case 7: break;
				case 8: System.out.println("\nSystemet avsluttes!"); System.exit(0);
				default: System.out.println("\nUse a number between 1-8!\n");				
					
		 	}
		}
    }
    
    void readFromFile() {
        File file = new File(filename);
        int i = 0;
                
        try {
            Scanner sc = new Scanner(file);
            while(sc.hasNext()) {
                players[i] = new Player(sc.nextLine());
                i++;
            }
            sc.close();
        }
        catch (FileNotFoundException ex) {
            System.out.println("Could not find the file!");
        }
    }
    
    void nextRound() {
        roundNumber++;
        tableGenerator();
    }
    
    void tableGenerator() {
        int playerID = 0;
        int whatPlace = 1;
        
        if(roundNumber == 1) {
            for(int i = 0; i < 4; i++) {
                tables[i] = new Table(players[playerID], players[playerID + 1], players[playerID + 2], players[playerID + 3]);
                playerID += 4;
            }
        } else if(roundNumber == 2) {
            for(int i = 4; i < 8; i++) {
                tables[i] = new Table(sortPlacement(whatPlace, roundNumber)[playerID], 
                sortPlacement(whatPlace, roundNumber)[playerID + 1], 
                sortPlacement(whatPlace, roundNumber)[playerID + 2], 
                sortPlacement(whatPlace, roundNumber)[playerID + 3]);
                whatPlace++;
            }
        } else if(roundNumber == 3) {
            tables[8] = new Table(sortPlacement(1, roundNumber)[playerID], 
            sortPlacement(2, roundNumber)[playerID], 
            sortPlacement(1, roundNumber)[playerID + 1], 
            sortPlacement(2, roundNumber)[playerID + 1]);
            
            tables[9] = new Table(sortPlacement(1, roundNumber)[playerID + 2], 
            sortPlacement(2, roundNumber)[playerID + 2], 
            sortPlacement(3, roundNumber)[playerID], 
            sortPlacement(4, roundNumber)[playerID]);
            
            tables[10] = new Table(sortPlacement(1, roundNumber)[playerID + 3], 
            sortPlacement(2, roundNumber)[playerID + 3], 
            sortPlacement(3, roundNumber)[playerID + 1], 
            sortPlacement(4, roundNumber)[playerID + 1]);
        } else if(roundNumber == 4) {
            //Ligger en feil her inne.
            tables[11] = new Table(sortPlacement(1, roundNumber)[playerID + 1], 
            sortPlacement(2, roundNumber)[playerID + 1], 
            sortPlacement(1, roundNumber)[playerID + 2], 
            sortPlacement(2, roundNumber)[playerID + 2]);
        } else if(roundNumber == 5) {
            tables[12] = new Table(sortPlacement(1, roundNumber)[playerID], 
            sortPlacement(2, roundNumber)[playerID], 
            sortPlacement(3, (roundNumber - 1))[playerID], 
            sortPlacement(4, (roundNumber - 1))[playerID]);
        } else if(roundNumber == 6) {
            tables[13] = new Table(sortPlacement(1, roundNumber - 2)[playerID], 
            sortPlacement(2, roundNumber - 2)[playerID], 
            sortPlacement(1, roundNumber)[playerID], 
            sortPlacement(2, roundNumber)[playerID]);
        }
    }
    
    void showMatchesforCurrentRound() {
        if(roundNumber == 1) {
            System.out.println("Round #" + roundNumber);
            for(int i = 0; i < 4; i++) {
                System.out.println("Table #" + (i + 1));
                System.out.println(tables[i].p1.getName() + " vs " + 
                tables[i].p2.getName() + " vs " + 
                tables[i].p3.getName() + " vs " + 
                tables[i].p4.getName() + "\n");
            }
        } else if(roundNumber == 2) {
            System.out.println("Round #" + roundNumber);
            for(int i = 4; i < 8; i++) {
                System.out.println("Table #" + (i + 1));
                System.out.println(tables[i].p1.getName() + " vs " + 
                tables[i].p2.getName() + " vs " + 
                tables[i].p3.getName() + " vs " + 
                tables[i].p4.getName() + "\n");
            }
        } else if(roundNumber == 3) {
            System.out.println("Round #" + roundNumber);
            for(int i = 8; i < 11; i++) {
                System.out.println("Table #" + (i + 1));
                System.out.println(tables[i].p1.getName() + " vs " + 
                tables[i].p2.getName() + " vs " + 
                tables[i].p3.getName() + " vs " + 
                tables[i].p4.getName() + "\n");
            }
        } else if(roundNumber == 4) {
            System.out.println("Round #" + roundNumber);
            
            System.out.println("Table #" + (11 + 1));
            System.out.println(tables[11].p1.getName() + " vs " + 
            tables[11].p2.getName() + " vs " + 
            tables[11].p3.getName() + " vs " + 
            tables[11].p4.getName() + "\n");
        } else if(roundNumber == 5) {
            System.out.println("Round #" + roundNumber);
            
            System.out.println("Table #" + (12 + 1));
            System.out.println(tables[12].p1.getName() + " vs " + 
            tables[12].p2.getName() + " vs " + 
            tables[12].p3.getName() + " vs " + 
            tables[12].p4.getName() + "\n");
        }
    }
    
    Player[] sortPlacement(int place, int round) {
        Player[] placementSort = new Player[4];
        
        for(int i = 0; i < players.length; i++) {
            for(int j = 0; j < placementSort.length; j++) {
                if(place == players[i].getPlacement(round - 2) && placementSort[j] == null) {
                    placementSort[j] = players[i];
                    break;
                }
            }
        }
        return placementSort;
    }
    
    void registerPlacement() {
        Scanner in = new Scanner(System.in);
        int table = -1;
        System.out.println("\nWich table to register placements for: ");
        table = in.nextInt();
        tables[table - 1].setPlacement();
    }
    
    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
   } 
}