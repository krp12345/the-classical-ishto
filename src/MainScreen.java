import java.io.File;
import java.io.FileInputStream;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
public class MainScreen  extends Application {
    private Stage stg;
    @Override
    public void start(Stage primaryStage) throws Exception {
        this.stg=primaryStage;
        FXMLLoader fldr=new FXMLLoader();
        
        FileInputStream fl=new FileInputStream(new File("/home/rushikesh/NetBeansProjects/the classical ishto/src/welcome_screen.fxml"));
        // change path of fxml file. 
        
        VBox vb=(VBox)fldr.load(fl);
        Scene scn=new Scene(vb);
        primaryStage.setScene(scn);
        primaryStage.show();
    }
    private void onRuleButtonClickActions(){
        
    }
}
