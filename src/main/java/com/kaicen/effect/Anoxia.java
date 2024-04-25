package com.kaicen.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.damage.DamageSources;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;

public class Anoxia extends StatusEffect {//缺氧效果
    static int TIME = 0;
    public Anoxia() {
        super(StatusEffectCategory.HARMFUL, 0);
    }

    @Override
    public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        if(entity instanceof PlayerEntity player&&amplifier==2){
            player.sendMessage(Text.literal("您已进入缺氧环境"),true);
        }
        super.onApplied(entity, attributes, amplifier);
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {//实现缺氧逻辑
        if(!entity.getWorld().isClient){
            TIME++;
            if (TIME >= 2&&entity instanceof PlayerEntity player) {
                player.setAir(player.getAir()-6-amplifier*3);//一级存活10分钟，二级存活150秒
                if(oxygen_not_include(player)){kill(player);}
                TIME = 0;
            }
        }
        super.applyUpdateEffect(entity, amplifier);
    }
    private boolean oxygen_not_include(PlayerEntity player){
        return player.getAir()<-20;
    }
    private void kill(PlayerEntity player){
        player.setHealth(0);//当含氧量小于-20时，kill玩家
        player.removeStatusEffect(Onieffect.ANOXIA);//移除效果，防止玩家一直死亡
    }
    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
