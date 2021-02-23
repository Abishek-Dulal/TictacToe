package org.example.GameDomain;

import java.util.function.Consumer;

public class GameBoard {

    private Tile[][] tilesBoard ;

    private void initializeBoard(){
        tilesBoard = new Tile[3][3];
        for(int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                tilesBoard[i][j]= new Tile();
            }
        }
    }
    public GameBoard(){
        initializeBoard();
    }

    public boolean move(TileState tilestate, int i, int j){
       return  tilesBoard[i][j].selectTile(tilestate);
    }

    public void restart(){
        initializeBoard();
    }

    public void draw(Consumer<Tile[][]> tilesConsumer){
        tilesConsumer.accept(tilesBoard);
    }

    public TileState getTileState(int rowIndex,int columnIndex){
       return tilesBoard[rowIndex][columnIndex].getTilestate();
    }


}
