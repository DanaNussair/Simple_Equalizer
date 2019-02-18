import java.io.IOException;
import javafx.application.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.fxml.FXMLLoader;
 
public class Equalizer extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
    	Scene scene = new Scene(root);
        primaryStage.setTitle("Equalizer");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
