import com.github.kotlintelegrambot.bot
import com.github.kotlintelegrambot.dispatch
import com.github.kotlintelegrambot.dispatcher.*
import com.github.kotlintelegrambot.entities.ChatId
import com.github.kotlintelegrambot.entities.InlineKeyboardMarkup
import com.github.kotlintelegrambot.entities.ParseMode
import com.github.kotlintelegrambot.entities.TelegramFile
import com.github.kotlintelegrambot.entities.dice.DiceEmoji
import com.github.kotlintelegrambot.entities.inputmedia.InputMediaPhoto
import com.github.kotlintelegrambot.entities.inputmedia.MediaGroup
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


            command("pendejos"){
                val result=bot.sendMessage(chatId = ChatId.fromId(message.chat.id), text= "Os quiero desgraciados")
                result.fold ({ },{ })

            }

            command("alcohol"){
                val result=bot.sendMessage(chatId = ChatId.fromId(message.chat.id), text= "Patri vamonos a emborrachar con otro vermut")
                result.fold ({ },{ })

            }


            message(Filter.Reply or Filter.Forward){
                bot.sendMessage(chatId = ChatId.fromId(message.chat.id), text= "No me respondas idiota, no ves que mi tiempo es valioso")


            }
            message(Filter.Reply or Filter.Forward){
                bot.sendMessage(chatId = ChatId.fromId(message.chat.id), text= "¿Eres invesil o te lo haces? ¿No has leido lo anterior?")


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
                callbackAnswerText = "Vamos ,Se que quieres ( ✧≖ ͜ʖ≖)",
                callbackAnswerShowAlert = true
            ) {
                val chatId = callbackQuery.message?.chat?.id ?: return@callbackQuery
                bot.sendMessage(ChatId.fromId(chatId), callbackQuery.data)
            }

            command("PasaPack") {
                bot.sendMediaGroup(
                    chatId = ChatId.fromId(message.chat.id),
                    mediaGroup = MediaGroup.from(
                        InputMediaPhoto(
                            media = TelegramFile.ByUrl("https://noescinetodoloquereluce.com/wp-content/uploads/2013/10/Jaime-Dor.jpg"),
                            caption = "Dios ¡castigame, papasito!"
                        ),
                        InputMediaPhoto(
                            media = TelegramFile.ByUrl("https://img.ecartelera.com/noticias/fotos/62700/62717/1.jpg"),
                            caption = "Amamee, dame todoo"
                        )
                    ),
                    replyToMessageId = message.messageId
                )
            }

            command("comoNoHacerLimonada"){
                val markdownV2Text = """

                    [inline URL](https://www.youtube.com/watch?v=165VjNKRNdw)

                """.trimIndent()
                bot.sendMessage(
                    chatId = ChatId.fromId(message.chat.id),
                    text = markdownV2Text,
                    parseMode = ParseMode.MARKDOWN_V2
                )
            }
            command("bolos") {
                bot.sendDice(ChatId.fromId(message.chat.id), DiceEmoji.Bowling)
            }

            telegramError {
                println(error.getErrorMessage())
            }
        }


    }
    bot.startPolling()
}