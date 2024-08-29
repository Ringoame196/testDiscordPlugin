package com.github.Ringoame196

import net.dv8tion.jda.api.JDABuilder
import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {
    override fun onEnable() {
        super.onEnable()
        saveDefaultConfig()
        val token = config.getString("token")
        if (token != null) {
            val jdaBuilder = JDABuilder.createDefault(token)
        }
    }
}
