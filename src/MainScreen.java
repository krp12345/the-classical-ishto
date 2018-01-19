import java.io.File;
import java.io.FileInputStream;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import static javafx.scene.text.FontWeight.*;
public class MainScreen  extends Application {
    private Stage stg;
    public static void main(String[] args){launch(args);}
    @Override
    public void start(Stage primaryStage) throws Exception 
    {
        //BackgroundImage bg = new BackgroundImage(new Image("D:/The Classical Ishto/the-classical-ishto-master (1)/the-classical-ishto-master/src/main_bg.png"), NO_REPEAT, NO_REPEAT, CENTER, AUTO);
        Label titleLbl = new Label("The Classical Ishto");
        titleLbl.setFont(Font.font("Verdana", BOLD, 50.0));
        //Label midLbl = new Label("Wait, what are the - ");
        this.stg = primaryStage;
        FXMLLoader fldr = new FXMLLoader();
        Button playBtn = new Button("PLAY NOW!");
        FileInputStream fl = 
                new FileInputStream(new File("D:/The Classical Ishto/the-classical-ishto-master (1)/the-classical-ishto-master/src/welcome_screen.fxml"));
        // change path of fxml file. 
        
        VBox vb = (VBox)fldr.load(fl);
        //vb.getChildren().add(titleLbl);
        vb.getChildren().add(0, titleLbl);
        vb.getChildren().add(1, playBtn);
        //vb.getChildren().add(1, midLbl);
        Scene scn = new Scene(vb);
        primaryStage.setScene(scn);
        primaryStage.setTitle("The Classical Ishto");
        primaryStage.show();
    }
    private void test()
    {
        System.out.println("Working");
    }
}
