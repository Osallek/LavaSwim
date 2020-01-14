package com.osallek;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class LavaSwimListener implements Listener {

    @EventHandler(priority = EventPriority.LOWEST, ignoreCancelled = true)
    void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        if (player.getLocation().getBlock().getType() == Material.LAVA) {
            if (player.isSprinting()) {
                player.setGliding(true);
                player.setVelocity(player.getLocation().getDirection().multiply(0.32)); //0.32 is limit value before gliding animation bug in a small amount of lava
            }
        }
    }
}
