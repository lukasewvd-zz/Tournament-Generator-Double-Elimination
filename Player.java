class Player {
    String name;
    //Placement in the different matches.
    int[] placement;
    
    Player(String name) {
                this.name = name;
                placement = new int[6];
    }
    
    public String getName() {
        return name;
    }
    

    
    public int getPlacement(int round) {
        return placement[round];
    }
    
    public void setPlacement(int place) {
        for(int i = 0; i < placement.length; i++) {
                placement[i] = place;
        }
    }
}