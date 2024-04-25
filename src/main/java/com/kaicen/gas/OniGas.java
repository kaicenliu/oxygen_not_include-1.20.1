package com.kaicen.gas;

import com.kaicen.block.Oniblocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class OniGas {
    //储存静态的气体字段
    public static final BlockEntityType<Oxygen_Entity> OXYGEN = FabricBlockEntityTypeBuilder.create(Oxygen_Entity::new, Oniblocks.OXYGEN).build();



    public static void gas_register(){
        gas_rj("oxygen",OXYGEN);
    }
    public static void gas_rj(String name,BlockEntityType<?> type){
        Registry.register(Registries.BLOCK_ENTITY_TYPE,new Identifier("oxygen_not_include",name),type);
    }
}
