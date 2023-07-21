package com.iruanp.floodgateskipauthme;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.Random;

public class PlayerListener implements Listener {
    private static String getCharAndNumr(int length) {
        Random random = new Random ();
        StringBuffer valSb = new StringBuffer ();
        String charStr = "0123456789abcdefghijklmnopqrstuvwxyz" ;
        int charLength = charStr.length ();
        for ( int i = 0 ; i < length; i++) {
            int index = random.nextInt (charLength);
            valSb.append (charStr.charAt (index));
        }
        return valSb.toString ();
    }
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        if(FloodgateSkipAuthme.floodgateApi.isFloodgatePlayer(event.getPlayer().getUniqueId())){
            if(!FloodgateSkipAuthme.authmeApi.isRegistered(event.getPlayer().getName())){
                FloodgateSkipAuthme.authmeApi.registerPlayer(event.getPlayer().getName(), getCharAndNumr(16));
            }
            FloodgateSkipAuthme.authmeApi.forceLogin(event.getPlayer());
        }
    }
}