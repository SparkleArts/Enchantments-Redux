package net.mcreator.enchantmentsplusplusredux.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.enchantmentsplusplusredux.network.EnchantmentsplusplusReduxModVariables;
import net.mcreator.enchantmentsplusplusredux.ServerConfig;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class GlobalMapManagerProcedure {
	@SubscribeEvent
	public static void onWorldTick(TickEvent.WorldTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.world);
		}
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		EnchantmentsplusplusReduxModVariables.MapVariables.get(world).enableCriticalMod = ServerConfig.EnchCategory.CriticalEnch.CriticalMod;
		EnchantmentsplusplusReduxModVariables.MapVariables.get(world).syncData(world);
	}
}
