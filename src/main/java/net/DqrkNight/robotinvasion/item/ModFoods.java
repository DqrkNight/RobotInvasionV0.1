package net.DqrkNight.robotinvasion.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties RATION = new FoodProperties.Builder().nutrition(9)
            .saturationMod(0.6f).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 200 ), 0.3f).build();

    public static final FoodProperties BEAN= new FoodProperties.Builder().nutrition(2)
            .saturationMod(0.1f).build();

}
