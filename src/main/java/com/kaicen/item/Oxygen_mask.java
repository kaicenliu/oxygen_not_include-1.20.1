package com.kaicen.item;

import com.kaicen.gas.block.Oxygen;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Equipment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class Oxygen_mask extends Item implements Equipment {
    int TIME = 0;

    public Oxygen_mask(Settings settings) {
        super(settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        //当氧气面罩位于头部时，每秒减少一点耐久
        if (!world.isClient){
            TIME++;
            if(TIME>=20){
                if(entity instanceof PlayerEntity player&&player.getEquippedStack(EquipmentSlot.HEAD).getItem() instanceof Oxygen_mask) {
                    ItemStack itemStack = player.getEquippedStack(EquipmentSlot.HEAD);
                    int damage = itemStack.getDamage();
                    if(damage+1 < itemStack.getMaxDamage()){//当损耗+1小于最大损耗时减少一点耐久
                        itemStack.setDamage(damage+1);
                    }
                    else {//其他情况直接移除物品
                        player.getInventory().removeOne(itemStack);
                    }
                    //player.getEquippedStack(EquipmentSlot.HEAD).setDamage(player.getEquippedStack(EquipmentSlot.HEAD).getDamage() + 1);
                }
                TIME=0;
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    @Override
    public EquipmentSlot getSlotType() {
        return EquipmentSlot.HEAD;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if(hand == Hand.OFF_HAND){
            return super.use(world, user, hand);
        }
        return this.equipAndSwap(this,world,user,hand);
    }

    @Override
    public boolean isDamageable() {
        return true;
    }
}
