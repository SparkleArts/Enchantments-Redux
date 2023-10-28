
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.enchantmentsplusplusredux.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.enchantment.Enchantment;

import net.mcreator.enchantmentsplusplusredux.enchantment.SteadfastEnchantment;
import net.mcreator.enchantmentsplusplusredux.EnchantmentsplusplusReduxMod;

public class EnchantmentsplusplusReduxModEnchantments {
	public static final DeferredRegister<Enchantment> REGISTRY = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, EnchantmentsplusplusReduxMod.MODID);
	public static final RegistryObject<Enchantment> STEADFAST = REGISTRY.register("steadfast", () -> new SteadfastEnchantment());
}
