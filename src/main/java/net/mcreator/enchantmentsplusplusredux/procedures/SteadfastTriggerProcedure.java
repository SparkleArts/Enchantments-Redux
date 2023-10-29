package net.mcreator.enchantmentsplusplusredux.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingHurtEvent;

import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;

import net.mcreator.enchantmentsplusplusredux.init.EnchantmentsplusplusReduxModEnchantments;
import net.mcreator.enchantmentsplusplusredux.CommonConfig;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class SteadfastTriggerProcedure {
	private static LivingHurtEvent _event;

	@SubscribeEvent
	public static void onEntityAttacked(LivingHurtEvent event) {
		_event = event;
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity(), event.getAmount());
		}
	}

	public static void execute(Entity entity, double amount) {
		execute(null, entity, amount);
	}

	private static void execute(@Nullable Event event, Entity entity, double amount) {
		if (entity == null)
			return;
		double BaseModifier = 0;
		double CalculatedModifier = 0;
		double DamageReductionModifier = 0;
		double BaseReductionModifier = 0;
		BaseModifier = 1;
		BaseReductionModifier = CommonConfig.EnchCategory.SteadfastEnch.BaseReductionModifier;
		if (EnchantmentHelper.getItemEnchantmentLevel(EnchantmentsplusplusReduxModEnchantments.STEADFAST.get(), (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY)) != 0) {
			DamageReductionModifier = BaseReductionModifier
					* EnchantmentHelper.getItemEnchantmentLevel(EnchantmentsplusplusReduxModEnchantments.STEADFAST.get(), (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY));
			CalculatedModifier = BaseModifier - DamageReductionModifier;
			_event.setAmount((float) CalculatedModifier);
		} else if (EnchantmentHelper.getItemEnchantmentLevel(EnchantmentsplusplusReduxModEnchantments.STEADFAST.get(), (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY)) != 0) {
			DamageReductionModifier = BaseReductionModifier
					* EnchantmentHelper.getItemEnchantmentLevel(EnchantmentsplusplusReduxModEnchantments.STEADFAST.get(), (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY));
			CalculatedModifier = BaseModifier - DamageReductionModifier;
			_event.setAmount((float) CalculatedModifier);
		} else if (EnchantmentHelper.getItemEnchantmentLevel(EnchantmentsplusplusReduxModEnchantments.STEADFAST.get(), (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY)) != 0) {
			DamageReductionModifier = BaseReductionModifier
					* EnchantmentHelper.getItemEnchantmentLevel(EnchantmentsplusplusReduxModEnchantments.STEADFAST.get(), (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY));
			CalculatedModifier = BaseModifier - DamageReductionModifier;
			_event.setAmount((float) CalculatedModifier);
		} else if (EnchantmentHelper.getItemEnchantmentLevel(EnchantmentsplusplusReduxModEnchantments.STEADFAST.get(), (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY)) != 0) {
			DamageReductionModifier = BaseReductionModifier
					* EnchantmentHelper.getItemEnchantmentLevel(EnchantmentsplusplusReduxModEnchantments.STEADFAST.get(), (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY));
			CalculatedModifier = BaseModifier - DamageReductionModifier;
			_event.setAmount((float) CalculatedModifier);
		}
	}
}
