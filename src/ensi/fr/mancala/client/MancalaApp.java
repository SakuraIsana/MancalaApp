package ensi.fr.mancala.client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

/**
 * Class in charge to launch the app controllers
 * @author : Guillaume Hasseneyer
 *  @author : Clémence Le Roux
 *
 */
public class MancalaApp extends Application {

    public static void main(String[] args) {
        launch(args);

    }

    /**
     * Initialize the stage
     * @param primaryStage : stage
     * @throws IOException : if fails
     */
    public void start(Stage primaryStage) throws IOException {

        URL location = getClass().getResource("/view/Game.fxml");
        FXMLLoader loader = new FXMLLoader(location);

        Parent root = loader.load();

        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Mancala");
        primaryStage.show();



    }

}

