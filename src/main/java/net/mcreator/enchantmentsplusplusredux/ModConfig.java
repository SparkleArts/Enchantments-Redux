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

import dev.toma.configuration.config.Config;
import net.mcreator.enchantmentsplusplusredux.EnchantmentsplusplusReduxMod;
import dev.toma.configuration.config.Configurable;

@Config(id = EnchantmentsplusplusReduxMod.MODID)
public class ModConfig {
	@Configurable
	@Configurable.Comment("Configure the Steadfast enchantment")
	public EnchantmentSteadfastConfig steadfastEnch = new EnchantmentSteadfastConfig();
}
