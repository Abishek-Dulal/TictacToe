package org.example.GameDomain;

public class PlayerManager {

    private Player currentPlayer;

    private Player firstPlayer;
    private Player secondPlayer;

    public PlayerManager(Player firstPlayer,Player secondPlayer){
        this.firstPlayer= firstPlayer;
        this.secondPlayer= secondPlayer;
        this.currentPlayer = firstPlayer;
    }


    public void changeCurrentPlayer(){
      currentPlayer = currentPlayer.equals(firstPlayer)?secondPlayer:firstPlayer;
        System.out.println(currentPlayer.getPlayerState());
    }


    public Player getCurrentPlayer(){
        return currentPlayer;
    }

}
