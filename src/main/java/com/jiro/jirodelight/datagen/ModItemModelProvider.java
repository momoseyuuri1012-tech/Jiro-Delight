package com.jiro.jirodelight.datagen;

import com.jiro.jirodelight.JiroDelight;
import com.jiro.jirodelight.init.ItemInit;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, JiroDelight.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        // ここにアイテムを登録していくと、自動でJSONが生成されます
        simpleItem(ItemInit.GARLIC.get());
        simpleItem(ItemInit.MINCED_GARLIC.get());
        simpleItem(ItemInit.BACK_FAT.get());
        simpleItem(ItemInit.NOODLE_DOUGH.get());
        simpleItem(ItemInit.EXTRA_THICK_NOODLES.get());
        simpleItem(ItemInit.BEAN_SPROUTS.get());
        simpleItem(ItemInit.VEGETABLES.get());
        simpleItem(ItemInit.JIRO_RAMEN.get());
        simpleItem(ItemInit.JIRO_RAMEN_MASHI.get());
        simpleItem(ItemInit.JIRO_RAMEN_MASHIMASHI.get());
    }

    private void simpleItem(net.minecraft.world.item.Item item) {
        String path = net.minecraftforge.registries.ForgeRegistries.ITEMS.getKey(item).getPath();
        withExistingParent(path, "item/generated").texture("layer0", "item/" + path);
    }
}