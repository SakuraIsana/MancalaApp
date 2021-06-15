package ensi.fr.mancala.client.controller;

import ensi.fr.mancala.client.CellId;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

import java.util.Locale;

public class BoardController {

    MainController mainController;

    @FXML private StackPane zero;
    @FXML private StackPane one;
    @FXML private StackPane two;
    @FXML private StackPane three;
    @FXML private StackPane four;
    @FXML private StackPane five;
    @FXML private StackPane six;
    @FXML private StackPane seven;
    @FXML private StackPane eight;
    @FXML private StackPane nine;
    @FXML private StackPane ten;
    @FXML private StackPane eleven;

    public void setMainController(MainController mainController){
        this.mainController = mainController;
    }

    public void play(MouseEvent mouseEvent) {
        StackPane stackPane = (StackPane) mouseEvent.getSource();
        String stringToSend = (String) stackPane.getUserData();
        this.mainController.getClient().send("N", false);
        this.mainController.getClient().send(stringToSend, false);
        this.mainController.getClient().setMyTurn(false);

    }

    public StackPane getCellByNumber(int number){
        switch (number){
            case 0 :
                return zero;
            case 1 :
                return one;
            case 2 :
                return two;
            case 3 :
                return three;
            case 4 :
                return four;
            case 5 :
                return five;
            case 6 :
                return six;
            case 7 :
                return seven;
            case 8 :
                return eight;
            case 9 :
                return nine;
            case 10 :
                return ten;
            default :
                return eleven;

        }

    }


    public void updateCell(StackPane cellToUpdate, boolean available, int nbSeed){
        ObservableList<Node> childrens = cellToUpdate.getChildren();
        Circle circle = (Circle) childrens.get(0);
        Text text = (Text) childrens.get(1);

        text.setText("" + nbSeed);

        if(available){
            circle.setFill(Paint.valueOf("RED"));
        }
        else{
            circle.setFill(Paint.valueOf("BLUE"));
        }
    }
}
