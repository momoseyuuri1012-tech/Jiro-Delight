package com.jiro.jirodelight.init;

import com.jiro.jirodelight.JiroDelight;
import com.jiro.jirodelight.block.GarlicCropBlock;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, JiroDelight.MODID);

    // ここに今後ブロックを登録していきます
    // 例: public static final RegistryObject<Block> EXAMPLE_BLOCK = BLOCKS.register("example_block", () -> new Block(BlockBehaviour.Properties.of()));
    public static final RegistryObject<Block> GARLIC_FLOWER = BLOCKS.register("garlic_flower",
            () -> new FlowerBlock(MobEffects.BLINDNESS, 0, BlockBehaviour.Properties.copy(Blocks.OXEYE_DAISY).noCollission().instabreak()));

    public static final RegistryObject<Block> GARLIC_CROP = BLOCKS.register("garlic_crop",
            () -> new GarlicCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noCollission().randomTicks().instabreak().sound(SoundType.CROP)));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}