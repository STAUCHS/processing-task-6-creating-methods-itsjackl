import processing.core.PApplet;

public class Sketch extends PApplet {

  /**
   * Sets the size of the sketch window.
   * @author J. Lai
   */
  public void settings() {
    size(700, 700);
  }

  /**
   * Sets up the initial environment properties.
   * @author J. Lai
   */
  public void setup() {
    background(135, 206, 235);
    
    // Draw a house at a specific location and size
    drawHouse(100, 100, 0.5f);
    
    // Draw a stick figure at a specific location
    drawStickFigure(400, 400, 0.5f);
    
    // Draw multiple stick figures with varying positions
    for (int i = 0; i < 50; i++) {
      drawStickFigure(random(width), random(height), random(0.2f, 0.5f));
    }
    
    // Draw random composite objects
    int numCompositeObjects = (int) random(5, 50);
    drawRandomCompositeObjects(numCompositeObjects);
  }
  
  /**
   * Draws a house at a specified location and size.
   *
   * @param x The x-coordinate of the house.
   * @param y The y-coordinate of the house.
   * @param scale The scale factor of the house.
   * @author J. Lai
   */
  public void drawHouse(float x, float y, float scale) {
    // Main part of the house
    fill(196, 164, 132);
    rect(x, y, 150 * scale, 150 * scale);
    
    // Roof of the house
    fill(90, 90, 90);
    triangle(x, y, x + (150 * scale), y, x + (75 * scale), y - (75 * scale));
    
    // Windows of the house
    fill(53, 126, 199);
    ellipse(x + (50 * scale), y + (75 * scale), 40 * scale, 40 * scale);
    ellipse(x + (100 * scale), y + (75 * scale), 40 * scale, 40 * scale);
    fill(0, 0, 0);
    line(x + (35 * scale), y + (75 * scale), x + (65 * scale), y + (75 * scale));
    line(x + (50 * scale), y + (60 * scale), x + (50 * scale), y + (90 * scale));
    line(x + (85 * scale), y + (75 * scale), x + (115 * scale), y + (75 * scale));
    line(x + (100 * scale), y + (60 * scale), x + (100 * scale), y + (90 * scale));

    // Door of the house
    fill(92, 64, 51);
    rect(x + (60 * scale), y + (100 * scale), 30 * scale, 50 * scale);
  }
  
  /**
   * Draws a stick figure at a specified location and size.
   *
   * @param x The x-coordinate of the stick figure.
   * @param y The y-coordinate of the stick figure.
   * @param scale The scale factor of the stick figure.
   * @author J. Lai
   */
  public void drawStickFigure(float x, float y, float scale) {
    fill(224,172,105);
    // Body
    line(x, y, x, y + (80 * scale));
    // Head
    ellipse(x, y, 50 * scale, 50 * scale);
    // Arms
    line(x - (30 * scale), y + (30 * scale), x + (30 * scale), y + (30 * scale));
    // Legs
    line(x, y + (80 * scale), x - (30 * scale), y + (150 * scale));
    line(x, y + (80 * scale), x + (30 * scale), y + (150 * scale));
  }
  
  /**
   * Draws random composite objects with color based on odd or even count.
   *
   * @param count The number of composite objects to draw.
   * @author J. Lai
   */
  public void drawRandomCompositeObjects(int count) {
    int col;
    if (count % 2 == 0) {
        col = color(255, 0, 0); // Red for even count
    } else {
        col = color(0, 255, 0); // Green for odd count
    }
    for (int i = 0; i < count; i++) {
        float x = random(width);
        float y = random(height);
        float scale = random(0.2f, 0.5f);
        float size = random(50, 150);
        drawCompositeObject(x, y, scale, col, size);
    }
  }
  
  /**
   * Draws a composite object with additional parameters for color and size.
   *
   * @param x The x-coordinate of the composite object.
   * @param y The y-coordinate of the composite object.
   * @param scale The scale factor of the composite object.
   * @param col The color of the composite object.
   * @param objectSize The size of the composite object.
   * @author J. Lai
   */
  public void drawCompositeObject(float x, float y, float scale, int col, float objectSize) {
    fill(col);
    ellipse(x, y, objectSize * scale, objectSize * scale);
  }
}