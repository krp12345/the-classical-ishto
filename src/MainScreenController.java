package ishto;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainScreenController {
    public final Scene rules;
    public final Scene playNowScene;
    public MainScreenController() throws  IOException {
        System.out.println("constructed");

        FXMLLoader nofp=new FXMLLoader();

        File f2=null;

        try{
            f2=new File("/home/rushikesh/IdeaProjects/the classical ishto/src/ishto/number_of_players.fxml");
        }

        catch (Exception e){
            System.out.println("error in file opening");
            e.printStackTrace();
        }

        FileInputStream finp=null;

        try{
            finp=new FileInputStream(f2);

        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
        }

        VBox vb2=null;
        try {

            vb2 = nofp.load(finp);

        }
        catch (IOException e){
            System.out.println("IOException occured");
        }

        Scene scn=new Scene(vb2);
        this.playNowScene=scn;

        FXMLLoader fxm;
        fxm=new FXMLLoader();
        File f=new File("/home/rushikesh/IdeaProjects/the classical ishto/src/ishto/rules_description.fxml");
        FileInputStream finsl;
        finsl=new FileInputStream(f);
        VBox vb=(VBox)fxm.load(finsl);
        int sz=vb.getChildren().size();
        int i;
        for(i=0;i<sz;i++){
            Node temp=vb.getChildren().get(i);
            if(temp instanceof WebView){
                System.out.println("found object");
                File ftm = new File("/home/rushikesh/IdeaProjects/the classical ishto/src/ishto/rules.html");
                WebEngine webeng=((WebView) temp).getEngine();
                webeng.load(ftm.toURI().toString());
            }
        }
        rules=new Scene(vb);
    }

    @FXML
    private void onRulesButtonClickedAction(){
        ApplicationStarter.prStage.setScene(rules);
    }
    @FXML
    private void onplayNowButtonClickAction(){
        ApplicationStarter.prStage.setScene(playNowScene);
    }
}