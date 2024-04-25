package com.kaicen.enchant;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.sound.SoundInstance;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;

public class Sound extends Enchantment {
    public Sound() {
        super(Rarity.COMMON,EnchantmentTarget.WEAPON,new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    }
    @Override
    public int getMinPower(int level) {//附魔的最低等级,并与附魔等级有关
        return 1;
    }
    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if(target instanceof ClientPlayerEntity player){
            player.playSound(SoundEvents.ENTITY_PLAYER_HURT_ON_FIRE,0.5F,0.5F );
        }
        super.onTargetDamaged(user, target, level);
    }
}
