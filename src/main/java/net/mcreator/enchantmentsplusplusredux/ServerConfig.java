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

import endorh.simpleconfig.api.annotation.ConfigClass;
import endorh.simpleconfig.api.annotation.Bind;
import endorh.simpleconfig.api.SimpleConfigBuilder;
import endorh.simpleconfig.api.SimpleConfig;

import net.minecraft.network.chat.TextComponent;

import static endorh.simpleconfig.api.ConfigBuilderFactoryProxy.*;
import endorh.simpleconfig.api.annotation.Bake;

@ConfigClass(modId = EnchantmentsplusplusReduxMod.MODID, type = SimpleConfig.Type.SERVER)
public class ServerConfig {
	@Bind public static SimpleConfigBuilder build(SimpleConfigBuilder builder) {
		return builder
			.n(category("EnchCategory")
				.withColor(0xCF4647FF)
				.n(group("SteadfastEnch")
					.add("BaseReductionModifier", number(0.05).range(0.01, 0.05).slider(v -> new TextComponent(String.format("%.0f %%", v * 100))))
				)
				.n(group("AcrobatEnch")
					.add("AcrobatSpeedValue", number(0.03).range(0.01, 0.10).slider(v -> new TextComponent(String.format("%.0f %%", v * 100))))
				)
				.n(group("BurningTouchEnch")
					.add("BurningTouchBaseLevel", number(1).min(1).max(3).slider())
					.add("BurningTouchDuration", number(100).min(100).max(200).slider())
					.add("BurningTouchCooldown", number(10).min(5).max(30).slider())
				)
			);
	}
	
	@Bind public static class EnchCategory {
		// Steadfast Enchantment
		@Bind public static class SteadfastEnch {
			@Bind public static double BaseReductionModifier;
		}
		
		// Acrobat Enchantment
		@Bind public static class AcrobatEnch {
			@Bind public static double AcrobatSpeedValue;
		}

		// Burning Touch Enchantment
		@Bind public static class BurningTouchEnch {
			@Bind public static int BurningTouchBaseLevel;
			@Bind public static int BurningTouchDuration;
			@Bind public static int BurningTouchCooldown;
		}
	}
}
