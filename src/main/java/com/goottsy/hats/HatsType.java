package com.goottsy.hats;

import org.bukkit.Material;

public class HatsType {
    private String id;
    private String name;
    private Material material;
    private int cmd;

    public HatsType(String id, String name, Material material, int cmd) {
        this.id = id;
        this.name = name;
        this.material = material;
        this.cmd = cmd;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Material getMaterial() {
        return material;
    }

    public int getCmd() {
        return cmd;
    }
}
