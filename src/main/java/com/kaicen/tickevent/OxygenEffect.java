package com.kaicen.tickevent;

import com.kaicen.effect.Onieffect;
import com.kaicen.item.Oxygen_mask;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.dimension.DimensionTypes;

import java.util.List;

public class OxygenEffect {
    static int TIME = 0;
    public static void effect(){//每五秒执行一次检查
        ServerTickEvents.END_SERVER_TICK.register((server -> {
        TIME++;
        if(TIME>=100){
            //System.out.println("正在进行检查");
            List<ServerPlayerEntity> playerEntityList = server.getPlayerManager().getPlayerList();
            for(PlayerEntity player:playerEntityList){
               give_effect(player,should_give_effect(player));
            }
            TIME = 0;//清除计时器
        }
        }));
    }
    public static int should_give_effect(PlayerEntity player){//检测是否应该给予玩家效果
        boolean hasoxygen = player.getEquippedStack(EquipmentSlot.HEAD).getItem() instanceof Oxygen_mask;//检测是否存在面罩
        if(hasoxygen){
            return 0;
        } else if (player.getY()<-16||player.getWorld().getDimensionKey() == DimensionTypes.THE_END) {//检测坐标与维度
            return 2;
        }else{
            return 1;
        }
    }

    public static void  give_effect(PlayerEntity player,int amplifier){
        if(amplifier == 0){return;}
        player.addStatusEffect(new StatusEffectInstance(Onieffect.ANOXIA,250,amplifier));
    }

}
