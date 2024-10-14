package dev.quantam.skija.core.ui.util;

import org.lwjgl.opengl.Display;

/**
 * UIWindowBuilder provides a flexible way to create instances of UIWindow.
 * It allows customization of the window's size, position, and the option to center the window on the screen.
 *
 * @author quantamyt
 *
 * This code is released under the Creative Commons Attribution 4.0 International License (CC BY 4.0).
 * You are free to share and adapt this code, provided appropriate credit is given to the original author.
 * For more details, visit: <a href="https://creativecommons.org/licenses/by/4.0/deed.en">Creative Commons</a>
 */
public class UIWindowBuilder {
    private float x;      // The X coordinate of the window
    private float y;      // The Y coordinate of the window
    private float width;  // The width of the window
    private float height; // The height of the window
    private boolean center = false;  // Whether to center the window on the screen

    /**
     * Sets the width of the UIWindow.
     *
     * @param width The width of the window.
     * @return The current instance of UIWindowBuilder.
     */
    public UIWindowBuilder width(float width) {
        this.width = width;
        return this;
    }

    /**
     * Sets the height of the UIWindow.
     *
     * @param height The height of the window.
     * @return The current instance of UIWindowBuilder.
     */
    public UIWindowBuilder height(float height) {
        this.height = height;
        return this;
    }

    /**
     * Sets the position (x, y) of the UIWindow.
     *
     * @param x The X coordinate of the window.
     * @param y The Y coordinate of the window.
     * @return The current instance of UIWindowBuilder.
     */
    public UIWindowBuilder position(float x, float y) {
        this.x = x;
        this.y = y;
        return this;
    }

    /**
     * Centers the UIWindow on the screen.
     *
     * @return The current instance of UIWindowBuilder.
     */
    public UIWindowBuilder centerOnScreen() {
        this.center = true;
        return this;
    }

    /**
     * Builds the UIWindow instance. If the centerOnScreen option is set, it calculates
     * the X and Y coordinates to center the window on the display.
     *
     * @return A UIWindow instance with the defined properties.
     */
    public UIWindow build() {
        if (center) {
            x = (float) Display.getWidth() / 2.0f - width / 2.0f;
            y = (float) Display.getHeight() / 2.0f - height / 2.0f;
        }
        return new UIWindow(x, y, width, height);
    }
}
