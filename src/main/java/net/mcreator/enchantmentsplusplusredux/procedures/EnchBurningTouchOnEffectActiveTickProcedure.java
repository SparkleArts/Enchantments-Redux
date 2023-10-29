package net.mcreator.enchantmentsplusplusredux.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.enchantmentsplusplusredux.CommonConfig;

public class EnchBurningTouchOnEffectActiveTickProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		double BurningTouchCooldown = 0;
		BurningTouchCooldown = CommonConfig.EnchCategory.BurningTouchEnch.BurningTouchCooldown;
		entity.setSecondsOnFire((int) BurningTouchCooldown);
	}
}
