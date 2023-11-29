fun main() {
    val board = GameBoard()
    val playerNorth = Player("north")
    val playerSouth = Player("south")
    board.displayBoard()
    fun game(){
        println("----------------------------")
        playerNorth.play(board)
        board.displayBoard()
        println("----------------------------")
        playerSouth.play(board)
        board.displayBoard()
        game()
    }
    game()

}