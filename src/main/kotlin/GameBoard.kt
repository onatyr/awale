class GameBoard {
    private var board: Array<Cell> = Array(12) { Cell() }
    val letterList: List<String> = listOf("F", "E", "D", "C", "B", "A", "G", "H", "I", "J", "K", "L")
    private var currentIndex = 0

    fun displayBoard() {
        println(" A   B   C   D   E   F")
        for (i in 5 downTo 0) {
            print("(" + board[i].seeds.toString() + ") ")
        }
        println("")
        for (i in 6..11) {
            print("(" + board[i].seeds.toString() + ") ")
        }
        println("\n G   H   I   J   K   L")
    }

    fun cellIsEmpty(letter: String): Boolean {
        if(board[letterList.indexOf(letter)].seeds == 0){
            return true
        }
        return false
    }
    fun boardIsEmpty(): Boolean {
        for (i in 0..12) {
            if (board[i].seeds != 0) {
                return false
            }
        }
        return true
    }

    fun saw(letter: String) {
        val startIndex = letterList.indexOf(letter)
        val seeds = board[startIndex].seeds
        var jump = 0

        board[startIndex].seeds = 0
        for (i in 0..<seeds) {
            currentIndex = if (startIndex + i + jump + 1 >= 12) startIndex + i + jump - 11 else startIndex + i + jump + 1
            if (startIndex == currentIndex) {
                currentIndex += 1
                currentIndex = if (currentIndex >= 12) currentIndex - 12 else currentIndex
                jump = 1
            }
            board[currentIndex].seeds += 1
        }
    }

    fun harvest(upPoint: (points: Int) -> Unit) {
        var score = 0
        var harvastable = true
        while (harvastable) {
            if (board[currentIndex].seeds !in 2..3) {
                harvastable = false
            }
            else {
                score += board[currentIndex].seeds
                board[currentIndex].seeds = 0
                currentIndex -= 1
                currentIndex = if (currentIndex<0) currentIndex+12 else currentIndex
            }
        }
        upPoint(score)
    }
}