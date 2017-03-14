class Player {
    String name;
    //Placement in the different matches.
    int[] placement;
    boolean elimiated;
    
    Player(String name) {
                this.name = name;
                elimiated = false;
                placement = new int[6];
    }
    
    public String getName() {
        return name;
    }
    
    public boolean isEliminated() {
        return elimiated;
    }
    
    public int getPlacement(int round) {
        return placement[round];
    }
}