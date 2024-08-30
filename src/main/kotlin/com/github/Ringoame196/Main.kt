package com.github.Ringoame196

import com.github.Ringoame196.commands.Command
import com.github.Ringoame196.commands.TabCompleter
import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.JDABuilder
import net.dv8tion.jda.api.entities.Activity
import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {
    override fun onEnable() {
        super.onEnable()
        saveDefaultConfig()
        val plugin = this
        var jda: JDA? = null
        val token = config.getString("token")
        if (token != null) {
            // JDAの初期化例
            jda = JDABuilder.createDefault(token)
                .setActivity(Activity.watching("りんご飴"))
                .build()
            jda.awaitReady() // 完全に準備ができるまで待つ
        }

        val command = getCommand("testd")
        command!!.setExecutor(Command(plugin, jda))
        command.tabCompleter = TabCompleter()
    }
}
