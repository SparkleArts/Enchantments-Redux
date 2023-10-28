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

import dev.toma.configuration.config.Configurable;
import dev.toma.configuration.config.Config;

@Config(id = EnchantmentsplusplusReduxMod.MODID)
public class EnchantmentSteadfastConfig {
	@Configurable
	@Configurable.DecimalRange(min = 0.01, max = 0.05)
	@Configurable.Comment("Base damage reduction modifier. This value is multiplied by the level.")
	@Configurable.Gui.NumberFormat("%")
	public double SteadfastDamageModifier = 0.05;
}
