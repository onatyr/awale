import java.util.*

class Player(northSouth: String) {
    var score: Int = 0
    private val type = northSouth

    fun play(board: GameBoard) {
        print("Joueur $type à toi de choisir une lettre : ")
        val letter: String = readln().uppercase(Locale.getDefault())
        if (type == "north" && ("A" > letter || letter > "F")) {
            println("Rentrer une lettre valide")
            play(board)
        }
        else if (type == "south" && ("G" > letter || letter > "L")){
            println("Rentrer une lettre valide")
            play(board)
        }
        else if (board.cellIsEmpty(letter)) {
            println("Case vide")
            play(board)
        }
        else {
            board.saw(letter)
            board.harvest(::upScore)
        }

    }

    private fun upScore(points: Int) {
        score += points
        println("Score joueur $type: $score")
    }
}