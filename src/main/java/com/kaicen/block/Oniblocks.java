package com.kaicen.block;

import com.kaicen.block_entity.block_with_entity.Charging_pile_block;
import com.kaicen.gas.block.Oxygen;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class Oniblocks {
    //方块的静态字段

    //实体方块的静态字段
    public static final Block CHARGING_FILE = new Charging_pile_block(FabricBlockSettings.create().strength(1.0F));
    public static final Block OXYGEN = new Oxygen(FabricBlockSettings.create().strength(1.0F));

    public static void block_register(){
            block_rj("charging_file",CHARGING_FILE);
            block_rj("oxygen",OXYGEN);
    }
    public static void block_rj(String name, Block block){
        Registry.register(Registries.BLOCK,new Identifier("oxygen_not_include",name),block);
    }
}
