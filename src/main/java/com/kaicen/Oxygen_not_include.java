package com.kaicen;

import com.kaicen.block.Oniblocks;
import com.kaicen.effect.Onieffect;
import com.kaicen.enchant.OniEnchant;
import com.kaicen.block_entity.Onientity;
import com.kaicen.gas.OniGas;
import com.kaicen.item.OniItems;
import com.kaicen.screenhandler.OniScreenHandler;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Oxygen_not_include implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger("oxygen_not_include");
	//存储屏幕的静态字段
	public static final ScreenHandlerType<OniScreenHandler> CHARGING_FILE;
	static {
		CHARGING_FILE = ScreenHandlerRegistry.registerSimple(new Identifier("oxygen_not_include","charging_file"), OniScreenHandler::new);
	}
	
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		//注册表的调用
		OniItems.item_register();//注册物品
		Oniblocks.block_register();//注册方块
		Onieffect.effect_register();//注册药水效果
		OniEnchant.enchant_register();//注册附魔
		Onientity.entity_register();//注册方块实体
		//OxygenEffect.effect();//注册缺氧事件监听器
		OniGas.gas_register();//注册气体
		LOGGER.info("Hello Fabric world!");
	}
}