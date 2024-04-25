package com.kaicen.item;

import net.minecraft.item.Item;

public class Battery extends Item {
    private int voltage = 3;//代表电池类的电压,默认为3
    public Battery(Settings settings,int voltage) {
        super(settings);
        this.voltage = voltage;
    }
    public Battery(Settings settings) {
        super(settings);
    }
    public int getVoltage(){
        return voltage;
    }
}
