import com.github.kotlintelegrambot.bot
import com.github.kotlintelegrambot.dispatch
import com.github.kotlintelegrambot.dispatcher.callbackQuery
import com.github.kotlintelegrambot.dispatcher.command
import com.github.kotlintelegrambot.dispatcher.message
import com.github.kotlintelegrambot.entities.ChatId
import com.github.kotlintelegrambot.entities.InlineKeyboardMarkup
import com.github.kotlintelegrambot.entities.ParseMode
import com.github.kotlintelegrambot.entities.TelegramFile
import com.github.kotlintelegrambot.entities.inputmedia.InputMediaPhoto
import com.github.kotlintelegrambot.entities.inputmedia.MediaGroup
import com.github.kotlintelegrambot.entities.keyboard.InlineKeyboardButton
import com.github.kotlintelegrambot.extensions.filters.Filter
import com.github.kotlintelegrambot.network.fold

fun main (){

    val bot = bot {

        token = ApiKey.token

        dispatch {

            command("hola"){
                val result=bot.sendMessage(chatId = ChatId.fromId(message.chat.id), text= "Buenos dias, pinche pendejo")
                result.fold ({ },{ })

            }
            command("aviso") {
                val result =
                    bot.sendMessage(chatId = ChatId.fromId(message.chat.id), text = "Es importante que sepais que Patricia es la mejor")
                result.fold({
                    // do something here with the response
                }, {
                    // do something with the error
                })
            }
            command("continuacion") {
                val resutl = bot.sendMessage(chatId = ChatId.fromId(message.chat.id), text = "Ese dia patri si se cayo, se cayo en unas silvas, britza se bajo cas toda la botella")
                resutl.fold({
                    //do something with the error
                })
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
            command("insulto2"){
                val result=bot.sendMessage(chatId = ChatId.fromId(message.chat.id), text = "Te insultaria pero ya tienes suficiente con despertarte todos los dias")
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

            command("hector"){
                val result=bot.sendMessage(chatId = ChatId.fromId(message.chat.id), text= "Te amo, cariño")
                result.fold ({ },{ })

            }



            command("pendejos"){
                val result=bot.sendMessage(chatId = ChatId.fromId(message.chat.id), text= "Os quiero desgraciados")
                result.fold ({ },{ })

            }

            command("alcohol"){
                val result=bot.sendMessage(chatId = ChatId.fromId(message.chat.id), text= "Patri vamonos a emborrachar con otro vermut")
                result.fold ({ },{ })

            }
            command("viernesDeChiste"){
                val result=bot.sendMessage(chatId = ChatId.fromId(message.chat.id), text= "Ese buen dia, decidieron ir a un monte, Patri y Britza a tomar un buen vermut" +
                        " y el niño pequeño de kiskos un zumo. Pasado el tiempo y la botella de vermut vacia, Patri y Britza decidieron ir a mear, no fue una gran idea porque " +
                        "Patri casi se cae y la podriamos haber perdido, pero no paso, lo maximo que paso fue 'perder' el paraguas por la culpa de la señora ")
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
                callbackAnswerText = "Vamos,Se que quieres ",
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
            command("kiskos") {
                bot.sendMediaGroup(
                    chatId = ChatId.fromId(message.chat.id),
                    mediaGroup = MediaGroup.from(

                        InputMediaPhoto(
                            media = TelegramFile.ByUrl("https://i.pinimg.com/originals/01/a5/96/01a5964307ad9d792a7a2db549eabdb9.png"),
                            caption = "Kiskos vendra a tu casa"
                        ),

                        InputMediaPhoto(
                            media = TelegramFile.ByUrl("https://i.ytimg.com/vi/zjvlzY98U-w/maxresdefault.jpg"),
                            caption = "Así se pone cuando le hacen cosquillas"
                        )
                    ),
                    replyToMessageId = message.messageId
                )
            }

            command("elBuenTrabajo") {
                val markdownV2Text = """
                  
                 [inline URL](https://www.youtube.com/watch?v=LYIJF1IAdqY)
               
                """.trimIndent()
                bot.sendMessage(
                    chatId = ChatId.fromId(message.chat.id),
                    text = markdownV2Text,
                    parseMode = ParseMode.MARKDOWN_V2
                )
            }
            command("magia") {
                val markdownV2Text = """
                  
                 [inline URL](https://www.youtube.com/watch?v=dQw4w9WgXcQ)
               
                """.trimIndent()
                bot.sendMessage(
                    chatId = ChatId.fromId(message.chat.id),
                    text = markdownV2Text,
                    parseMode = ParseMode.MARKDOWN_V2
                )
            }
        }

    }
    bot.startPolling()
}