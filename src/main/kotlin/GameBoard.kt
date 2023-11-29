class GameBoard {
    private var board: Array<Cell> = Array(12){ Cell() }
    val letterList: List<String> = listOf("F","E","D","C","B","A","G","H","I","J","K","L")
    private var currentIndex = 0

    fun displayBoard() {
        println(" A   B   C   D   E   F")
        for (i in 5 downTo 0){
            print("(" + board[i].seeds.toString() + ") ")
        }
        println("")
        for (i in 6 .. 11){
            print("(" + board[i].seeds.toString() + ") ")
        }
        println("\n G   H   I   J   K   L")
    }

    fun isEmpty(): Boolean {
        for (i in 0..12){
            if (board[i].seeds != 0){
                return false
            }
        }
        return true
    }

    fun saw(letter: String) {
        val startIndex = letterList.indexOf(letter)
        val seeds = board[startIndex].seeds

        board[startIndex].seeds = 0
        for (i in 0..<seeds){
            currentIndex = if (startIndex+i+1 >= 12) startIndex+i-11 else startIndex+i+1
            board[currentIndex].seeds += 1
        }
    }

    fun harvest(upPoint: (points: Int) -> Unit){
        if(board[currentIndex].seeds >3){
            return
        }

        var score = 0
        var harvastable = true
        while (harvastable){
            if(board[currentIndex].seeds <= 3){
                score += board[currentIndex].seeds
                board[currentIndex].seeds = 0
            }
            else{
                harvastable = false
            }
            currentIndex -= 1
        }
        upPoint(score)
    }
}