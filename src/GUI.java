import processing.core.*;

public class GUI extends PApplet {
    Simulator sim;
    DisplayWindow display;
    public void settings() {
        size(640, 550); // set the size of the screen.
    }

    public void setup() {
        // Create a simulator
        sim = new Simulator(100, 100);



        // Create the display
        // parameters: (10,10) is upper left of display
        // (620, 530) is the width and height
        display = new DisplayWindow(this, 10, 10, 620, 530);

        display.setNumCols(sim.getWidth());		// NOTE:  these must match your simulator!!
        display.setNumRows(sim.getHeight());

        // Set different grid values to different colors
        // TODO:  uncomment these lines! *(done)*
        int red = color(255, 0, 0);          // pattern:  color(redAmount, greenAmount, blueAmount)
        int grey = color(180, 180, 180);
        int green = color(0, 255, 0);
        int white = color(255, 255, 255);
        int yellow = color(255,255,0);
        display.setColor(Simulator.TREE, green);          // 1 displays as green
        display.setColor(Simulator.FIRE, red);            // 2 displays as red
        display.setColor(Simulator.ASH, grey);           // 3 displays as grey
        display.setColor(Simulator.WHITE, white);// 0 displays as white
    }

    @Override
    public void draw() {

        background(200);


        // TODO: have your simulation run one step.

        display.drawGrid(sim.getDisplayGrid()); // display the game

    }

    public static void main(String[] args) {
        PApplet.main("GUI");
    }
}