/*
  welcome screen class 
*/
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class MainScreen  extends Application {

    private int numberOfPlayers;
    
    public MainScreen() {
      //maximum number of player is 4.
      this.numberOfPlayers = 4;
      
    }
    
    int getPlayerNumber(){
        return this.numberOfPlayers;
    }
    
    public static void main(String[] args) throws Exception {
        Application.launch();
        
    }

    //start method is abstract method that should be overrided.
    //only argument is Stage object.
    // In our application, Stage object is named primaryStage object 
    //which is created by platform itself.
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Welcome Screen");
        
        primaryStage.setFullScreen(true);
        
        primaryStage.getIcons().add(new Image(MainScreen.class.getResourceAsStream("icon.png")));
        //here icon is temporary . proper design of icon required
        primaryStage.show();
        //show method make stage visible
    }

}
