package dev.quantam.skija.mixin;

import dev.quantam.skija.core.SkiaRenderer;
import dev.quantam.skija.front.Panel;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * MinecraftMixin modifies the Minecraft client behavior to integrate Skija rendering capabilities
 * and handle UI interactions through a custom panel.
 *
 * @author quantamyt
 *
 * This code is released under the Creative Commons Attribution 4.0 International License (CC BY 4.0).
 * You are free to share and adapt this code, provided appropriate credit is given to the original author.
 * For more details, visit: <a href="https://creativecommons.org/licenses/by/4.0/deed.en">Creative Commons</a>
 *
 */
@Mixin(Minecraft.class)
public class MinecraftMixin {

    @Inject(method = "startGame", at = @At("RETURN"))
    public void startGame$RETURN(CallbackInfo ci) {
        SkiaRenderer.initialize(); // Initialize Skia rendering
        SkiaRenderer.createSurface(); // Create the rendering surface for Skia
    }

    @Inject(method = "resize", at = @At("RETURN"))
    public void resize(int width, int height, CallbackInfo ci) {
        SkiaRenderer.onResize(width, height); // Adjust Skia rendering surface to new window size
    }

    @Inject(method = "runTick", at = @At("RETURN"))
    public void perTick(CallbackInfo ci) {
        if (Keyboard.isKeyDown(Keyboard.KEY_RSHIFT)) {
            Minecraft.getMinecraft().displayGuiScreen(new Panel());
        }
    }
}
