package com.jiro.jirodelight.item;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.BowlFoodItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class JiroRamenItem extends BowlFoodItem {
    public JiroRamenItem(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        // プレイヤーが食べた場合のみ実績判定を行う
        if (entity instanceof ServerPlayer player) {
            // ここで独自の進捗トリガーを呼び出すことも可能ですが、
            // 今回はシンプルに既存の消費トリガーでJSONと紐付けます
            CriteriaTriggers.CONSUME_ITEM.trigger(player, stack);
        }
        return super.finishUsingItem(stack, level, entity);
    }
}
