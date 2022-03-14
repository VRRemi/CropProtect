package dev.vrremi.cropprotect;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityInteractEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void interact(PlayerInteractEvent e){
        if(e.getAction() != Action.PHYSICAL) return;
        if(e.getClickedBlock() == null || e.getClickedBlock().getType() != Material.FARMLAND) return;
        e.setCancelled(true);
    }

    @EventHandler
    public void entityInteract(EntityInteractEvent e){
        if(e.getBlock().getType() != Material.FARMLAND) return;
        e.setCancelled(true);
    }
}
