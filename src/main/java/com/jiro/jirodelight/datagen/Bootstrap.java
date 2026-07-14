package com.jiro.jirodelight.datagen;

import com.jiro.jirodelight.JiroDelight;
import com.jiro.jirodelight.init.BlockInit;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

public class Bootstrap {
    public static final ResourceKey<ConfiguredFeature<?, ?>> GARLIC_FLOWER_KEY = ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(JiroDelight.MODID, "garlic_flower"));
    public static final ResourceKey<PlacedFeature> PLACED_GARLIC_FLOWER_KEY = ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(JiroDelight.MODID, "garlic_flower"));

    public static void bootstrapFeatures(BootstapContext<ConfiguredFeature<?, ?>> context) {
        context.register(GARLIC_FLOWER_KEY, new ConfiguredFeature<>(Feature.RANDOM_PATCH,
                new RandomPatchConfiguration(1, 1, 1, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(BlockInit.GARLIC_FLOWER.get()))))));
    }

    public static void bootstrapPlacements(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> features = context.lookup(Registries.CONFIGURED_FEATURE);
        context.register(PLACED_GARLIC_FLOWER_KEY, new PlacedFeature(features.getOrThrow(GARLIC_FLOWER_KEY),
                List.of(InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome())));
    }

    public static void bootstrapBiomeModifiers(BootstapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        context.register(ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(JiroDelight.MODID, "add_garlic_flower")),
                new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                        context.lookup(Registries.BIOME).getOrThrow(BiomeTags.IS_SAVANNA),
                        HolderSet.direct(placedFeatures.getOrThrow(PLACED_GARLIC_FLOWER_KEY)),
                        GenerationStep.Decoration.VEGETAL_DECORATION));
    }
}