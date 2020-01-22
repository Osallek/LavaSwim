package com.osallek;

import org.bukkit.plugin.java.JavaPlugin;

public class LavaSwim extends JavaPlugin {

    public static LavaSwim LAVA_SWIM;

    @Override
    public void onEnable() {
        LAVA_SWIM = this;

        getServer().getPluginManager().registerEvents(new LavaSwimListener(), this);
    }
}
