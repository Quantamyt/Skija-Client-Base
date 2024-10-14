package dev.quantam.skija.core;

import dev.quantam.skija.core.state.UIState;
import lombok.Getter;
import lombok.Setter;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

import io.github.humbleui.skija.*;
import io.github.humbleui.skija.ColorSpace;
import io.github.humbleui.skija.Surface;
import io.github.humbleui.skija.BackendRenderTarget;
import io.github.humbleui.skija.SurfaceOrigin;
import io.github.humbleui.skija.SurfaceColorFormat;

import java.util.function.Consumer;

/**
 * SkiaRenderer handles the rendering operations using the Skia graphics library.
 * It provides methods for initializing the context, creating surfaces,
 * and rendering with Skia.
 *
 * @author quantamyt
 *
 * This code is released under the Creative Commons Attribution 4.0 International License (CC BY 4.0).
 * You are free to share and adapt this code, provided appropriate credit is given to the original author.
 * For more details, visit: <a href="https://creativecommons.org/licenses/by/4.0/deed.en">Creative Commons</a>
 */
@Getter
@Setter
public class SkiaRenderer {
    private static DirectContext context = null;
    private static Surface surface;
    private static BackendRenderTarget renderTarget;

    /**
     * Retrieves the current {@link Canvas} instance used for drawing with Skia.
     *
     * @return the current {@link Canvas} instance.
     */
    public static Canvas getCanvas() {
        return surface.getCanvas();
    }

    /**
     * Initializes the Skia rendering context.
     * Creates a new DirectContext if one doesn't already exist.
     */
    public static void initialize() {
        if (context == null) {
            context = DirectContext.makeGL();
        }
    }

    /**
     * Creates a surface with the current display width and height.
     */
    public static void createSurface() {
        createSurface(Display.getWidth(), Display.getHeight());
    }

    /**
     * Creates a surface with the specified width and height.
     *
     * @param width  the width of the surface.
     * @param height the height of the surface.
     */
    public static void createSurface(int width, int height) {
        initialize();
        int framebufferObject = Minecraft.getMinecraft().getFramebuffer().framebufferObject;
        renderTarget = BackendRenderTarget.makeGL(width, height, 0, 8, framebufferObject, GL11.GL_RGBA8);
        surface = Surface.makeFromBackendRenderTarget(
                context, renderTarget, SurfaceOrigin.BOTTOM_LEFT, SurfaceColorFormat.RGBA_8888, ColorSpace.getSRGB()
        );
    }

    /**
     * Prepares the context for rendering by backing up the UI state,
     * clearing the color, and resetting the OpenGL context.
     */
    public static void preFlush() {
        UIState.backup();
        GlStateManager.clearColor(0f, 0f, 0f, 0f);
        if (context != null) {
            context.resetGLAll();
        }

        GL11.glDisable(GL11.GL_ALPHA_TEST);
    }

    /**
     * Flushes the rendering context, executing all pending drawing commands.
     */
    public static void flush() {
        if (context != null) {
            context.flush();
        }
        UIState.restore();
    }

    /**
     * Renders the given drawing logic on the canvas.
     *
     * @param drawingLogic a {@link Consumer} that defines the drawing logic.
     */
    public static void render(Consumer<Canvas> drawingLogic) {
        preFlush();
        Canvas canvas = getCanvas();
        drawingLogic.accept(canvas);
        flush();
    }

    /**
     * Handles resizing of the Skia renderer by creating a new surface with
     * the specified dimensions.
     *
     * @param newWidth  the new width of the surface.
     * @param newHeight the new height of the surface.
     */
    public static void onResize(int newWidth, int newHeight) {
        if (surface != null) {
            surface.close();
        }

        if (renderTarget != null) {
            renderTarget.close();
        }
        createSurface(newWidth, newHeight);
    }
}
