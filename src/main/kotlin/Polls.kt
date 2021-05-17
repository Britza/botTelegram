import com.github.kotlintelegrambot.bot
import com.github.kotlintelegrambot.dispatch
import com.github.kotlintelegrambot.dispatcher.command
import com.github.kotlintelegrambot.dispatcher.pollAnswer
import com.github.kotlintelegrambot.entities.ChatId
import com.github.kotlintelegrambot.entities.polls.PollType


fun main() {
    val bot = bot {

        token = Apikey.token

        dispatch {
            //Devuelve el usuario que ha seleccionado una opcion en la encuesta
            pollAnswer {
                println("${pollAnswer.user.username} has selected the option ${pollAnswer.optionIds.lastOrNull()} in the poll ${pollAnswer.pollId}")
            }
            //Comando que muestra la encuesta, esta solo permite elegir una opcion y tiene una solucion
            command("encuesta") {

                bot.sendPoll(
                    chatId = ChatId.fromId(message.chat.id),
                    type = PollType.QUIZ,
                    question = "¿Quien tiene el mejor culo?",
                    options = listOf("Jennifer López", "Las Kardashian","yo por su puesto","M.Rajoy","Britza"),
                    correctOptionId = 4, // index of the correct option,
                    isAnonymous = false
                )
            }
            //Comando que muestra la encuesta, esta solo permite elegir una opcion y tiene una solucion

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
            //Comando que muestra la encuesta, multiples respuestas a escojer y no tiene una solucion

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

        }
    }
    bot.startPolling()
}