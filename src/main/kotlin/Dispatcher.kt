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

fun main (){

    val bot = bot {

        token = Apikey.token

        dispatch {

            /**
             * Método que recibe un y devuelve el siguiente mensaje
             */
            command("hola"){
                val result=bot.sendMessage(chatId = ChatId.fromId(message.chat.id), text= "Buenos dias, pinche pendejo")
                result.fold ({ },{ })

            }
            /**
             * Método que recibe un texto que sera el comando a utlizar en teleram y devuelve el siguiente mensaje
             */
            command("aviso") {
                val result =
                    bot.sendMessage(chatId = ChatId.fromId(message.chat.id), text = "Es importante que sepais que Patricia es la mejor")
                result.fold({
                    // do something here with the response
                }, {
                    // do something with the error
                })
            }
            /**
             * Método que recibe  un texto que sera el comando a utlizar en teleram un y devuelve el siguiente mensaje
             */
            command("continuacion") {
                val resutl = bot.sendMessage(chatId = ChatId.fromId(message.chat.id), text = "Ese dia patri si se cayo, se cayo en unas silvas, britza se bajo cas toda la botella")
                resutl.fold({
                    //do something with the error
                })
            }
            /**
             * Método que recibe  un texto que sera el comando a utlizar en teleram y devuelve el siguiente mensaje
             */
            command("F"){
                val result=bot.sendMessage(chatId = ChatId.fromId(message.chat.id), text= "F por mi culo")
                result.fold ({ },{ })

            }
            /**
             * Método que recibe  un texto que sera el comando a utlizar en teleram y devuelve el siguiente mensaje
             */
            command("pobre"){
                val result=bot.sendMessage(chatId = ChatId.fromId(message.chat.id), text= "por que estoy solo , no era que me queriais?")
                result.fold ({ },{ })

            }
            /**
             * Método que recibe  un texto que sera el comando a utlizar en teleram y devuelve el siguiente mensaje
             */

            command("adios"){
                val result=bot.sendMessage(chatId = ChatId.fromId(message.chat.id), text= "Adió pendejo")
                result.fold ({  },{ }
                )
            }
            /**
             * Método que recibe  un texto que sera el comando a utlizar en teleram y devuelve el siguiente mensaje
             */

            command("insulto"){
                val result=bot.sendMessage(chatId = ChatId.fromId(message.chat.id), text = "Eres un invesil XD")
                result.fold({},{})
            }
            /**
             * Método que recibe  un texto que sera el comando a utlizar en teleram y devuelve el siguiente mensaje
             */
            command("insulto2"){
                val result=bot.sendMessage(chatId = ChatId.fromId(message.chat.id), text = "Te insultaria pero ya tienes suficiente con despertarte todos los dias")
                result.fold({},{})
            }

            /**
             * Método que recibe  un texto que sera el comando a utlizar en teleram y devuelve el siguiente mensaje
             */
            command("muricion"){
                val result=bot.sendMessage(chatId = ChatId.fromId(message.chat.id), text = "Toma gancho y cuerda, si miras por la ventana ahí tienes un arbol")
                result.fold({},{})
            }
            /**
             * Método que recibe  un texto que sera el comando a utlizar en teleram y devuelve el siguiente mensaje
             */
            command("deprimision"){
                val result=bot.sendMessage(chatId = ChatId.fromId(message.chat.id), text = "Si quieres llorar, tienes puerta abierta a la llorecry")
                result.fold({},{})
            }

            /**
             * Método que recibe  un texto que sera el comando a utlizar en teleram y devuelve el siguiente mensaje
             */
            command("pendejos"){
                val result=bot.sendMessage(chatId = ChatId.fromId(message.chat.id), text= "Os quiero desgraciados")
                result.fold ({ },{ })

            }
            /**
             *Método que recibe  un texto que sera el comando a utlizar en teleram y devuelve el siguiente mensaje
             */

            command("alcohol"){
                val result=bot.sendMessage(chatId = ChatId.fromId(message.chat.id), text= "Patri vamonos a emborrachar con otro vermut")
                result.fold ({ },{ })

            }

            /**
             * Método que envia un mensaje si respondes en telegram al mensaje enviado por el bot
             */
            message(Filter.Reply or Filter.Forward){
                bot.sendMessage(chatId = ChatId.fromId(message.chat.id), text= "No me respondas idiota, no ves que mi tiempo es valioso")


            }
            /**
             * Método que envia un mensaje si respondes en telegram al mensaje enviado por el bot
             */
            message(Filter.Reply or Filter.Forward){
                bot.sendMessage(chatId = ChatId.fromId(message.chat.id), text= "¿Eres invesil o te lo haces? ¿No has leido lo anterior?")


            }
            /**
             * Método que envia un mensaje si respondes en telegram al mensaje enviado por el bot
             */
            message(Filter.Reply or Filter.Forward){
                bot.sendMessage(chatId = ChatId.fromId(message.chat.id), text= "En fin, la hipotenusa")


            }

            /**
             * Método que envia un mensaje si enias un sticker por telegram
             */
            message (Filter.Sticker){
                bot.sendMessage(ChatId.fromId(message.chat.id), text = "A ver amigo, que mierda de sticker me envias, ¿enserio me haces perder mi tiempo por esto?")
            }
            /**
             * Método que crea dos botones con los que interactuar.
             */
            command("elige"){
                val inlineKeyboardMarkup = InlineKeyboardMarkup.create(
                    //CallbackData devuelve un texto al presionar el boton,
                    listOf(InlineKeyboardButton.CallbackData(text ="Tocame ", callbackData = "Picantee ( ͡° ͜ʖ ͡°)")),
                    listOf(InlineKeyboardButton.CallbackData(text = "Pinchame",callbackData = "¿UwU?"))

                )
                bot.sendMessage(
                    chatId = ChatId.fromId(message.chat.id),
                    text = "Presioname se que quieres",
                    replyMarkup = inlineKeyboardMarkup
                )
            }
            /**
             * Es el texto que aparece asociado del boton command elige
             */

            callbackQuery("Picantee ( ͡° ͜ʖ ͡°)") {
                val chatId = callbackQuery.message?.chat?.id ?: return@callbackQuery
                bot.sendMessage(ChatId.fromId(chatId), callbackQuery.data)
            }
            /**
             * Es el texto que aparece asociado del boton command elige
             */

            callbackQuery(
                callbackData = "¿UwU?",
                callbackAnswerText = "Vamos ,Se que quieres ( ✧≖ ͜ʖ≖)",
                callbackAnswerShowAlert = true
            ) {
                val chatId = callbackQuery.message?.chat?.id ?: return@callbackQuery
                bot.sendMessage(ChatId.fromId(chatId), callbackQuery.data)
            }
            /**
             * Envia las fotos de las url puestas en media y les añade el texto escrito en caption
             */
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

            /**
             * envia el video de la url pasada
             */
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
            /**
             * envia un emoji de un bolo
             */
            command("bolos") {
                bot.sendDice(ChatId.fromId(message.chat.id), DiceEmoji.Bowling)
            }

            /**
             * Texto de error de telgram
             */
            telegramError {
                println(error.getErrorMessage())
            }

            /**
             * envia el video de la url pasada
             */
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
            /**
             * envia el video de la url pasada
             */
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
            /**
             * Altera el texto sin necesidad de un editor de texto. Solo sirve para texto incluido en el comando
             * */
            command("markdown") {
                val markdownText = "Mi gran mensaje: Markdown es util a su manera"
                bot.sendMessage(
                    chatId = ChatId.fromId(message.chat.id),
                    text = markdownText,
                    parseMode = ParseMode.MARKDOWN
                )
            }
            /**
             * Version mejorada del marckdown. Lo de la mencion del usuario aun no funciona ni en la libreria de kotlinTelegram
             */
            command("markdown2") {
                val markdownV2Text = """
                    negrita
                    italic
                    subrallado
                    ~tachado~
                    negrita italic negrita ~italic negrita tachada~ subrallado italic negrita negrita
                    [Nuestro bot](https://github.com/Britza/botTelegram)
                    [inline mention of a user](tg://user?id=123456789) 
                    inline fixed-width code
                    
                    fun main() {
                        println("Hello Kotlin!")
                    }
                    

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