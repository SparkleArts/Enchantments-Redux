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
import net.mcreator.enchantmentsplusplusredux.ServerConfig;

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
		AcrobatInitialSpeed = (double) ServerConfig.EnchCategory.AcrobatEnch.AcrobatSpeedValue;
		if (EnchantmentHelper.getItemEnchantmentLevel(EnchantmentsplusplusReduxModEnchantments.ACROBAT.get(), (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY)) != 0) {
			if (!(((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED)
					.hasModifier((new AttributeModifier(UUID.fromString("50b99ec1-e214-4c2a-9642-7b5a144c1d59"), "acrobat_speed", (AcrobatInitialSpeed
							* EnchantmentHelper.getItemEnchantmentLevel(EnchantmentsplusplusReduxModEnchantments.ACROBAT.get(), (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY))),
							AttributeModifier.Operation.ADDITION)))))
				((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED)
						.addTransientModifier((new AttributeModifier(UUID.fromString("50b99ec1-e214-4c2a-9642-7b5a144c1d59"), "acrobat_speed", (AcrobatInitialSpeed
								* EnchantmentHelper.getItemEnchantmentLevel(EnchantmentsplusplusReduxModEnchantments.ACROBAT.get(), (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY))),
								AttributeModifier.Operation.ADDITION)));
		} else {
			((LivingEntity) entity).getAttribute(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED)
					.removeModifier((new AttributeModifier(UUID.fromString("50b99ec1-e214-4c2a-9642-7b5a144c1d59"), "acrobat_speed", (AcrobatInitialSpeed
							* EnchantmentHelper.getItemEnchantmentLevel(EnchantmentsplusplusReduxModEnchantments.ACROBAT.get(), (entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY))),
							AttributeModifier.Operation.ADDITION)));
		}
	}
}
