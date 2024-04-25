package com.kaicen.item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class CheckDamage extends Item {
    public CheckDamage(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        int durable = user.getOffHandStack().getMaxDamage()-user.getOffHandStack().getDamage();
        user.sendMessage(Text.literal("您副手的物品耐久剩余"+durable ));
        return super.use(world, user, hand);
    }
}
