package com.osallek;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityToggleGlideEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class LavaSwimListener implements Listener {

    @EventHandler(priority = EventPriority.LOWEST, ignoreCancelled = true)
    void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        if (player.getLocation().getBlock().getType() == Material.LAVA) {
            if (player.isSprinting()) {
                if (player.getEyeLocation().getBlock().getType() == Material.LAVA || player.isGliding()) {
                    player.setGliding(true);
                    player.setVelocity(player.getLocation().getDirection().multiply(0.25)); //Slow down the player to be more realistic, this is approximately the same speed as underwater swimming
                }
            }
        }
    }

    /*
        This event is here to make sure the animation doesn't get canceled
     */
    @EventHandler(priority = EventPriority.HIGH)
    void onPlayerMove(EntityToggleGlideEvent event){
        Player player = (Player) event.getEntity();
        if (player.getLocation().getBlock().getType() == Material.LAVA) {
            if (player.isSprinting()) {
                if (player.getEyeLocation().getBlock().getType() == Material.LAVA || player.isGliding()) {
                    event.setCancelled(true);
                }
            }
        }
    }
}
