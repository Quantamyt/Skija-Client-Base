package dev.quantam.skija;

import net.fabricmc.api.ClientModInitializer;

/**
 * EntryPoint serves as the main entry point for the Skija mod, implementing the
 * Fabric ClientModInitializer interface to initialize client-side features.
 *
 * @author quantamyt
 *
 * This code is released under the Creative Commons Attribution 4.0 International License (CC BY 4.0).
 * You are free to share and adapt this code, provided appropriate credit is given to the original author.
 * For more details, visit: <a href="https://creativecommons.org/licenses/by/4.0/deed.en">Creative Commons</a>
 *
 * Code Overview:
 * - The EntryPoint class is a part of the Fabric modding framework for Minecraft.
 * - The onInitializeClient method is called when the mod is initialized on the client side.
 * - Currently, this method does not contain any implementation, but it is the
 *   designated location for future client-specific logic and initializations.
 */
public class EntryPoint implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		// Initialization logic for the client-side of the mod can be added here.
	}
}
