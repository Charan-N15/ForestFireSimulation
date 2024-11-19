import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;


public class Simulator {
    public static final int TREE = 1;
    public static final int FIRE = 2;
    public static final int ASH = 3;
    public static final int WHITE = 0;


    private int[][] Forest;
    private int rows;
    private int cols;

    /***
     * Create a new simulator.  The simulator creates a new Forest of size (r, c).
     *
     * @param r
     * @param c
     */
    public Simulator(int r, int c) {
        rows = r;
        cols = c;
        Forest = new int[r][c];
    }


    public void makeForest(double treeDensity) {
        int counter = 0;
        double trees = Forest.length * Forest[0].length * treeDensity;
        for (int row = 0; row < Forest.length; row++) {
            for (int col = 0; col < Forest[0].length; col++) {
                Forest[row][col] = WHITE;
            }
        }
        do {
            int randRow = (int) (Math.random() * Forest.length);
            int randCol = (int) (Math.random() * Forest[0].length);
            if (Forest[randRow][randCol] != TREE) {
                Forest[randRow][randCol] = TREE;
                counter++;
            }
        } while (counter <= trees);
    }


    //first burn
    public void lightningStrike() {
        int firstFlameRow = (int) (Math.random() * Forest.length);
        int firstFlameCol = (int) (Math.random() * Forest[0].length);

        Forest[firstFlameRow][firstFlameCol] = FIRE;
    }


    private void spread1Step(int[][] Forest) {
        for (int row = 0; row < Forest.length; row++) {
            for (int col = 0; col < Forest[0].length; col++) {
                if (Forest[row][col] == FIRE) {
                    if (checkAdjacent(Forest, row - 1, col, TREE)) Forest[row - 1][col] = FIRE;
                    if (checkAdjacent(Forest, row + 1, col, TREE)) Forest[row + 1][col] = FIRE;
                    if (checkAdjacent(Forest, row, col - 1, TREE)) Forest[row][col - 1] = FIRE;
                    if (checkAdjacent(Forest, row, col + 1, TREE)) Forest[row][col + 1] = FIRE;
                }
            }
        }
    }


    // check if boxes adjacent to fire are trees
    private boolean areAdjacentTrees(int[][] Forest) {
        for (int row = 0; row < Forest.length; row++) {
            for (int col = 0; col < Forest[0].length; col++) {
                if (Forest[row][col] == 2) {
                    if (checkAdjacent(Forest, row - 1, col, TREE)) return true;
                    if (checkAdjacent(Forest, row + 1, col, TREE)) return true;
                    if (checkAdjacent(Forest, row, col - 1, TREE)) return true;
                    if (checkAdjacent(Forest, row, col + 1, TREE)) return true;
                }
            }
        }
        return false;
    }


    public void spreadUntilBurnt() {
        do {
            spread1Step(Forest);
        } while (areAdjacentTrees(Forest));
    }


    //turns trees into ash
    public void displayBurntForest() {
        for (int i = 0; i < Forest.length; i++) {
            for (int j = 0; j < Forest[0].length; j++) {
                if (Forest[i][j] == FIRE) Forest[i][j] = ASH;
            }
        }
    }


    // check in Bounds
    public boolean isInBounds(int row, int col) {
        if (row >= 0 && row < Forest.length) {
            if (col >= 0 && col < Forest[0].length) return true;
        }
        return false;
    }


    public boolean checkAdjacent(int[][] Forest, int row, int col, int desiredCheck) {
        if (isInBounds(row, col)) {
            if (Forest[row][col] == desiredCheck) return true;
        }
        return false;
    }


    public int countBurntTrees() {
        int burntTrees = 0;
        for (int r = 0; r < Forest.length; r++) {
            for (int c = 0; c < Forest[0].length; c++) {
                if (Forest[r][c] == ASH) burntTrees++;
            }
        }
        return burntTrees;
    }


    public double countTotalTrees() {
        int trees = 0;
        for (int row = 0; row < Forest.length; row++) {
            for (int col = 0; col < Forest[0].length; col++) {
                if (Forest[row][col] == TREE) trees++;
                if (Forest[row][col] == ASH) trees++;
            }
        }
        return trees;
    }


    public int getWidth() {
        return cols;   // TODO: change this once you make a grid variable
    }

    public int getHeight() {
        return rows;   // TODO: change this once you make a grid variable
    }

    public int[][] getDisplayGrid() {
        return Forest;    // TODO: change this to return your grid variable
    }
}