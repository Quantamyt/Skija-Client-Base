package dev.quantam.skija.core.ui.util;

import lombok.Getter;
import lombok.Setter;

/**
 * UIWindow represents a simple rectangular UI window with defined position and dimensions.
 * It can be initialized with specific width and height, and has options to center itself on the screen.
 *
 * This class is intended to be created using the UIWindowBuilder.
 *
 * @author quantamyt
 *
 * This code is released under the Creative Commons Attribution 4.0 International License (CC BY 4.0).
 * You are free to share and adapt this code, provided appropriate credit is given to the original author.
 * For more details, visit: <a href="https://creativecommons.org/licenses/by/4.0/deed.en">Creative Commons</a>
 */
@Getter
@Setter
public class UIWindow {
   private float x;      // The X coordinate of the window
   private float y;      // The Y coordinate of the window
   private float width;  // The width of the window
   private float height; // The height of the window

   /**
    * Private constructor to prevent direct instantiation.
    * UIWindow should be created using the UIWindowBuilder class.
    *
    * @param x      The X coordinate of the window.
    * @param y      The Y coordinate of the window.
    * @param width  The width of the window.
    * @param height The height of the window.
    */
   UIWindow(float x, float y, float width, float height) {
      this.x = x;
      this.y = y;
      this.width = width;
      this.height = height;
   }
}
