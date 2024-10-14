package dev.quantam.skija.core.util.font;

import io.github.humbleui.skija.Font;

/**
 * FontUtils provides utility methods for retrieving commonly used fonts.
 * Each method returns a Font instance with the specified size.
 *
 * @author quantamyt
 *
 * This code is released under the Creative Commons Attribution 4.0 International License (CC BY 4.0).
 * You are free to share and adapt this code, provided appropriate credit is given to the original author.
 * For more details, visit: <a href="https://creativecommons.org/licenses/by/4.0/deed.en">Creative Commons</a>
 */
public class FontUtils {

    /**
     * Returns the regular Greycliff font with the specified size.
     *
     * @param size The size of the font.
     * @return The Greycliff regular font.
     */
    public static Font greycliffRegular(float size) {
        return FontManager.font("regular.otf", size);
    }

    /**
     * Returns the bold Greycliff font with the specified size.
     *
     * @param size The size of the font.
     * @return The Greycliff bold font.
     */
    public static Font greycliffBold(float size) {
        return FontManager.font("regular_bold.otf", size);
    }

    /**
     * Returns the medium Greycliff font with the specified size.
     *
     * @param size The size of the font.
     * @return The Greycliff medium font.
     */
    public static Font greycliffMedium(float size) {
        return FontManager.font("regular_medium.otf", size);
    }

    /**
     * Returns the semi-bold Greycliff font with the specified size.
     *
     * @param size The size of the font.
     * @return The Greycliff semi-bold font.
     */
    public static Font greycliffSemi(float size) {
        return FontManager.font("regular_semi.otf", size);
    }

    /**
     * Returns the icon font with the specified size.
     *
     * @param size The size of the font.
     * @return The icon font.
     */
    public static Font icon(float size) {
        return FontManager.font("solid.ttf", size);
    }

    /**
     * Returns the regular Minecraft font with the specified size.
     *
     * @param size The size of the font.
     * @return The Minecraft regular font.
     */
    public static Font minecraftRegular(float size) {
        return FontManager.font("MinecraftRegular.ttf", size);
    }

    /**
     * Returns the italic Minecraft font with the specified size.
     *
     * @param size The size of the font.
     * @return The Minecraft italic font.
     */
    public static Font minecraftItalic(float size) {
        return FontManager.font("MinecraftItalic.otf", size);
    }

    /**
     * Returns the bold Minecraft font with the specified size.
     *
     * @param size The size of the font.
     * @return The Minecraft bold font.
     */
    public static Font minecraftBold(float size) {
        return FontManager.font("MinecraftBold.otf", size);
    }
}
