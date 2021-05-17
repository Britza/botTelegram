import com.github.kotlintelegrambot.bot
import com.github.kotlintelegrambot.dispatch
import com.github.kotlintelegrambot.dispatcher.callbackQuery
import com.github.kotlintelegrambot.dispatcher.command
import com.github.kotlintelegrambot.dispatcher.message
import com.github.kotlintelegrambot.entities.ChatId
import com.github.kotlintelegrambot.entities.InlineKeyboardMarkup
import com.github.kotlintelegrambot.entities.keyboard.InlineKeyboardButton
import com.github.kotlintelegrambot.extensions.filters.Filter
import com.github.kotlintelegrambot.network.fold
import java.lang.Compiler.command

fun main (){

    val bot = bot {

        token = Apikey.token

        dispatch {

            command("hola"){
                val result=bot.sendMessage(chatId = ChatId.fromId(message.chat.id), text= "Buenos dias, pinche pendejo")
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

            command("muricion"){
                val result=bot.sendMessage(chatId = ChatId.fromId(message.chat.id), text = "Toma gancho y cuerda, si miras por la ventana ahí tienes un arbol")
                result.fold({},{})
            }

            command("deprimision"){
                val result=bot.sendMessage(chatId = ChatId.fromId(message.chat.id), text = "Si quieres llorar, tienes puerta abierta a la llorecry")
                result.fold({},{})
            }


            message(Filter.Reply or Filter.Forward){
                bot.sendMessage(chatId = ChatId.fromId(message.chat.id), text= "No me respondas idiota, no ves que mi tiempo es valioso")


            }

            message (Filter.Sticker){
                bot.sendMessage(ChatId.fromId(message.chat.id), text = "A ver amigo, que mierda de sticker me envias, ¿enserio me haces perder mi tiempo por esto?")
            }

            command("elige"){
                val inlineKeyboardMarkup = InlineKeyboardMarkup.create(

                    listOf(InlineKeyboardButton.CallbackData(text ="Tocame ", callbackData = "Picantee ( ͡° ͜ʖ ͡°)")),
                    listOf(InlineKeyboardButton.CallbackData(text = "Pinchame",callbackData = "¿UwU?"))

                )
                bot.sendMessage(
                    chatId = ChatId.fromId(message.chat.id),
                    text = "Presioname se que quieres",
                    replyMarkup = inlineKeyboardMarkup
                )
            }

            callbackQuery("Picantee ( ͡° ͜ʖ ͡°)") {
                val chatId = callbackQuery.message?.chat?.id ?: return@callbackQuery
                bot.sendMessage(ChatId.fromId(chatId), callbackQuery.data)
            }

            callbackQuery(
                callbackData = "¿UwU?",
                callbackAnswerText = "Vamos,Se que quieres ",
                callbackAnswerShowAlert = true
            ) {
                val chatId = callbackQuery.message?.chat?.id ?: return@callbackQuery
                bot.sendMessage(ChatId.fromId(chatId), callbackQuery.data)
            }
        }

    }
    bot.startPolling()
}