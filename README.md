# Bot Telegram

## Indice

1)Dispatcher (comandos que devuelven mensajes , fotos ...)  
2)Echo (repite mensajes)  
3)Polls (encuestas)  

## Echo

El echo hace que el bot repita cualquier mensaje que reciba 


```
    command("start") {
                val result = bot.sendMessage(chatId = ChatId.fromId(message.chat.id), text = " El mejor bot se ha iniciado ")
                result.fold({
                    // do something here with the response
                },{
                    // do something with the error
                })
                
```


![echo_ver](https://github.com/Britza/botTelegram/blob/master/src/main/imagenes/strat.PNG) 

## Dispatcher
La función del dispatcher es mantenerse a la escucha en todas las ventanas de chat.
```
 command("hola"){
                val result=bot.sendMessage(chatId = ChatId.fromId(message.chat.id), text= "Buenos dias, pinche pendejo")
                result.fold ({ },{ })

            }
 ```


Ejemplos :

![video](https://github.com/Britza/botTelegram/blob/master/src/main/imagenes/ejemplo1este.PNG)  

![sticker](https://github.com/Britza/botTelegram/blob/master/src/main/imagenes/bolos1.PNG)

Se puede utilizar markdown, para cambiar el estilo de la fuente del texto (negrita, cursiva, hiperenlaces...). 

```
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
```

se veria así  

![ver_markdown](https://github.com/Britza/botTelegram/blob/master/src/main/imagenes/markdown.PNG)     



también se pueden utilizar botones :  

```
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
```

perdon por esto 
 
![botones](https://github.com/Britza/botTelegram/blob/master/src/main/imagenes/boton.PNG)  



## Polls
Las polls son encuestas que permiten elegir opciones o contestar a preguntas. Existen dos tipos de encuestas, encuestas en 
las que se le define una respuesta correcta y encuestas que permiten repuestas múltiples. En estas respuestas se ve el porcentaje
de opciones seleccionadas y los usuarios que seleccionaron las opciones.  
Encuesta de opción correcta :    

![encuesta1](https://github.com/Britza/botTelegram/blob/master/src/main/imagenes/encuesta.PNG)  

```
 command("encuestameEsta") {

                bot.sendPoll(
                    chatId = ChatId.fromId(message.chat.id),
                    type = PollType.QUIZ,
                    question = "Ahora a ver ...¿Quien tiene el mejor culo?",
                    options = listOf("Jennifer López", "Las Kardashian","Putin","M.Rajoy","Britza"),
                    correctOptionId = 2, // index of the correct option,
                    isAnonymous = false
                )
            }
```

Encuesta de multiples opciones  

![encuesta2](https://github.com/Britza/botTelegram/blob/master/src/main/imagenes/encuesta1.PNG)  

```
 command("encuesta2") {
                bot.sendPoll(
                    chatId = ChatId.fromId(message.chat.id),
                    question = "Tu personas favoritas",
                    options = listOf(
                        "Josh Harnet",
                        "Patricia",
                        "Britza",
                        "Todas las respuestas son correctas en verdad",


                        ),
                    openPeriod = 120,
                    //Permite que sean escogidas varias respuestas
                    allowsMultipleAnswers = true,
                    isAnonymous = false
                )
            }
```

## Funcion del bot
La función de este bot es ser borde y envia cosas aleatorias, agresivas e insultos.
## Autores
Britza Zegarra Flores  
Patricia Maceiras Varela

