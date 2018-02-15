package ishto;
import ishto.logic.Game;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
public class ApplicationStarter  extends Application {
    public static VBox mainScnVBox;
    public static Stage primaryStage;
    public static Game game;
    public void start(Stage primaryStage) throws Exception {
        ApplicationStarter.primaryStage =primaryStage;
        FXMLLoader mainScreenFXMLLoader;
        mainScreenFXMLLoader=new FXMLLoader(getClass().getResource("controller/fxml/main_screen.fxml"));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        VBox mainScreenVBox;
        primaryStage.getIcons().add(new Image(ishto.controller.fxml.ResourceHelper.class.getResourceAsStream("main.png")));
        mainScreenVBox= mainScreenFXMLLoader.load();
        Scene mainScene = new Scene(mainScreenVBox);
        mainScnVBox =mainScreenVBox;
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }
}
