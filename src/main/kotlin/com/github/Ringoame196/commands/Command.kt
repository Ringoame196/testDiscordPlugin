package com.github.Ringoame196.commands

import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.entities.TextChannel
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.plugin.Plugin

class Command(private val plugin: Plugin, private val jda: JDA?) : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (args.isNotEmpty()) {
            if (jda == null) {
                sender.sendMessage("JDAがnullだよ")
                return true
            }
            val message = args[0]
            val channelId = "1098980747005669406"
            val textChannel: TextChannel? = jda.getTextChannelById(channelId)
            if (textChannel == null) {
                sender.sendMessage("channel発見できなかったよ")
                return true
            }
            textChannel.sendMessage(message).queue()
            sender.sendMessage("送信しました")
            return true
        } else {
            return false
        }
    }
}
