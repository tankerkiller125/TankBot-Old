package ml.rhodes.bots.discord.tankbot.commands.admin

import de.btobastian.sdcf4j.Command
import de.btobastian.sdcf4j.CommandExecutor
import sx.blah.discord.handle.obj.IMessage
import sx.blah.discord.handle.obj.IUser

class ChangeAvatar : CommandExecutor {
    @Command(aliases = arrayOf("!changeavatar", "!chgavatar"), async = true, usage = "!changeAvatar <avatarUrl>", description = "Change the Bots Avatar", requiredPermissions = "admin.changeAvatar", channelMessages = false)
    fun onChangeAvatarCommand(user: IUser, message: IMessage): String {
        return "Change Avatar Coming Soon"
    }
}