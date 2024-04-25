package com.kaicen.enchant;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class OniEnchant {
    //附魔效果的静态字段
    public static final Enchantment SOUND = new Sound();

    public static void enchant_register(){
            enchant_rj("sound",SOUND);
    }
    public static void enchant_rj(String name, Enchantment enchant){
        Registry.register(Registries.ENCHANTMENT,new Identifier("oxygen_not_include",name),enchant);
    }
}
