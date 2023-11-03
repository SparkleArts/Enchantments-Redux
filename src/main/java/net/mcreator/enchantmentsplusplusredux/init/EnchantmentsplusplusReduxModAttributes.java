/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.enchantmentsplusplusredux.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLConstructModEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.EntityAttributeModificationEvent;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.EntityType;

import net.mcreator.enchantmentsplusplusredux.EnchantmentsplusplusReduxMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class EnchantmentsplusplusReduxModAttributes {
	public static final DeferredRegister<Attribute> ATTRIBUTES = DeferredRegister.create(ForgeRegistries.ATTRIBUTES, EnchantmentsplusplusReduxMod.MODID);
	public static final RegistryObject<Attribute> CRITCHANCE = ATTRIBUTES.register("crit_chance", () -> (new RangedAttribute("attribute." + EnchantmentsplusplusReduxMod.MODID + ".crit_chance", 0.2, 0.01, 1)).setSyncable(true));
	public static final RegistryObject<Attribute> CRITDAMAGE = ATTRIBUTES.register("crit_damage", () -> (new RangedAttribute("attribute." + EnchantmentsplusplusReduxMod.MODID + ".crit_damage", 0.5, 0.01, 1)).setSyncable(true));

	@SubscribeEvent
	public static void register(FMLConstructModEvent event) {
		event.enqueueWork(() -> {
			ATTRIBUTES.register(FMLJavaModLoadingContext.get().getModEventBus());
		});
	}

	@SubscribeEvent
	public static void addAttributes(EntityAttributeModificationEvent event) {
		event.add(EntityType.PLAYER, CRITCHANCE.get());
		event.add(EntityType.PLAYER, CRITDAMAGE.get());
	}

	@Mod.EventBusSubscriber
	private class Utils {
		@SubscribeEvent
		public static void persistAttributes(PlayerEvent.Clone event) {
			Player oldP = event.getOriginal();
			Player newP = (Player) event.getEntity();
			newP.getAttribute(CRITCHANCE.get()).setBaseValue(oldP.getAttribute(CRITCHANCE.get()).getBaseValue());
			newP.getAttribute(CRITDAMAGE.get()).setBaseValue(oldP.getAttribute(CRITDAMAGE.get()).getBaseValue());
		}
	}
}
