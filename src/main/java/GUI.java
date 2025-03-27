import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class GUI extends Application {
    private static Stage primaryStage;

    public static void setPrimaryStage(Stage primaryStage) {
        GUI.primaryStage = primaryStage;
    }

    @Override
    public void start(Stage primaryStage) {
        GUI.primaryStage = primaryStage;
        loadScene("/hello-view.fxml");
    }

    public static void loadScene(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(GUI.class.getResource(fxmlFile));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}