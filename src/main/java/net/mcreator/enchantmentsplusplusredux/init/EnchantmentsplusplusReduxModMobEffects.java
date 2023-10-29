
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.enchantmentsplusplusredux.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import net.mcreator.enchantmentsplusplusredux.potion.EnchBurningTouchMobEffect;
import net.mcreator.enchantmentsplusplusredux.EnchantmentsplusplusReduxMod;

public class EnchantmentsplusplusReduxModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, EnchantmentsplusplusReduxMod.MODID);
	public static final RegistryObject<MobEffect> ENCH_BURNING_TOUCH = REGISTRY.register("ench_burning_touch", () -> new EnchBurningTouchMobEffect());
}
