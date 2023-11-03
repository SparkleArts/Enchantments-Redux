package net.mcreator.enchantmentsplusplusredux.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.CriticalHitEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.enchantmentsplusplusredux.network.EnchantmentsplusplusReduxModVariables;
import net.mcreator.enchantmentsplusplusredux.init.EnchantmentsplusplusReduxModAttributes;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class CriticalModificationProcedure {
	private static CriticalHitEvent _event;

	@SubscribeEvent
	public static void onPlayerCriticalHit(CriticalHitEvent event) {
		_event = event;
		execute(event, event.getPlayer().level, event.getPlayer(), event.getDamageModifier());
	}

	public static void execute(LevelAccessor world, Entity sourceentity, double damagemodifier) {
		execute(null, world, sourceentity, damagemodifier);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity sourceentity, double damagemodifier) {
		if (sourceentity == null)
			return;
		if (EnchantmentsplusplusReduxModVariables.MapVariables.get(world).enableCriticalMod == true) {
			if (Math.random() <= ((LivingEntity) sourceentity).getAttribute(EnchantmentsplusplusReduxModAttributes.CRITCHANCE.get()).getValue()) {
				_event.setDamageModifier((float) (1 + ((LivingEntity) sourceentity).getAttribute(EnchantmentsplusplusReduxModAttributes.CRITDAMAGE.get()).getValue()));
				if (event != null && event.hasResult()) {
					event.setResult(Event.Result.ALLOW);
				}
			} else {
				if (event != null && event.hasResult()) {
					event.setResult(Event.Result.DENY);
				}
			}
		} else {
			_event.setDamageModifier((float) (1 + ((LivingEntity) sourceentity).getAttribute(EnchantmentsplusplusReduxModAttributes.CRITDAMAGE.get()).getValue()));
		}
	}
}
