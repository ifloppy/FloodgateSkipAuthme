package com.iruanp.floodgateskipauthme;

import org.bukkit.plugin.java.JavaPlugin;
import fr.xephi.authme.api.v3.AuthMeApi;
import org.geysermc.floodgate.api.FloodgateApi;

public final class FloodgateSkipAuthme extends JavaPlugin {
    public static AuthMeApi authmeApi;
    public static FloodgateApi floodgateApi;
    @Override
    public void onEnable() {
        // Plugin startup logic
        authmeApi = AuthMeApi.getInstance();
        floodgateApi = FloodgateApi.getInstance();
        getServer().getPluginManager().registerEvents(new PlayerListener(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

    }
}
