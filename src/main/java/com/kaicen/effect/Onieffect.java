package com.kaicen.effect;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class Onieffect {
    //药水效果的静态字段
    public static final StatusEffect ANOXIA = new Anoxia();

    public static void effect_register(){
            effect_rj("anoxia",ANOXIA);
    }
    public static void effect_rj(String name, StatusEffect effect){
        Registry.register(Registries.STATUS_EFFECT,new Identifier("oxygen_not_include",name),effect);
    }
}
