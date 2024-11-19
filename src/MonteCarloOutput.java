public class MonteCarloOutput {
    public static void main(String[] args) {
        displayTable();
    }

    private static void displayTable() {
        for (double density = 1; density <= 100; density++) {
            double y = calculateAverage(100, density / 100);
            System.out.println(density + "\t," + + y * 100);
        }
    }

    private static double calculateAverage(int trials, double density) {
        double sum = 0;

        for (int i = 0; i < trials; i++) {
            double result = runExperiment(density);
            sum += result;
        }

        return sum/trials;
    }

    private static double runExperiment(double density) {
        double totalBurnt = 0;
        double totalTrees = 0;

        Simulator sim = new Simulator(100, 100);
        sim.makeForest(density);
        sim.lightningStrike();
        sim.spreadUntilBurnt();
        sim.displayBurntForest();
        totalBurnt = sim.countBurntTrees();
        totalTrees = sim.countTotalTrees();

        return totalBurnt/totalTrees;
    }
}
