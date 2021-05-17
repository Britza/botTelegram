import com.github.kotlintelegrambot.bot
import com.github.kotlintelegrambot.dispatch
import com.github.kotlintelegrambot.dispatcher.command
import com.github.kotlintelegrambot.dispatcher.message
import com.github.kotlintelegrambot.entities.ChatId
import com.github.kotlintelegrambot.extensions.filters.Filter
import com.github.kotlintelegrambot.network.fold
import java.lang.Compiler.command

fun main (){

    val bot = bot {

        token = Apikey.token

        dispatch {

            command("hola"){
                val result=bot.sendMessage(chatId = ChatId.fromId(message.chat.id), text= "Buenos dias, pinche pendeja")
                result.fold ({ },{ })

            }

            command("adios"){
                val result=bot.sendMessage(chatId = ChatId.fromId(message.chat.id), text= "Adió pendejo")
                result.fold ({  },{ }
                )
            }

            command("insulto"){
                val result=bot.sendMessage(chatId = ChatId.fromId(message.chat.id), text = "Eres un invesil XD")
                result.fold({},{})
            }

            message(Filter.Reply or Filter.Forward){
                bot.sendMessage(chatId = ChatId.fromId(message.chat.id), text= "No me respondas idiota, no ves que mi tiempo es valioso")


            }
        }

    }
    bot.startPolling()
}