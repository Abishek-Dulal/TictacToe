package org.example.presentationModel;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Paint;
import org.example.App;
import org.example.GameDomain.PlayerState;
import org.example.GameDomain.TicTacGame;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TileController implements Initializable {

    @FXML
    private AnchorPane tilePane;


    private TicTacGame ticTacGame;
    private int rowIndex;
    private int columnIndex;

    private Label primaryText;



    public TileController(TicTacGame  ticTacGame,int rowIndex, int columnIndex,Label primaryText) {
        this.rowIndex = rowIndex;
        this.columnIndex = columnIndex;
        this.ticTacGame=ticTacGame;
        this.primaryText = primaryText;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tilePane.setOnMouseClicked(mouseEvent -> {
            if(!ticTacGame.isGameOver()){
                changeGraphic(ticTacGame.getCurrentPlayer().getPlayerState());
                ticTacGame.playGame(rowIndex,columnIndex);
            }
            if(ticTacGame.isGameOver()){
                primaryText.setVisible(true);
                primaryText.setText(ticTacGame.getCurrentPlayer().getPlayerState().name() +"won");
            }
        });


    }

    public void changeGraphic(PlayerState tileState){
        switch (tileState){
            case TAC:{
                tilePane.setBackground(new Background(new BackgroundFill(Paint.valueOf("orange"),null,null)));
               break;
            }
            case TIC:{
                tilePane.setBackground(new Background(new BackgroundFill(Paint.valueOf("purple"),null,null)));
               break;
            }
        }

    }


    public static Parent loadTileController(TicTacGame ticTacGame, int rowIndex, int columnIndex, Label primaryText) {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("tile.fxml"));
        TileController tileController = new TileController(ticTacGame,rowIndex,columnIndex,primaryText);
        fxmlLoader.setController(tileController);
        try {
            return fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }



}
