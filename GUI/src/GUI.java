import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GUI {
    public static void main(String[] args) {
        Application.launch(FxApplication.class, args);
    }

    public static class FxApplication extends Application {
        @Override
        public void start(Stage stage) throws Exception {
            FXMLLoader loader = new FXMLLoader(FxApplication.class.getResource("/test.fxml"));

            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
            stage.setTitle("FXML Beispiel");
            stage.setWidth(605);
            stage.setHeight(400);
            stage.show();

        }
    }


}
