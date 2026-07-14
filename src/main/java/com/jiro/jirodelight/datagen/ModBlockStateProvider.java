package com.jiro.jirodelight.datagen;

import com.jiro.jirodelight.JiroDelight;
import com.jiro.jirodelight.init.BlockInit;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.CropBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, JiroDelight.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        getVariantBuilder(BlockInit.GARLIC_CROP.get()).forAllStates(state -> {
            int age = state.getValue(CropBlock.AGE);
            return ConfiguredModel.builder()
                    // .renderType("cutout") を追加するのが重要です！
                    .modelFile(models().cross("garlic_stage" + age, modLoc("block/garlic_stage" + age))
                            .renderType("cutout"))
                    .build();
        });
    }}


