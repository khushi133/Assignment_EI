public class Satellite {
    private String orientation;
    private boolean solarPanelsActive;
    private int dataCollected;

    public Satellite() {
        this.orientation = "North";  // Initial orientation
        this.solarPanelsActive = false; // Solar panels are initially inactive
        this.dataCollected = 0; // Data collected starts at 0
    }

    public String getOrientation() {
        return orientation;
    }

    public boolean areSolarPanelsActive() {
        return solarPanelsActive;
    }

    public int getDataCollected() {
        return dataCollected;
    }

    public void rotate(String direction) {
        if (direction.equals("North") || direction.equals("South") || direction.equals("East") || direction.equals("West")) {
            this.orientation = direction;
            System.out.println("Orientation set to " + direction);
        } else {
            throw new IllegalArgumentException("Invalid direction. Use North, South, East, or West.");
        }
    }

    public void activatePanels() {
        this.solarPanelsActive = true;
        System.out.println("Solar panels activated.");
    }

    public void deactivatePanels() {
        this.solarPanelsActive = false;
        System.out.println("Solar panels deactivated.");
    }

    public void collectData() {
        if (solarPanelsActive) {
            this.dataCollected += 10;
            System.out.println("Data collected. Current total: " + dataCollected);
        } else {
            throw new IllegalStateException("Cannot collect data. Solar panels are inactive.");
        }
    }
}
