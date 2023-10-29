package net.mcreator.enchantmentsplusplusredux.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;

import net.mcreator.enchantmentsplusplusredux.init.EnchantmentsplusplusReduxModEnchantments;
import net.mcreator.enchantmentsplusplusredux.CommonConfig;

import javax.annotation.Nullable;

import java.util.UUID;

@Mod.EventBusSubscriber
public class AcrobatTriggerProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		double AcrobatInitialSpeed = 0;
		AcrobatInitialSpeed = CommonConfig.EnchCategory.AcrobatEnch.AcrobatSpeedValue;
		if (EnchantmentHelper.getItemEnchantmentLevel(EnchantmentsplusplusReduxModEnchantments.ACROBAT.get(), (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY)) != 0) {
			if (!(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED)
					.hasModifier((new AttributeModifier(UUID.fromString("5af88843-4b98-400a-b5e2-c25b8c1ac554"), "acrobat_speed", (AcrobatInitialSpeed
							* EnchantmentHelper.getItemEnchantmentLevel(EnchantmentsplusplusReduxModEnchantments.ACROBAT.get(), (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY))),
							AttributeModifier.Operation.ADDITION)))))
				((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED)
						.addTransientModifier((new AttributeModifier(UUID.fromString("5af88843-4b98-400a-b5e2-c25b8c1ac554"), "acrobat_speed", (AcrobatInitialSpeed
								* EnchantmentHelper.getItemEnchantmentLevel(EnchantmentsplusplusReduxModEnchantments.ACROBAT.get(), (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY))),
								AttributeModifier.Operation.ADDITION)));
		} else {
			((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED)
					.removeModifier((new AttributeModifier(UUID.fromString("5af88843-4b98-400a-b5e2-c25b8c1ac554"), "acrobat_speed", (AcrobatInitialSpeed
							* EnchantmentHelper.getItemEnchantmentLevel(EnchantmentsplusplusReduxModEnchantments.ACROBAT.get(), (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY))),
							AttributeModifier.Operation.ADDITION)));
		}
	}
}
