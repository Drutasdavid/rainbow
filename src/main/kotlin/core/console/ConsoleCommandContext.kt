package core.console

import core.ICommandContext
import sx.blah.discord.api.IDiscordClient
import sx.blah.discord.handle.obj.IChannel
import sx.blah.discord.handle.obj.IGuild
import sx.blah.discord.handle.obj.IUser

data class ConsoleCommandContext(override val client: IDiscordClient, private val input : List<String>) : ICommandContext {
    override lateinit var guild: IGuild
    override val user: IUser = client.ourUser
    override val message = input[0]
    override val args: Array<String> = input.drop(1).toTypedArray()
    override val channel: IChannel = client.channels.first()
}