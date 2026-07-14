package com.jiro.jirodelight.block;

import com.jiro.jirodelight.init.ItemInit;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.storage.loot.LootParams;
import java.util.List;
import net.minecraft.world.item.ItemStack;

public class GarlicCropBlock extends CropBlock {
    public static final IntegerProperty AGE = BlockStateProperties.AGE_7;

    public GarlicCropBlock(Properties properties) {
        super(properties);
    }

    @Override
    public IntegerProperty getAgeProperty() {
        return AGE;
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ItemInit.GARLIC.get();
    }

    // ★ここを追加：ドロップを強制的に指定する
    @Override
    public List<ItemStack> getDrops(BlockState state, LootParams.Builder builder) {
        if (state.getValue(AGE) >= 7) {
            // 成長しきったらニンニクを2〜3個落とす
            return List.of(new ItemStack(ItemInit.GARLIC.get(), 2 + builder.getLevel().random.nextInt(2)));
        } else {
            // 未熟な時はニンニクを1個だけ落とす（あるいは何も落とさないなら空にする）
            return List.of(new ItemStack(ItemInit.GARLIC.get()));
        }
    }
}