package ml.rhodes.bots.discord.tankbot.commands

import de.btobastian.sdcf4j.Command
import de.btobastian.sdcf4j.CommandExecutor
import ml.rhodes.bots.discord.tankbot.Main.client

class Info : CommandExecutor {

    /**
     * Info command shows bot information
     * @return String
     */
    @Command(aliases = arrayOf("!info", "!i"), description = "Show bot info")
    fun onInfoCommand(): String {
        val builder = StringBuilder()
        builder.append("__**Info:**__\n")
        builder.append("    **Author:** ${client!!.applicationOwner.name} | https://github.com/tankerkiller125\n")
        builder.append("    **Built on:**\n")
        builder.append("        Kotlin: !kotlin\n")
        builder.append("        Discord4J: !discord4j\n")
        builder.append("        sdcf4j: !sdcf4j")
        return builder.toString()
    }

    /**
     * Shows Kotlin Link
     * @return String
     */
    @Command(aliases = arrayOf("!kotlin"), showInHelpPage = false)
    fun onKotlinCommand(): String {
        return "https://kotlinlang.org"
    }

    /**
     * Shows Discord4J Link
     * @return String
     */
    @Command(aliases = arrayOf("!discord4j"), showInHelpPage = false)
    fun onDiscord4JCommand(): String {
        return "https://github.com/austinv11/Discord4J"
    }

    /**
     * Shows sdcf4j Link
     * @return String
     */
    @Command(aliases = arrayOf("!sdcf4j"), showInHelpPage = false)
    fun onSdc4jCommand(): String {
        return "https://github.com/BtoBastian/sdcf4j"
    }
}