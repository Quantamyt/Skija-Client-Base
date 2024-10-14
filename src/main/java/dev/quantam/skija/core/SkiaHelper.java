package dev.quantam.skija.core;

import io.github.humbleui.skija.*;
import io.github.humbleui.types.*;
import java.awt.Color;

/**
 * A utility class providing helper methods for rendering with Skia.
 *
 * @author quantamyt
 *
 * This code is released under the Creative Commons Attribution 4.0 International License (CC BY 4.0).
 * You are free to share and adapt this code, provided appropriate credit is given to the original author.
 * For more details, visit: <a href="https://creativecommons.org/licenses/by/4.0/deed.en">Creative Commons</a>
 */
public class SkiaHelper {

    /**
     * Retrieves the current {@link Canvas} instance used for drawing with Skia.
     *
     * @return the current {@link Canvas} instance.
     */
    private static Canvas getCanvas() {
        return SkiaRenderer.getCanvas();
    }

    /**
     * Draws a string at the specified position using the given font and paint.
     *
     * @param x     The x-coordinate for the text.
     * @param y     The y-coordinate for the text.
     * @param text  The text to draw.
     * @param font  The font to use for drawing the text.
     * @param paint The paint used for coloring the text.
     * @return The height of the drawn text.
     */
    public static float text(float x, float y, String text, Font font, Paint paint) {
        Rect bounds = font.measureText(text);
        getCanvas().drawString(text, x - 2f, (y - 1f) + bounds.getHeight(), font, paint);
        return bounds.getHeight();
    }

    /**
     * Draws centered text at the specified position.
     *
     * @param x     The x-coordinate for the text center.
     * @param y     The y-coordinate for the text center.
     * @param text  The text to draw.
     * @param font  The font to use for drawing the text.
     * @param paint The paint used for coloring the text.
     * @return The height of the drawn text.
     */
    public static float centeredText(float x, float y, String text, Font font, Paint paint) {
        Rect measure = font.measureText(text);
        return text(x - measure.getWidth() / 2f, y - measure.getHeight() / 2f, text, font, paint);
    }

    /**
     * Creates a Paint object using various color formats.
     *
     * @param color The color to use (Color4f or Color).
     * @return A Paint object configured with the specified color.
     */
    public static Paint paint(Object color) {
        Paint paint = new Paint();
        if (color instanceof Color4f) {
            paint.setColor4f((Color4f) color);
        } else if (color instanceof Color) {
            Color c = (Color) color;
            paint.setARGB(c.getAlpha(), c.getRed(), c.getGreen(), c.getBlue());
        }
        return paint;
    }

    /**
     * Returns the width of the specified text when drawn with the given font.
     *
     * @param text The text to measure.
     * @param font The font to use for measuring.
     * @return The width of the text.
     */
    public static float textWidth(String text, Font font) {
        return font.measureTextWidth(text);
    }

    /**
     * Draws a rounded rectangle at the specified position.
     *
     * @param x      The x-coordinate for the rectangle.
     * @param y      The y-coordinate for the rectangle.
     * @param w      The width of the rectangle.
     * @param h      The height of the rectangle.
     * @param radius The radius of the rounded corners.
     * @param paint  The paint used for coloring the rectangle.
     */
    public static void rrect(float x, float y, float w, float h, float radius, Paint paint) {
        getCanvas().drawRRect(RRect.makeXYWH(x, y, w, h, radius), paint);
    }

    /**
     * Creates an ARGB color from a Color object.
     *
     * @param color The Color object to convert.
     * @return The ARGB integer representation of the color.
     */
    private static int colorToArgb(Color color) {
        return (color.getAlpha() << 24) | (color.getRed() << 16) | (color.getGreen() << 8) | color.getBlue();
    }

    /**
     * Draws a gradient rounded rectangle.
     *
     * @param x          The x-coordinate for the rectangle.
     * @param y          The y-coordinate for the rectangle.
     * @param w          The width of the rectangle.
     * @param h          The height of the rectangle.
     * @param radius     The radius of the rounded corners.
     * @param startColor The starting color of the gradient.
     * @param endColor   The ending color of the gradient.
     */
    public static void gradientRRect(float x, float y, float w, float h, float radius, Color startColor, Color endColor) {
        int[] colors = new int[]{
                colorToArgb(startColor),
                colorToArgb(endColor)
        };

        float[] positions = {0.0f, 1.0f};

        Shader gradient = Shader.makeLinearGradient(x, y, x, y + h, colors, positions, GradientStyle.DEFAULT);
        Paint gradientPaint = new Paint().setShader(gradient);
        getCanvas().drawRRect(RRect.makeXYWH(x, y, w, h, radius), gradientPaint);
    }

    /**
     * Draws a shadowed rectangle with configurable properties.
     *
     * @param x      The x-coordinate for the rectangle.
     * @param y      The y-coordinate for the rectangle.
     * @param w      The width of the rectangle.
     * @param h      The height of the rectangle.
     * @param radius  The radius of the rounded corners.
     * @param color   The color of the shadow.
     * @param blur    The blur radius of the shadow.
     * @param offsetX The x-offset for the shadow.
     * @param offsetY The y-offset for the shadow.
     */
    public static void shadow(float x, float y, float w, float h, float radius, Color color, float blur, float offsetX, float offsetY) {
        getCanvas().drawRectShadow(RRect.makeXYWH(x, y, w, h, radius), offsetX, offsetY, blur, 1f, color.getRGB());
    }

    /**
     * Draws a shadowed rectangle with pre-configured properties.
     *
     * @param x      The x-coordinate for the rectangle.
     * @param y      The y-coordinate for the rectangle.
     * @param w      The width of the rectangle.
     * @param h      The height of the rectangle.
     * @param radius  The radius of the rounded corners.
     * @param color   The color of the shadow.
     */
    public static void simpleShadow(float x, float y, float w, float h, float radius, Color color) {
        getCanvas().drawRectShadow(RRect.makeXYWH(x, y, w, h, radius), 0f, 0f, 10f, 1f, color.getRGB());
    }

    /**
     * Draws a rectangle.
     *
     * @param x     The x-coordinate for the rectangle.
     * @param y     The y-coordinate for the rectangle.
     * @param w     The width of the rectangle.
     * @param h     The height of the rectangle.
     * @param paint The paint used for coloring the rectangle.
     */
    public static void rect(float x, float y, float w, float h, Paint paint) {
        getCanvas().drawRect(Rect.makeXYWH(x, y, w, h), paint);
    }
}
