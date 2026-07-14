package com.jiro.jirodelight.datagen;

import com.jiro.jirodelight.block.GarlicCropBlock;
import com.jiro.jirodelight.init.BlockInit;
import com.jiro.jirodelight.init.ItemInit;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    public ModBlockLootTableProvider() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        GarlicCropBlock cropBlock = (GarlicCropBlock) BlockInit.GARLIC_CROP.get();

        // 収穫時のドロップ条件：年齢が7（最大）の時のみ
        this.add(cropBlock, createCropDrops(
                cropBlock,
                ItemInit.GARLIC.get(),
                ItemInit.GARLIC.get(),
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(cropBlock)
                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(cropBlock.getAgeProperty(), 7))
        ));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BlockInit.BLOCKS.getEntries().stream().map(registryObject -> registryObject.get())::iterator;
    }
}
