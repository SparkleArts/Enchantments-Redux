
package net.mcreator.enchantmentsplusplusredux.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.enchantmentsplusplusredux.procedures.EnchBurningTouchOnEffectActiveTickProcedure;
import net.mcreator.enchantmentsplusplusredux.procedures.EnchBurningTouchActiveTickConditionProcedure;

public class EnchBurningTouchMobEffect extends MobEffect {
	public EnchBurningTouchMobEffect() {
		super(MobEffectCategory.HARMFUL, -26266);
	}

	@Override
	public String getDescriptionId() {
		return "effect.enchantmentsplusplus_redux.ench_burning_touch";
	}

	@Override
	public void applyEffectTick(LivingEntity entity, int amplifier) {
		EnchBurningTouchOnEffectActiveTickProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return EnchBurningTouchActiveTickConditionProcedure.execute(amplifier, duration);
	}
}
