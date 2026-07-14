package com.jiro.jirodelight.init;

import com.jiro.jirodelight.JiroDelight;
import com.jiro.jirodelight.item.JiroRamenItem;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.BowlFoodItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, JiroDelight.MODID);

    // 共通の食べ物設定（ニンジンと同じ）
    private static final FoodProperties VEGETABLE_FOOD = new FoodProperties.Builder()
            .nutrition(3)
            .saturationMod(0.6f)
            .build();

    // 1. ニンニク
    public static final RegistryObject<Item> GARLIC = ITEMS.register("garlic",
            () -> new ItemNameBlockItem(BlockInit.GARLIC_CROP.get(),
                    new Item.Properties().food(VEGETABLE_FOOD)));

    // 2. 刻んだニンニク (食べられない)
    public static final RegistryObject<Item> MINCED_GARLIC = ITEMS.register("minced_garlic",
            () -> new Item(new Item.Properties()));

    // 3. 背脂
    public static final RegistryObject<Item> BACK_FAT = ITEMS.register("back_fat",
            () -> new Item(new Item.Properties()));

    // 4. 麺生地
    public static final RegistryObject<Item> NOODLE_DOUGH = ITEMS.register("noodle_dough",
            () -> new Item(new Item.Properties()));

    // 5. 極太麺
    public static final RegistryObject<Item> EXTRA_THICK_NOODLES = ITEMS.register("extra_thick_noodles",
            () -> new Item(new Item.Properties()));

    // 6. もやし
    public static final RegistryObject<Item> BEAN_SPROUTS = ITEMS.register("bean_sprouts",
            () -> new Item(new Item.Properties().food(VEGETABLE_FOOD)));

    // 7. ヤサイ
    public static final RegistryObject<Item> VEGETABLES = ITEMS.register("vegetables",
            () -> new Item(new Item.Properties().food(VEGETABLE_FOOD)));

    // 8. 二郎ラーメン
    public static final RegistryObject<Item> JIRO_RAMEN = ITEMS.register("jiro_ramen",
            () -> new BowlFoodItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                    .nutrition(14)
                    .saturationMod(1.2f)
                    .alwaysEat()
                    .build())));

    // 9. 二郎ラーメンマシ
    public static final RegistryObject<Item> JIRO_RAMEN_MASHI = ITEMS.register("jiro_ramen_mashi",
            () -> new BowlFoodItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                    .nutrition(20)
                    .saturationMod(1.6f)
                    .alwaysEat()
                    .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 100, 0), 1.0f)
                    .build())));

    // 10. 二郎ラーメンマシマシ
    public static final RegistryObject<Item> JIRO_RAMEN_MASHIMASHI = ITEMS.register("jiro_ramen_mashimashi",
            () -> new JiroRamenItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                    .nutrition(20)
                    .saturationMod(2.0f)
                    .alwaysEat()
                    .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 200, 0), 1.0f)
                    .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1200, 1), 1.0f)
                    .build())));

    public static final RegistryObject<Item> GARLIC_FLOWER = ITEMS.register("garlic_flower",
            () -> new BlockItem(BlockInit.GARLIC_FLOWER.get(), new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}