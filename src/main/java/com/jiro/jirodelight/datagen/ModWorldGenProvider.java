package com.jiro.jirodelight.datagen;

import com.jiro.jirodelight.JiroDelight;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class ModWorldGenProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, Bootstrap::bootstrapFeatures)
            .add(Registries.PLACED_FEATURE, Bootstrap::bootstrapPlacements)
            .add(ForgeRegistries.Keys.BIOME_MODIFIERS, Bootstrap::bootstrapBiomeModifiers);

    public ModWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(JiroDelight.MODID));
    }
}