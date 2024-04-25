package com.kaicen.block_entity;

import com.kaicen.implement.ImplementedInventory;
import com.kaicen.item.Battery;
import com.kaicen.screenhandler.OniScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class Charging_pile_entity extends BlockEntity implements ImplementedInventory, NamedScreenHandlerFactory {
    static int TIME = 0;
    static DefaultedList<ItemStack> inventory = DefaultedList.ofSize(2,ItemStack.EMPTY);

    public Charging_pile_entity(BlockPos pos, BlockState state) {
        super(Onientity.CHARGING_PILE_ENTITY, pos, state);
    }

    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return super.toUpdatePacket();
    }

    @Override
    public NbtCompound toInitialChunkDataNbt() {
        return super.toInitialChunkDataNbt();
    }

    public static void tick(World world, BlockPos blockPos, BlockState blockState, Charging_pile_entity chargingPileEntity) {
        if (!world.isClient){
            TIME++;
            if(TIME>=20) {
                if (inventory.get(0).getItem() instanceof Battery) {
                    inventory.get(0).setDamage(inventory.get(0).getDamage() - 1);//恢复耐久
                }
                TIME = 0;
            }
        }
    }
    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public Text getDisplayName() {
        return Text.literal("charging_pile");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new OniScreenHandler(syncId,playerInventory,this);
    }
    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
    }
}
