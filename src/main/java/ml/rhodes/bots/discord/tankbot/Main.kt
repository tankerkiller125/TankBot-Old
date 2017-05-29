package ml.rhodes.bots.discord.tankbot

import ml.rhodes.bots.discord.tankbot.commands.Help
import ml.rhodes.bots.discord.tankbot.commands.Info
import ml.rhodes.bots.discord.tankbot.commands.admin.*
import ml.rhodes.bots.discord.tankbot.utils.NewHandler
import sx.blah.discord.api.IDiscordClient

object Main {
    var client: IDiscordClient? = null
    var handler: NewHandler? = null

    /**
     * Main function
     *
     * @param args Array<String>
     * @return void
     */
    @JvmStatic fun main(args: Array<String>) {
        client = Bot.createClient(args[0], true) // Gets the client object (from the first example)

        handler = NewHandler(client)

        handler!!.loadPermissions()

        handler!!.registerCommand(Help(handler!!))
        handler!!.registerCommand(ChangeAvatar())
        handler!!.registerCommand(ChangeGame())
        handler!!.registerCommand(AddPermission(handler!!))
        handler!!.registerCommand(Exit())
        handler!!.registerCommand(RemovePermission(handler!!))
        handler!!.registerCommand(Info())

        Runtime.getRuntime().addShutdownHook(Thread {
            fun run() {
                print("Shutdown Run!")
            }
        })
    }
}
