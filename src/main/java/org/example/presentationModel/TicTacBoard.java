package org.example.presentationModel;

import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import org.example.App;
import org.example.GameDomain.TicTacGame;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TicTacBoard implements Initializable {

    @FXML
    private GridPane tictacBoard;

    private TicTacGame ticTacGame;


    @FXML
    private Label primaryText;

    @FXML
    private Button restartButton;

    public TicTacBoard(TicTacGame ticTacGame) {
        this.ticTacGame = ticTacGame;
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        tictacBoard.setVgap(10);
        tictacBoard.setHgap(10);
        drawBoard();


        primaryText.setVisible(false);

        restartButton.setOnAction(event -> {
            primaryText.setVisible(false);
            ticTacGame.restart();
            tictacBoard.getChildren().clear();
            drawBoard();
        });

    }

    private void drawBoard() {
        ticTacGame.draw(tiles -> {
            for(int i=0;i< tiles.length;i++){
                for (int j=0;j<tiles[i].length;j++){
                    Parent parent = TileController.loadTileController(ticTacGame,i,j,primaryText);
                    tictacBoard.add(parent,i,j);
                }
            }
        });
    }

    public static Parent loadTicTacBoard(TicTacGame ticTacGame){
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("TicTacBoard.fxml"));
        TicTacBoard ticTacBoard = new TicTacBoard(ticTacGame);
        fxmlLoader.setController(ticTacBoard);
        try {
            return fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
