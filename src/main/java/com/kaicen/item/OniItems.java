package com.kaicen.item;

import com.kaicen.block.Oniblocks;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class OniItems {
    //物品静态字段      //注意设置物品耐久
    public static final Item OXYGEN_MASK = new Oxygen_mask(new FabricItemSettings().maxDamage(600));
    public static final Item CHECK_DAMAGE = new CheckDamage(new FabricItemSettings());
    public static final Item BATTERY = new Battery(new FabricItemSettings().maxDamage(600));
    public static final Item TEXT_ITEM = new TestItem(new FabricItemSettings());
    //方块静态字段

    //实体方块静态字段
    public static final Item CHARGING_FILE = new BlockItem(Oniblocks.CHARGING_FILE,new FabricItemSettings());
    public static final Item OXYGEN = new BlockItem(Oniblocks.OXYGEN,new FabricItemSettings());
    public static void item_register(){
        item_rj("oxygen_mask",OXYGEN_MASK);
        item_rj("check_damage",CHECK_DAMAGE);
        item_rj("charging_file",CHARGING_FILE);
        item_rj("battery",BATTERY);
        item_rj("oxygen",OXYGEN);
        item_rj("test_item",TEXT_ITEM);
        //注册物品组
        Registry.register(Registries.ITEM_GROUP,new Identifier("oxygen_not_include","group"),OXYGEN_NOT_INCLUDE);
    }
    public static void item_rj(String name, Item item){
        Registry.register(Registries.ITEM,new Identifier("oxygen_not_include",name),item);
    }

    public static final ItemGroup OXYGEN_NOT_INCLUDE = FabricItemGroup.builder().icon(()->new ItemStack(BATTERY))
            .entries(((displayContext, entries) ->{
                entries.add(OXYGEN_MASK);
                entries.add(CHECK_DAMAGE);
                entries.add(CHARGING_FILE);
                entries.add(BATTERY);
                entries.add(OXYGEN);
                entries.add(TEXT_ITEM);

            } )).displayName(Text.translatable("itemGroup.oxygen_not_include.group")).build();
}
