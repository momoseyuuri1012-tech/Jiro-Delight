package com.jiro.jirodelight.datagen;

import com.jiro.jirodelight.JiroDelight;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Collections;
import java.util.List;

@Mod.EventBusSubscriber(modid = JiroDelight.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        // 既存のモデル生成の登録
        generator.addProvider(event.includeClient(),
                new ModItemModelProvider(packOutput, existingFileHelper));

        // 今回追加したワールド生成設定の自動登録
        generator.addProvider(event.includeServer(),
                new ModWorldGenProvider(packOutput, event.getLookupProvider()));

        generator.addProvider(event.includeClient(),
                new ModBlockStateProvider(packOutput, existingFileHelper));


    }
}
