package com.kaicen.gas.block;

import com.kaicen.gas.OniGas;
import com.kaicen.gas.Oxygen_Entity;
import com.kaicen.item.Oxygen_mask;
import com.kaicen.item.TestItem;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class Oxygen extends BlockWithEntity {
    public Oxygen(Settings settings) {
        super(settings);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new Oxygen_Entity(pos,state);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VoxelShapes.empty();
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return VoxelShapes.empty();
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if(entity instanceof PlayerEntity player && player.getEquippedStack(EquipmentSlot.HEAD).getItem() instanceof Oxygen_mask){
            ItemStack itemStack = player.getEquippedStack(EquipmentSlot.HEAD);
            int damage = itemStack.getDamage();
            if(damage<60){//没有损耗或损耗小时不消耗氧气
                return;
            } else if (damage<100) {//当损耗小于100时直接恢复满耐久
                itemStack.setDamage(0);
                world.removeBlock(pos,true);
            }
            else {//损耗大于100时增加100的耐久
                itemStack.setDamage(damage-100);
                world.removeBlock(pos,true);
            }
        } else if (entity instanceof PlayerEntity player && player.getMainHandStack().getItem() instanceof TestItem) {
            world.removeBlock(pos,true);
        }
        super.onEntityCollision(state, world, pos, entity);
    }

    @Override
    public void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        super.onStateReplaced(state, world, pos, newState, moved);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, OniGas.OXYGEN,Oxygen_Entity::tick);
    }

}
