fun main() {
    val board = GameBoard()
    val playerNorth = Player("north")
    val playerSouth = Player("south")
    board.displayBoard()
    fun game() {
        println("----------------------------")
        playerNorth.play(board)
        board.displayBoard()
        println("----------------------------")
        playerSouth.play(board)
        board.displayBoard()
        if (!board.boardIsEmpty()) game()
        println("Score du jour north: ${playerNorth.score}")
        println("Score du jour south: ${playerSouth.score}")
    }
    game()

}