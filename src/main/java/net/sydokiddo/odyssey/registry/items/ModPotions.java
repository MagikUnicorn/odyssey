package net.sydokiddo.odyssey.registry.items;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;
import net.sydokiddo.chrysalis.misc.util.RegistryHelpers;
import net.sydokiddo.odyssey.Odyssey;

public class ModPotions {

    private static Potion MINING_FATIGUE;
    private static Potion LONG_MINING_FATIGUE;
    private static Potion STRONG_MINING_FATIGUE;

    private static Potion HASTE;
    private static Potion LONG_HASTE;
    private static Potion STRONG_HASTE;

    // Register Potion Stats:

    public static Potion registerMiningFatiguePotion(String name) {
        return Registry.register(BuiltInRegistries.POTION, new ResourceLocation(Odyssey.MOD_ID, name),
        new Potion(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 3600, 0)));
    }
    public static Potion registerLongMiningFatiguePotion(String name) {
        return Registry.register(BuiltInRegistries.POTION, new ResourceLocation(Odyssey.MOD_ID, name),
        new Potion(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 9600, 0)));
    }
    public static Potion registerStrongMiningFatiguePotion(String name) {
        return Registry.register(BuiltInRegistries.POTION, new ResourceLocation(Odyssey.MOD_ID, name),
        new Potion(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 1800, 1)));
    }
    public static Potion registerHastePotion(String name) {
        return Registry.register(BuiltInRegistries.POTION, new ResourceLocation(Odyssey.MOD_ID, name),
        new Potion(new MobEffectInstance(MobEffects.DIG_SPEED, 3600, 0)));
    }
    public static Potion registerLongHastePotion(String name) {
        return Registry.register(BuiltInRegistries.POTION, new ResourceLocation(Odyssey.MOD_ID, name),
        new Potion(new MobEffectInstance(MobEffects.DIG_SPEED, 9600, 0)));
    }
    public static Potion registerStrongHastePotion(String name) {
        return Registry.register(BuiltInRegistries.POTION, new ResourceLocation(Odyssey.MOD_ID, name),
        new Potion(new MobEffectInstance(MobEffects.DIG_SPEED, 1800, 1)));
    }

    // Register Potions:

    public static void registerPotions() {

        MINING_FATIGUE = registerMiningFatiguePotion("mining_fatigue");
        LONG_MINING_FATIGUE = registerLongMiningFatiguePotion("long_mining_fatigue");
        STRONG_MINING_FATIGUE = registerStrongMiningFatiguePotion("strong_mining_fatigue");

        RegistryHelpers.registerBasePotionRecipe(ModItems.ELDER_GUARDIAN_THORN, ModPotions.MINING_FATIGUE);
        RegistryHelpers.registerLongPotionRecipe(ModPotions.MINING_FATIGUE, ModPotions.LONG_MINING_FATIGUE);
        RegistryHelpers.registerStrongPotionRecipe(ModPotions.MINING_FATIGUE, ModPotions.STRONG_MINING_FATIGUE);

        HASTE = registerHastePotion("haste");
        LONG_HASTE = registerLongHastePotion("long_haste");
        STRONG_HASTE = registerStrongHastePotion("strong_haste");

        RegistryHelpers.registerInvertedPotionRecipe(ModPotions.MINING_FATIGUE, ModPotions.HASTE);

        RegistryHelpers.registerLongPotionRecipe(ModPotions.HASTE, ModPotions.LONG_HASTE);
        RegistryHelpers.registerInvertedPotionRecipe(ModPotions.LONG_MINING_FATIGUE, ModPotions.LONG_HASTE);

        RegistryHelpers.registerStrongPotionRecipe(ModPotions.HASTE, ModPotions.STRONG_HASTE);
        RegistryHelpers.registerInvertedPotionRecipe(ModPotions.STRONG_MINING_FATIGUE, ModPotions.STRONG_HASTE);
    }
}