package org.example.presentationModel;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import org.example.App;
import org.example.GameDomain.Player;
import org.example.GameDomain.PlayerManager;
import org.example.GameDomain.PlayerState;
import org.example.GameDomain.TicTacGame;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PlayerUi implements Initializable {

    @FXML
    private RadioButton ticRadio;

    @FXML
    private RadioButton tocRadio;

    @FXML
    private Button startButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ToggleGroup group = new ToggleGroup();
        ticRadio.setToggleGroup(group);
        tocRadio.setToggleGroup(group);

        ticRadio.selectedProperty().or(tocRadio.selectedProperty()).addListener((c,oldvalue,newvalue)->{
            startButton.setDisable(!newvalue);
        });

        startButton.setDisable(true);
        startButton.setOnAction(actionEvent -> {
            Player firstPlayer =null ;
            Player secondPlayer =null;
            if(tocRadio.isSelected()){
                firstPlayer= new Player(PlayerState.TAC);
                secondPlayer = new Player(PlayerState.TIC);
            }else if(ticRadio.isSelected()){
                firstPlayer = new Player(PlayerState.TIC);
                secondPlayer= new Player(PlayerState.TAC);
            }
            PlayerManager playerManager = new PlayerManager(firstPlayer,secondPlayer);
            TicTacGame ticTacGame = new TicTacGame(playerManager);
            App.setRoot(TicTacBoard.loadTicTacBoard(ticTacGame));
        });
    }

    public static Parent loadPlayerUi(){
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("playerUi.fxml"));
        PlayerUi playerUi = new PlayerUi();
        fxmlLoader.setController(playerUi);
        try {
            return fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
