package org.example.GameDomain;

public class Tile {

    private TileState tilestate = TileState.UNDECIDED;

    public boolean selectTile(TileState state){
        if(tilestate == TileState.UNDECIDED && state != TileState.UNDECIDED ){
            tilestate = state;
            return  true;
        }
        return  false;
    }

    public TileState getTilestate(){
        return tilestate;
    }



}
