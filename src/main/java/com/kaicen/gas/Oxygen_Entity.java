package com.kaicen.gas;


import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Oxygen_Entity extends BlockEntity {
    private int TIME = 0;

    public void resettime() {
        TIME = 0;
    }
    public void timeadd(){
        TIME++;
    }
    public int gettime(){
        return TIME;
    }

    public Oxygen_Entity(BlockPos pos, BlockState state) {
        super(OniGas.OXYGEN, pos, state);
    }

    public static void tick(World world, BlockPos blockPos, BlockState blockState, Oxygen_Entity oxygenEntity) {
            oxygenEntity.timeadd();
            if(oxygenEntity.gettime()==100){
               boolean move = move(world,blockPos,blockState,'d');
               if(!move){
                    move(world,blockPos.down(),blockState,canmove(world,blockPos.down()));
               }
                oxygenEntity.resettime();
            }
    }

    private static char canmove(World world, BlockPos blockPos) {//传入blockpos的参数时，记得使用down方法，因为检查的是其下方的方块
        if(world.getBlockState(blockPos.east()).isAir()){
            return 'e';
        } else if (world.getBlockState(blockPos.south()).isAir()) {
            return 's';
        } else if (world.getBlockState(blockPos.west()).isAir()) {
            return 'w';
        } else if (world.getBlockState(blockPos.north()).isAir()) {
            return 'n';
        }
        return 'f';
    }

    private static void randommove(World world, BlockPos blockPos, BlockState blockState,Oxygen_Entity oxygenEntity) {
        if(!world.isClient){

        }
    }
    private static boolean move(World world, BlockPos blockPos, BlockState blockState,char direction){
        if(!world.isClient){
            switch(direction){
                case 'e':if(world.getBlockState(blockPos.east()).isAir()){move(world,blockPos,blockState,1,0,0);
                    return true;}return false;//东
                case 's':if(world.getBlockState(blockPos.south()).isAir()){move(world,blockPos,blockState,0,0,-1);
                    return true;}return false;//南
                case 'w':if(world.getBlockState(blockPos.west()).isAir()){move(world,blockPos,blockState,-1,0,0);
                    return true;}return false;//西
                case 'n':if(world.getBlockState(blockPos.north()).isAir()){move(world,blockPos,blockState,0,0,1);
                    return true;}return false;//北
                case 'u':if(world.getBlockState(blockPos.up()).isAir()){move(world,blockPos,blockState,0,1,0);
                    return true;}return false;//上
                case 'd':if(world.getBlockState(blockPos.down()).isAir()){move(world,blockPos,blockState,0,-1,0);
                    return true;}return false;//下
                default:return false;
            }
        }
        return false;
    }
    public static void move(World world,BlockPos blockPos, BlockState blockState,int i,int j,int k){
        if(!world.isClient){
            world.setBlockState(blockPos.add(i,j,k),blockState);//新增方块
            world.removeBlock(blockPos,true);//去除原有方块
        }
    }

}
