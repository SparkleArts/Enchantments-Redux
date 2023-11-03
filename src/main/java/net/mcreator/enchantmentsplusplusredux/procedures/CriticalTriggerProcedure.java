package net.mcreator.enchantmentsplusplusredux.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.enchantmentsplusplusredux.network.EnchantmentsplusplusReduxModVariables;
import net.mcreator.enchantmentsplusplusredux.init.EnchantmentsplusplusReduxModEnchantments;
import net.mcreator.enchantmentsplusplusredux.init.EnchantmentsplusplusReduxModAttributes;
import net.mcreator.enchantmentsplusplusredux.ServerConfig;

import javax.annotation.Nullable;

import java.util.UUID;

@Mod.EventBusSubscriber
public class CriticalTriggerProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level, event.player);
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double CriticalChanceModifier = 0;
		double CriticalDamageModifier = 0;
		CriticalChanceModifier = ServerConfig.EnchCategory.CriticalEnch.CriticalChance;
		CriticalDamageModifier = ServerConfig.EnchCategory.CriticalEnch.CriticalDamage;
		if (EnchantmentsplusplusReduxModVariables.MapVariables.get(world).enableCriticalMod == true) {
			if (EnchantmentHelper.getItemEnchantmentLevel(EnchantmentsplusplusReduxModEnchantments.CRITICAL.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0) {
				if (!(((LivingEntity) entity).getAttribute(EnchantmentsplusplusReduxModAttributes.CRITCHANCE.get())
						.hasModifier((new AttributeModifier(UUID.fromString("ba8ba87b-05c1-49ec-b12f-2933f9d0eed8"), "crit_chance",
								(CriticalChanceModifier * EnchantmentHelper.getItemEnchantmentLevel(EnchantmentsplusplusReduxModEnchantments.CRITICAL.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY))),
								AttributeModifier.Operation.ADDITION)))))
					((LivingEntity) entity).getAttribute(EnchantmentsplusplusReduxModAttributes.CRITCHANCE.get())
							.addTransientModifier((new AttributeModifier(UUID.fromString("ba8ba87b-05c1-49ec-b12f-2933f9d0eed8"), "crit_chance",
									(CriticalChanceModifier * EnchantmentHelper.getItemEnchantmentLevel(EnchantmentsplusplusReduxModEnchantments.CRITICAL.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY))),
									AttributeModifier.Operation.ADDITION)));
				if (!(((LivingEntity) entity).getAttribute(EnchantmentsplusplusReduxModAttributes.CRITDAMAGE.get())
						.hasModifier((new AttributeModifier(UUID.fromString("6232bd52-f387-4588-b1c2-a6618ad184a5"), "crit_damage",
								(CriticalDamageModifier * EnchantmentHelper.getItemEnchantmentLevel(EnchantmentsplusplusReduxModEnchantments.CRITICAL.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY))),
								AttributeModifier.Operation.ADDITION)))))
					((LivingEntity) entity).getAttribute(EnchantmentsplusplusReduxModAttributes.CRITDAMAGE.get())
							.addTransientModifier((new AttributeModifier(UUID.fromString("6232bd52-f387-4588-b1c2-a6618ad184a5"), "crit_damage",
									(CriticalDamageModifier * EnchantmentHelper.getItemEnchantmentLevel(EnchantmentsplusplusReduxModEnchantments.CRITICAL.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY))),
									AttributeModifier.Operation.ADDITION)));
			} else {
				((LivingEntity) entity).getAttribute(EnchantmentsplusplusReduxModAttributes.CRITCHANCE.get())
						.removeModifier((new AttributeModifier(UUID.fromString("ba8ba87b-05c1-49ec-b12f-2933f9d0eed8"), "crit_chance",
								(CriticalChanceModifier * EnchantmentHelper.getItemEnchantmentLevel(EnchantmentsplusplusReduxModEnchantments.CRITICAL.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY))),
								AttributeModifier.Operation.ADDITION)));
				((LivingEntity) entity).getAttribute(EnchantmentsplusplusReduxModAttributes.CRITDAMAGE.get())
						.removeModifier((new AttributeModifier(UUID.fromString("6232bd52-f387-4588-b1c2-a6618ad184a5"), "crit_damage",
								(CriticalDamageModifier * EnchantmentHelper.getItemEnchantmentLevel(EnchantmentsplusplusReduxModEnchantments.CRITICAL.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY))),
								AttributeModifier.Operation.ADDITION)));
			}
		} else {
			if (EnchantmentHelper.getItemEnchantmentLevel(EnchantmentsplusplusReduxModEnchantments.CRITICAL.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)) != 0) {
				if (!(((LivingEntity) entity).getAttribute(EnchantmentsplusplusReduxModAttributes.CRITDAMAGE.get())
						.hasModifier((new AttributeModifier(UUID.fromString("6232bd52-f387-4588-b1c2-a6618ad184a5"), "crit_damage",
								(CriticalDamageModifier * EnchantmentHelper.getItemEnchantmentLevel(EnchantmentsplusplusReduxModEnchantments.CRITICAL.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY))),
								AttributeModifier.Operation.ADDITION)))))
					((LivingEntity) entity).getAttribute(EnchantmentsplusplusReduxModAttributes.CRITDAMAGE.get())
							.addTransientModifier((new AttributeModifier(UUID.fromString("6232bd52-f387-4588-b1c2-a6618ad184a5"), "crit_damage",
									(CriticalDamageModifier * EnchantmentHelper.getItemEnchantmentLevel(EnchantmentsplusplusReduxModEnchantments.CRITICAL.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY))),
									AttributeModifier.Operation.ADDITION)));
			} else {
				((LivingEntity) entity).getAttribute(EnchantmentsplusplusReduxModAttributes.CRITDAMAGE.get())
						.removeModifier((new AttributeModifier(UUID.fromString("6232bd52-f387-4588-b1c2-a6618ad184a5"), "crit_damage",
								(CriticalDamageModifier * EnchantmentHelper.getItemEnchantmentLevel(EnchantmentsplusplusReduxModEnchantments.CRITICAL.get(), (entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY))),
								AttributeModifier.Operation.ADDITION)));
			}
		}
	}
}
