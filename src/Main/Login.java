

import javafx.application.Application;

import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.geometry.*;

import javafx.scene.shape.SVGPath;
import javafx.scene.layout.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import java.util.Map;
import java.util.Set;



public class Login extends Application {
    Label l1,l2;
    TextField user,pas;
    Button log,sin;
    AnchorPane top,bottom;
    VBox login;
    static String username ;
    Boolean retu = true;
    LinkedHashMap<String,String> m = new LinkedHashMap<String,String>();
    ArrayList<String> md = new ArrayList<String>();


    @Override
    public void start(Stage st){
       

        top = new AnchorPane();
        top.setPrefWidth(500);
        top.setPrefHeight(250);
        top.setStyle(
                "-fx-background-color:Blue;"
        );


        SVGPath image = new SVGPath();
        image.setContent("M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0zm4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4zm-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10z");
        Button imagebut = new Button();
        imagebut.setPrefHeight(130);
        imagebut.setPrefWidth(130);
        imagebut.setId("imagebut");
        

       l1 = new Label("Email Id");
       l2 = new Label("Password");
        
        user = new TextField();
        pas = new TextField();

        user.setPrefWidth(170);
        user.setMaxWidth(150);
        user.setMaxHeight(Region.USE_COMPUTED_SIZE);
        user.setPromptText("Email Id");
     
        pas.setPrefWidth(170);
        pas.setMaxWidth(150);
        pas.setMaxHeight(Region.USE_COMPUTED_SIZE);
        pas.setPromptText("Password");
    
        
        log = new Button("Log In");
        log.setAlignment(Pos.BOTTOM_CENTER);
       
        sin = new Button("Sing In");
        sin.setAlignment(Pos.BOTTOM_CENTER);

        login = new VBox();
        login.getStylesheets().add("Stylings/login.css");
        login.setPrefWidth(350);
        login.setPrefHeight(400);
        login.setLayoutX(70);
        login.setLayoutY(50);
        login.setAlignment(Pos.TOP_CENTER);
        login.getChildren().addAll(imagebut,l1,user,l2,pas,log,new Separator(),sin);
        login.setStyle("-fx-padding: 10;" +
               "-fx-background-color:white;"+
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-spacing:10;"+
                "-fx-border-color: white;");

 
        bottom = new AnchorPane(top,login);
        bottom.setStyle("-fx-background-color:grey;");

        Scene s = new Scene(bottom,500,500);

        log.setOnAction(ae->{
            Set<Map.Entry<String,String>> se = m.entrySet();
            setval(user.getText());
          
            for(Map.Entry<String, String> it: se)
            {
                if(user.getText().equals(it.getKey())){
                    if(pas.getText().equals(it.getValue())){   
                        new Tabs(st);
                        retu = true;
                    }
                }
                else{
                    retu = false;
                }
            }
            if(retu == false){
                showAlert(Alert.AlertType.WARNING, bottom.getScene().getWindow(), "Login Error!", "Check Your Email and Password Once again");
            }
            else{
                new Tabs(st);
                showAlert(Alert.AlertType.CONFIRMATION, bottom.getScene().getWindow(), "Login Sucessfull", "Login Sucessfull \n Welcome");
            }


        });
        sin.setOnAction(ae->{
            new Singup(st,s,m);
        });
           
      
        st.initStyle(StageStyle.UNDECORATED);
        st.setScene(s);
        st.show();

    }
    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(title);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
  
    }
    public static void setval(String str){
       username = str;
    }
    public static String getval(){
        return username;
    }

    public static void main(String[] args){
      launch(args);
    }

    
}
