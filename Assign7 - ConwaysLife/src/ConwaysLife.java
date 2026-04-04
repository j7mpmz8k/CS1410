import edu.usu.graphics.Color;
import edu.usu.graphics.Graphics2D;
import edu.usu.graphics.Rectangle;
import edu.usu.graphics.Texture;

import static org.lwjgl.glfw.GLFW.*;

public class ConwaysLife {
    private static final int SIZE_X = 75;
    private static final int SIZE_Y = 75;

    public static void main(String[] args) {
        try (Graphics2D graphics = new Graphics2D(1000, 1000, "Conway's Game of Life")) {
            graphics.initialize(Color.BLACK);
            Texture texSquare = new Texture("resources/images/square-outline.png");

            LifeSimulator simulation = new LifeSimulator(SIZE_X, SIZE_Y);
            simulation.insertPattern(new PatternAcorn(), 15, 40);

            simulation.insertPattern(new PatternBlock(), 25, 25);
            simulation.insertPattern(new PatternBlock(), 5, 25);
            simulation.insertPattern(new PatternBlock(), 25, 5);
            simulation.insertPattern(new PatternBlock(), 5, 5);

            simulation.insertPattern(new PatternBlinker(), 55, 69);

            simulation.insertPattern(new PatternGlider(), 35, 35);

            simulation.insertPattern(new PatternPulsar(), 50, 50);
            simulation.insertPattern(new PatternPulsar(), 65, 15);

            boolean done = false;
            while (!done) {
                render(graphics, texSquare, simulation);
                Thread.sleep(50);
                simulation.update();

                // Poll for window events: required in order for window, keyboard, etc events are captured.
                glfwPollEvents();

                if (glfwGetKey(graphics.getWindow(), GLFW_KEY_ESCAPE) == GLFW_PRESS) {
                    done = true;
                }
            }
        } catch (Exception ex) {
            System.out.println("Something bad happened: " + ex.getMessage());
        }
    }
    

    public static void render(Graphics2D graphics, Texture texSquare, LifeSimulator simulation) {
        final float AREA_SIZE = 1.5f;
        final float CELL_SIZE = AREA_SIZE / SIZE_X;
        final float BOUNDARY_LEFT = -0.75f;
        final float BOUNDARY_TOP = -0.75f;

        graphics.begin();

        //draws simulation background
        Rectangle rBackground = new Rectangle(BOUNDARY_LEFT, BOUNDARY_TOP,AREA_SIZE, AREA_SIZE);
        graphics.draw(rBackground, new Color(0, 0, 0.25f));

        //loops through each cell in simulation grid
        for (int row = 0; row < simulation.getSizeY(); row++) {
            for (int col = 0; col < simulation.getSizeX(); col++) {

                //draws each alive cells
                if (simulation.getCell(col, row)) {
                    Rectangle r = new Rectangle(//must reallocate instead of moving Rectangle location due to graphics implimentation
                        BOUNDARY_LEFT + CELL_SIZE * col,
                        BOUNDARY_TOP + CELL_SIZE * row,
                        CELL_SIZE, CELL_SIZE);
                    graphics.draw(texSquare, r, Color.WHITE);
                }
            }
        }

        graphics.end();
    }
}
