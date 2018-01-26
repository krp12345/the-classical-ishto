package ishto;
import java.io.File;
import java.io.FileInputStream;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;

public class ApplicationStarter  extends Application {

    public static Scene mainScn;

    public static Stage prStage;

    public void start(Stage primaryStage) throws Exception {

        prStage=primaryStage;

        FXMLLoader mainScreenFXMLLOader;

        mainScreenFXMLLOader=new FXMLLoader();

        FileInputStream fileStreamMainScreen;

        fileStreamMainScreen=new FileInputStream(new File("/home/rushikesh/IdeaProjects/the classical ishto/src/ishto/welcome_screen.fxml"));

        VBox mainScreenVBox;

        mainScreenVBox=(VBox) mainScreenFXMLLOader.load(fileStreamMainScreen);

        Scene mainScene = new Scene(mainScreenVBox);

        primaryStage.setHeight(2000);

        primaryStage.setWidth(2000);

        mainScn=mainScene;

        primaryStage.setScene(mainScene);

        primaryStage.show();

    }
}