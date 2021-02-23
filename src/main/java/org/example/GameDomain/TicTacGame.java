package org.example.GameDomain;

import java.util.function.Consumer;

public class TicTacGame {
    private GameBoard gameBoard;
    private PlayerManager playerManager;
    private boolean isGameOver;

    public TicTacGame(PlayerManager playerManager) {
        this.playerManager=playerManager;
        this.gameBoard = new GameBoard();
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public void playGame(int i, int j){
        if(!isGameOver){
            Player player = playerManager.getCurrentPlayer();
            if( gameBoard.move(changPlayerStateToTile(player.getPlayerState()),i,j)){
               playerManager.changeCurrentPlayer();
            }
            isGameOver = checkWinCondition(changPlayerStateToTile(player.getPlayerState()),gameBoard);
        }
    }

    public void draw(Consumer<Tile[][]> tileConsumer){
        gameBoard.draw(tileConsumer);
    }

    private boolean checkWinCondition(TileState state, GameBoard gameBoard) {
           return   equalsToSingleTile(state,gameBoard.getTileState(0,0)) &&
                      equalsToSingleTile(state,gameBoard.getTileState(0,1)) &&
                      equalsToSingleTile(state,gameBoard.getTileState(0,2)) ||
                      equalsToSingleTile(state,gameBoard.getTileState(1,0)) &&
                              equalsToSingleTile(state,gameBoard.getTileState(1,1)) &&
                              equalsToSingleTile(state,gameBoard.getTileState(1,2)) ||
                      equalsToSingleTile(state,gameBoard.getTileState(2,0)) &&
                              equalsToSingleTile(state,gameBoard.getTileState(2,1)) &&
                              equalsToSingleTile(state,gameBoard.getTileState(2,2)) ||
                      equalsToSingleTile(state,gameBoard.getTileState(0,0)) &&
                      equalsToSingleTile(state,gameBoard.getTileState(1,0)) &&
                      equalsToSingleTile(state,gameBoard.getTileState(2,0)) ||
                      equalsToSingleTile(state,gameBoard.getTileState(0,1)) &&
                      equalsToSingleTile(state,gameBoard.getTileState(1,1)) &&
                      equalsToSingleTile(state,gameBoard.getTileState(2,1)) ||
                      equalsToSingleTile(state,gameBoard.getTileState(0,2)) &&
                              equalsToSingleTile(state,gameBoard.getTileState(1,2)) &&
                              equalsToSingleTile(state,gameBoard.getTileState(2,2)) ||
                      equalsToSingleTile(state,gameBoard.getTileState(2,0)) &&
                              equalsToSingleTile(state,gameBoard.getTileState(1,1)) &&
                              equalsToSingleTile(state,gameBoard.getTileState(0,2)) ||
                      equalsToSingleTile(state,gameBoard.getTileState(2,2)) &&
                              equalsToSingleTile(state,gameBoard.getTileState(1,1)) &&
                              equalsToSingleTile(state,gameBoard.getTileState(0,0)) ;
    }

    private boolean equalsToSingleTile(TileState  tileState,TileState boardTile){
        return tileState.equals(boardTile);
    }




    public TileState changPlayerStateToTile(PlayerState state){
        if(state.equals(PlayerState.TAC)){
            return TileState.TAC;
        }
        return TileState.TIC;
    }

    public Player getWinner(){
        if(isGameOver){
            return playerManager.getCurrentPlayer();
        }
        return null;
    }

    public Player getCurrentPlayer(){
        return playerManager.getCurrentPlayer();
    }

    public void restart(){
        isGameOver=false;
        gameBoard.restart();
    }

}
