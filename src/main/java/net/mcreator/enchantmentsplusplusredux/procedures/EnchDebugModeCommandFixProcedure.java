package net.mcreator.enchantmentsplusplusredux.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.CommandEvent;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.TextComponent;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class EnchDebugModeCommandFixProcedure {
	@SubscribeEvent
	public static void onCommand(CommandEvent event) {
		Entity entity = event.getParseResults().getContext().getSource().getEntity();
		if (entity != null) {
			execute(event, entity, event.getParseResults().getReader().getString());
		}
	}

	public static void execute(Entity entity, String command) {
		execute(null, entity, command);
	}

	private static void execute(@Nullable Event event, Entity entity, String command) {
		if (entity == null || command == null)
			return;
		if ((command).equals("config set enchantmentsplusplus_redux client ClientCategory.EnchDebugMode true")) {
			if (event != null && event.isCancelable()) {
				event.setCanceled(true);
			}
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent(("§4" + "This command is disabled by the Mod.")), false);
		} else if ((command).equals("config set enchantmentsplusplus_redux client ClientCategory.EnchDebugMode false")) {
			if (event != null && event.isCancelable()) {
				event.setCanceled(true);
			}
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent(("§4" + "This command is disabled by the Mod.")), false);
		}
	}
}
