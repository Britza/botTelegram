import com.github.kotlintelegrambot.bot
import com.github.kotlintelegrambot.dispatch
import com.github.kotlintelegrambot.dispatcher.command
import com.github.kotlintelegrambot.entities.ChatId
import com.github.kotlintelegrambot.network.fold

fun main(args: Array<String>) {

    //Instancia del bot
    val bot = bot {
        //token de nuestro bot
        token =Apikey.token
        //La funcion del dispacher es mantenerse a la escucha en todas las ventanas de chat en las que esté presente nuestro ente digital.
        dispatch {
            //comando que devolvera el mensaje introducida en text
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





