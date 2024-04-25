package com.kaicen.block_entity;

import com.kaicen.block.Oniblocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class Onientity {
    //方块实体的静态字段
    public static final BlockEntityType<Charging_pile_entity> CHARGING_PILE_ENTITY = FabricBlockEntityTypeBuilder.create(Charging_pile_entity::new, Oniblocks.CHARGING_FILE).build();


    public static void entity_register(){
        entity_rj("charging_file_entity",CHARGING_PILE_ENTITY);
    }
    public static void entity_rj(String name,BlockEntityType<?> entry){
        Registry.register(Registries.BLOCK_ENTITY_TYPE,new Identifier("oxygen_not_include",name),entry);
    }

}
