
package javafxapp1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import javafx.stage.Stage;
/**
 *
 * @author user
 */
public class JavaFXApp1 extends Application {
   public static  String host;
   public static  String login;
   public static  String password;

    
    @Override
    public void start(Stage stage) throws Exception {
        Scene sceneOne = new Scene(FXMLLoader.load(getClass().getResource("FXML1.fxml")));
       // Scene sceneTwo = new Scene(FXMLLoader.load(getClass().getResource("FXML2.fxml")));
        stage.setScene(sceneOne);
        stage.setTitle("Telephoner");
        stage.getScene().getStylesheets().add("JMetroDarkTheme.css");
        stage.show();
               
        /*sceneOne.setOnMouseClicked(e -> {
            stage.setScene(sceneTwo);
        });
            sceneTwo.setOnMouseClicked(e -> {
            stage.setScene(sceneOne);
        });*/
    }
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        FileInputStream fis;
        Properties pr = new Properties();
        try {
            fis = new FileInputStream ("src/config.properties");
            pr.load(fis);
            host = pr.getProperty("db.host");
            login = pr.getProperty("db.login");
            password = pr.getProperty("db.password"); 
             
            System.out.println(host + " " + login + " " + password);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(JavaFXApp1.class.getName()).log(Level.SEVERE, null, ex);
        }

        launch(args);
    }
    
}
