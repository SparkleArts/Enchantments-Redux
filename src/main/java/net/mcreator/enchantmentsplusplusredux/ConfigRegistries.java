/**
 * The code of this mod element is always locked.
 *
 * You can register new events in this class too.
 *
 * If you want to make a plain independent class, create it using
 * Project Browser -> New... and make sure to make the class
 * outside net.mcreator.enchantmentsplusplusredux as this package is managed by MCreator.
 *
 * If you change workspace package, modid or prefix, you will need
 * to manually adapt this file to these changes or remake it.
 *
 * This class will be added in the mod root package.
*/
package net.mcreator.enchantmentsplusplusredux;

import dev.toma.configuration.config.format.ConfigFormats;
import dev.toma.configuration.Configuration;
import net.mcreator.enchantmentsplusplusredux.ModConfig;

public class ConfigRegistries {

	public static ModConfig config;

	public ConfigRegistries() {
		config = Configuration.registerConfig(ModConfig.class, ConfigFormats.yaml()).getConfigInstance();
	}
}
