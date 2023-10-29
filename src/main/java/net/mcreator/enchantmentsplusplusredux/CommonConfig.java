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

import endorh.simpleconfig.api.annotation.Slider;
import endorh.simpleconfig.api.annotation.Min;
import endorh.simpleconfig.api.annotation.Max;
import endorh.simpleconfig.api.annotation.Group;
import endorh.simpleconfig.api.annotation.Entry;
import endorh.simpleconfig.api.annotation.ConfigClass;
import endorh.simpleconfig.api.annotation.Category;
import endorh.simpleconfig.api.SimpleConfig;

@ConfigClass(modId = EnchantmentsplusplusReduxMod.MODID, type = SimpleConfig.Type.COMMON)
public class CommonConfig {
	@Category(color = 0xFFA02829)
	public static class EnchCategory {
		@Group
		public static class SteadfastEnch {
			@Min(0.01)
			@Max(0.05)
			@Slider
			@Entry
			public static double BaseReductionModifier = 0.05;
		}

		@Group
		public static class AcrobatEnch {
			@Min(0.01)
			@Max(0.1)
			@Slider
			@Entry
			public static double AcrobatSpeedValue = 0.03;
		}

		@Group
		public static class BurningTouchEnch {
			@Min(1)
			@Max(3)
			@Slider
			@Entry
			public static int BurningTouchBaseLevel = 1;

			@Min(100)
			@Max(200)
			@Slider
			@Entry
			public static int BurningTouchDuration = 100;

			@Min(5)
			@Max(30)
			@Slider
			@Entry
			public static int BurningTouchCooldown = 10;
		}
	}
}
