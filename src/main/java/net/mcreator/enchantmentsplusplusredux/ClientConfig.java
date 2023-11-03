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

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import static endorh.simpleconfig.api.ConfigBuilderFactoryProxy.*;

import java.util.function.Supplier;

import endorh.simpleconfig.api.ui.icon.SimpleConfigIcons;
import endorh.simpleconfig.api.annotation.ConfigClass;
import endorh.simpleconfig.api.annotation.Bind;
import endorh.simpleconfig.api.SimpleConfigBuilder;
import endorh.simpleconfig.api.SimpleConfig;

@ConfigClass(modId = EnchantmentsplusplusReduxMod.MODID, type = SimpleConfig.Type.CLIENT)
@OnlyIn(Dist.CLIENT)
public class ClientConfig {
	static Supplier<Boolean> enchDebug = () -> false;

	@Bind
	public static SimpleConfigBuilder build(SimpleConfigBuilder builder) {
		return builder
		.n(category("ClientCategory")
			.withColor(0x6490FF80)
			.withIcon(SimpleConfigIcons.Types.CLIENT)
			.add("EnchDebugMode", enable(false).temp().editable(enchDebug))
		);
	}

	@Bind
	public static class ClientCategory {
		@Bind
		public static boolean EnchDebugMode;
	}
}
