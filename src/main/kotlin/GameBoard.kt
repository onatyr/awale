class GameBoard {
    private var board: Array<Cell> = Array(12){ Cell() }
    val letterList: List<String> = listOf("F","E","D","C","B","A","G","H","I","J","K","L")

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

    fun sawAndHarvest(letter: String) {
        val start = letterList.indexOf(letter)
        val seeds = board[start].seeds
        var index = -1
        var score = 0
        board[start].seeds = 0
        for (i in 0..<seeds){
            index = if (start+i+1 >= 12) start+i-11 else start+i+1
            board[index].seeds += 1
        }

        if(board[index].seeds >3){
            return
        }

        var harvastable = true
        while (harvastable){
            if(board[index].seeds <= 3){
                score += board[index].seeds
                board[index].seeds = 0
            }
            else{
                harvastable = false
            }
            index -=1
        }
    }
}