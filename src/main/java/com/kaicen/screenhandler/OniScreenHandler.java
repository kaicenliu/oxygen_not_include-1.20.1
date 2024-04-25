package com.kaicen.screenhandler;

import com.kaicen.Oxygen_not_include;
import com.kaicen.item.Oxygen_mask;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;

public class OniScreenHandler extends ScreenHandler {
    private final Inventory inventory;
    public OniScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, new SimpleInventory(2));
    }

    public OniScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory) {
        super(Oxygen_not_include.CHARGING_FILE, syncId);
        checkSize(inventory, 2);
        this.inventory = inventory;
        inventory.onOpen(playerInventory.player);
        this.addSlot(new Slot(inventory,1,98,17){
                @Override
                public boolean canInsert(ItemStack stack) {
                    return stack.getItem() instanceof Oxygen_mask;}
        });
        this.addSlot(new Slot(inventory,0,56,17){
            @Override
            public boolean canInsert(ItemStack stack) {
                return super.canInsert(stack);
            }
        });
        addplayerslot(playerInventory,this);
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int slot) {
        return new ItemStack(Items.AIR);
    }
    private void addplayerslot(PlayerInventory playerInventory,OniScreenHandler oniScreenHandler){
        for (int m = 0; m < 3; ++m) {// 玩家物品栏
            for (int l = 0; l < 9; ++l) {
                oniScreenHandler.addSlot(new Slot(playerInventory, l + m * 9 + 9, 8 + l * 18, 84 + m * 18));
            }
        }
        for (int m = 0; m < 9; ++m) { // 玩家快捷栏
            oniScreenHandler.addSlot(new Slot(playerInventory, m, 8 + m * 18, 142));
        }
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }
}
