package com.kaicen.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class TestItem extends Item {//该类用来测试功能
    public TestItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(hand==Hand.MAIN_HAND){
            ItemStack itemStack = user.getMainHandStack();
            user.getInventory().removeOne(itemStack);
        }
        return super.use(world, user, hand);
    }
}
