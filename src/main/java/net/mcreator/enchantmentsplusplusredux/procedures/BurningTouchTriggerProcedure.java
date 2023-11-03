package net.mcreator.enchantmentsplusplusredux.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.living.LivingAttackEvent;

import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.enchantmentsplusplusredux.init.EnchantmentsplusplusReduxModMobEffects;
import net.mcreator.enchantmentsplusplusredux.init.EnchantmentsplusplusReduxModEnchantments;
import net.mcreator.enchantmentsplusplusredux.ServerConfig;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class BurningTouchTriggerProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getEntity(), event.getSource().getEntity());
		}
	}

	public static void execute(Entity entity, Entity sourceentity) {
		execute(null, entity, sourceentity);
	}

	private static void execute(@Nullable Event event, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		double BasePotionLevel = 0;
		double PotionLevel = 0;
		double BurningTouchLevel = 0;
		double BurningTouchDuration = 0;
		BasePotionLevel = ServerConfig.EnchCategory.BurningTouchEnch.BurningTouchBaseLevel;
		BurningTouchDuration = ServerConfig.EnchCategory.BurningTouchEnch.BurningTouchDuration;
		if (EnchantmentHelper.getItemEnchantmentLevel(EnchantmentsplusplusReduxModEnchantments.BURNING_TOUCH.get(), (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY)) != 0) {
			PotionLevel = BasePotionLevel
					* EnchantmentHelper.getItemEnchantmentLevel(EnchantmentsplusplusReduxModEnchantments.BURNING_TOUCH.get(), (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY));
			BurningTouchLevel = PotionLevel - 1;
			if (sourceentity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(EnchantmentsplusplusReduxModMobEffects.ENCH_BURNING_TOUCH.get(), (int) BurningTouchDuration, (int) BurningTouchLevel));
		} else if (EnchantmentHelper.getItemEnchantmentLevel(EnchantmentsplusplusReduxModEnchantments.BURNING_TOUCH.get(), (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY)) != 0) {
			PotionLevel = BasePotionLevel
					* EnchantmentHelper.getItemEnchantmentLevel(EnchantmentsplusplusReduxModEnchantments.BURNING_TOUCH.get(), (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY));
			BurningTouchLevel = PotionLevel - 1;
			if (sourceentity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(EnchantmentsplusplusReduxModMobEffects.ENCH_BURNING_TOUCH.get(), (int) BurningTouchDuration, (int) BurningTouchLevel));
		} else if (EnchantmentHelper.getItemEnchantmentLevel(EnchantmentsplusplusReduxModEnchantments.BURNING_TOUCH.get(), (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY)) != 0) {
			PotionLevel = BasePotionLevel
					* EnchantmentHelper.getItemEnchantmentLevel(EnchantmentsplusplusReduxModEnchantments.BURNING_TOUCH.get(), (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY));
			BurningTouchLevel = PotionLevel - 1;
			if (sourceentity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(EnchantmentsplusplusReduxModMobEffects.ENCH_BURNING_TOUCH.get(), (int) BurningTouchDuration, (int) BurningTouchLevel));
		} else if (EnchantmentHelper.getItemEnchantmentLevel(EnchantmentsplusplusReduxModEnchantments.BURNING_TOUCH.get(), (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY)) != 0) {
			PotionLevel = BasePotionLevel
					* EnchantmentHelper.getItemEnchantmentLevel(EnchantmentsplusplusReduxModEnchantments.BURNING_TOUCH.get(), (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY));
			BurningTouchLevel = PotionLevel - 1;
			if (sourceentity instanceof LivingEntity _entity && !_entity.level.isClientSide())
				_entity.addEffect(new MobEffectInstance(EnchantmentsplusplusReduxModMobEffects.ENCH_BURNING_TOUCH.get(), (int) BurningTouchDuration, (int) BurningTouchLevel));
		}
	}
}
