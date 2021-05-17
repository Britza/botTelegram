import com.github.kotlintelegrambot.bot
import com.github.kotlintelegrambot.dispatch
import com.github.kotlintelegrambot.dispatcher.command
import com.github.kotlintelegrambot.entities.ChatId
import com.github.kotlintelegrambot.network.fold

fun main(args: Array<String>) {

    val bot = bot {
        token =Apikey.token
        dispatch {
            command("start") {
                val result = bot.sendMessage(chatId = ChatId.fromId(message.chat.id), text = " El mejor bot se ha iniciado ")
                result.fold({
                    // do something here with the response
                },{
                    // do something with the error
                })
            }
        }
    }
    bot.startPolling()
}





