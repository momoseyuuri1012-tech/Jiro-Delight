package com.jiro.jirodelight.init;

import com.jiro.jirodelight.JiroDelight;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, JiroDelight.MODID);

    public static final RegistryObject<CreativeModeTab> JIRO_TAB = CREATIVE_MODE_TABS.register("jiro_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.jiro_tab"))
                    // ★アイコンを「マシマシ」に変更しました
                    .icon(() -> new ItemStack(ItemInit.GARLIC.get()))
                    .displayItems((parameters, output) -> {
                        // ここにタブに入れたいアイテムを順番に並べる
                        output.accept(ItemInit.GARLIC.get());
                        output.accept(ItemInit.MINCED_GARLIC.get());
                        output.accept(ItemInit.BACK_FAT.get());
                        output.accept(ItemInit.NOODLE_DOUGH.get());
                        output.accept(ItemInit.EXTRA_THICK_NOODLES.get());
                        output.accept(ItemInit.BEAN_SPROUTS.get());
                        output.accept(ItemInit.VEGETABLES.get());
                        output.accept(ItemInit.JIRO_RAMEN.get());
                        output.accept(ItemInit.JIRO_RAMEN_MASHI.get());
                        output.accept(ItemInit.JIRO_RAMEN_MASHIMASHI.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}