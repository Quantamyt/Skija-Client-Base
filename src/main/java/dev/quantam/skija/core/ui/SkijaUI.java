package dev.quantam.skija.core.ui;

import dev.quantam.skija.core.SkiaRenderer;
import net.minecraft.client.gui.GuiScreen;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;

/**
 * SkijaUI is an abstract class that serves as a base for creating UI screens
 * using the Skia graphics library. It extends the Minecraft GuiScreen class
 * to provide custom rendering and mouse interaction capabilities.
 *
 * Subclasses must implement the rendering and mouse handling logic.
 *
 * @author quantamyt
 *
 * This code is released under the Creative Commons Attribution 4.0 International License (CC BY 4.0).
 * You are free to share and adapt this code, provided appropriate credit is given to the original author.
 * For more details, visit: <a href="https://creativecommons.org/licenses/by/4.0/deed.en">Creative Commons</a>
 */
public abstract class SkijaUI extends GuiScreen {
    /**
     * Renders the UI elements at the specified mouse coordinates.
     *
     * @param mouseX The X coordinate of the mouse.
     * @param mouseY The Y coordinate of the mouse.
     */
    public abstract void renderUI(float mouseX, float mouseY);

    /**
     * Handles mouse press events.
     *
     * @param mouseX The X coordinate of the mouse.
     * @param mouseY The Y coordinate of the mouse.
     * @param mouseButton The mouse button that was pressed.
     */
    public abstract void mousePressed(float mouseX, float mouseY, int mouseButton);

    /**
     * Handles mouse release events.
     *
     * @param mouseX The X coordinate of the mouse.
     * @param mouseY The Y coordinate of the mouse.
     */
    public abstract void mouseReleased(float mouseX, float mouseY);

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        super.drawScreen(mouseX, mouseY, partialTicks);
        SkiaRenderer.render((context) -> this.renderUI((float) Mouse.getX(), (float) Display.getHeight() - Mouse.getY()));
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) {
        this.mousePressed((float) Mouse.getX(), (float) Display.getHeight() - Mouse.getY(), mouseButton);
    }

    @Override
    protected void mouseReleased(int mouseX, int mouseY, int state) {
        this.mouseReleased((float) Mouse.getX(), (float) Display.getHeight() - Mouse.getY());
    }
}
