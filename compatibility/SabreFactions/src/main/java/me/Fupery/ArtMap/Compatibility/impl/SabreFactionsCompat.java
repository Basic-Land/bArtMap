package me.Fupery.ArtMap.Compatibility.impl;

import com.massivecraft.factions.*;
import me.Fupery.ArtMap.api.Compatability.RegionHandler;
import me.Fupery.ArtMap.api.Easel.ClickType;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

/**
 * Support for Sabre Factions.
 * <p>
 * Looks to be a fork of an old version of MassiveCraft Fractions.
 * Does not appear to have player permissions or at least the wiki is too sparse to see them.
 */
public class SabreFactionsCompat implements RegionHandler {
    private boolean loaded = false;

    public SabreFactionsCompat() {
        Factions.getInstance();
        loaded = true;
    }

    @Override
    public boolean checkBuildAllowed(Player player, Location location) {
        FLocation loc = new FLocation(location);
        FPlayer fPlayer = FPlayers.getInstance().getByPlayer(player);
        Faction hostFaction = Board.getInstance().getFactionAt(loc);
        return hostFaction == null || hostFaction.getFPlayers().contains(fPlayer);
    }

    @Override
    public boolean checkInteractAllowed(Player player, Entity entity, ClickType click) {
        FLocation loc = new FLocation(entity.getLocation());
        FPlayer fPlayer = FPlayers.getInstance().getByPlayer(player);
        Faction hostFaction = Board.getInstance().getFactionAt(loc);
        return hostFaction == null || hostFaction.getFPlayers().contains(fPlayer);
    }

    @Override
    public boolean isLoaded() {
        return loaded;
    }
}
