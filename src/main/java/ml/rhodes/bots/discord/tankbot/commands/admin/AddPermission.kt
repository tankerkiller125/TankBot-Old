package ml.rhodes.bots.discord.tankbot.commands.admin

import de.btobastian.sdcf4j.Command
import de.btobastian.sdcf4j.CommandExecutor


import ml.rhodes.bots.discord.tankbot.Main
import ml.rhodes.bots.discord.tankbot.utils.NewHandler
import sx.blah.discord.handle.obj.IMessage
import sx.blah.discord.handle.obj.IUser

class AddPermission(private val commandHandler: NewHandler) : CommandExecutor {

    /**
     * Give user permission
     *
     * @param args Array<String>
     * @param user IUser
     * @param message IMessage
     * @return String
     */
    @Command(aliases = arrayOf("!addpermission", "!addperm"), usage = "!addperm <permission> <@users>", channelMessages = true, privateMessages = false)
    fun onAddPermissionCommand(args: Array<String>, user: IUser, message: IMessage): String {
        if (user.discriminator == Main.client!!.applicationOwner.discriminator || commandHandler.hasPermission(user.stringID, "admin.addPermission")) {
            if (args.isEmpty() || args.size < 2) {
                return "Not enough arguments"
            } else {
                val users = message.mentions
                users.forEach { user ->
                    commandHandler.addPermission(user.stringID, args[0])
                    return user.mention() + " has received the " + args[0] + " permission."
                }
                return "This should never happen!"
            }
        } else return user.mention() + " | You do not have enough permissions to do that!"
    }
}