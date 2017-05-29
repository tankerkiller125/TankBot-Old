package ml.rhodes.bots.discord.tankbot.commands.admin

import de.btobastian.sdcf4j.Command
import de.btobastian.sdcf4j.CommandExecutor
import ml.rhodes.bots.discord.tankbot.Main

class ChangeGame : CommandExecutor {

    @Command(aliases = arrayOf("!changegame", "!chggame"), channelMessages = false, description = "Change Bots Game", usage = "!changeGame <game>", requiredPermissions = "admin.changeGame")
    fun onChangeGameCommand(args: Array<String>): String {
        if (args.isEmpty()) {
            return "No Game Inputted"
        }
        val string = StringBuilder()
        for (arg in args) {
            string.append(arg + " ")
        }

        Main.client!!.changePlayingText(string.toString())
        return "Game Changed to: " + string.toString()
    }
}
