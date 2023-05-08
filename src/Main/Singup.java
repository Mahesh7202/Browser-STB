
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.geometry.*;

import javafx.scene.paint.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.layout.*;
import java.util.LinkedHashMap;



public class Singup{

    Label l1,l2;
    TextField t1,t2;
    Button sb;
    boolean flag = true;
    GridPane gridPane;
    TextField nf,ef,fist,last;
    Label errorname,errorlname,errormail,errorpas,errorpasre;
    PasswordField pf;
  


    AnchorPane top,bottom;
    VBox login;
    Singup(Stage st, Scene bot,LinkedHashMap<String,String> m){
      

        top = new AnchorPane();
        top.setPrefWidth(500);
        top.setPrefHeight(250);
        top.setStyle(
                "-fx-background-color:Blue;"
        );

         gridPane = new GridPane();

        
        gridPane.setAlignment(Pos.CENTER);

        
        gridPane.setPadding(new Insets(40, 40, 40, 40));

       
        gridPane.setHgap(10);

       
        gridPane.setVgap(10);

       
        ColumnConstraints cc1 = new ColumnConstraints(100, 100, Double.MAX_VALUE);
        cc1.setHalignment(HPos.RIGHT);

        
        ColumnConstraints cc2 = new ColumnConstraints(200,200, Double.MAX_VALUE);
        cc2.setHgrow(Priority.ALWAYS);

     



        Label hl1 = new Label("Sign In");
        hl1.setId("s");
        hl1.setFont(Font.font("Arial", FontWeight.BOLD, 24));

        gridPane.add(hl1, 0,0,2,1);
        GridPane.setHalignment(hl1, HPos.CENTER);
        GridPane.setMargin(hl1, new Insets(20, 0,20,0));



        Label firstname = new Label("First Name");
        gridPane.add(firstname,0,1);

        Label lastname = new Label("Last Name");
        gridPane.add(lastname,1,1);

        fist = new TextField();
        fist.setPrefHeight(50);
        fist.setPromptText("First Name");
        gridPane.add(fist, 0, 2);

        last = new TextField();
        last.setPrefHeight(50);
        last.setPromptText("Last Name");
        gridPane.add(last, 1, 2);

        errorname = new Label();
        errorname.setId("e1");
        errorlname = new Label();
        errorlname.setId("e2");
     


        Label nl1 = new Label("Emial");
        gridPane.add(nl1, 0, 4);

       
        nf = new TextField();
        nf.setPrefHeight(50);
        nf.setPromptText("example@gmail.com");
        gridPane.add(nf, 1, 4);

        errormail = new Label();
        errormail.setId("e3");
      
       

        
        Label el1 = new Label("password");
        gridPane.add(el1, 0, 6);

       
        ef = new TextField();
        ef.setPrefHeight(50);
        ef.setPromptText("Create Password");
        gridPane.add(ef, 1, 6);

         errorpas = new Label();
         errorpas.setId("e4");
     
        
        Label pl = new Label("re-enter password");
        gridPane.add(pl, 0, 8);

      
        pf = new PasswordField();
        pf.setPrefHeight(50);
        pf.setPromptText("Confirm Password");
        gridPane.add(pf, 1, 8);

        
        errorpasre = new Label();
        errorpasre.setId("e5");
      

        sb = new Button("Submit");
        sb.setPrefHeight(50);
        sb.setDefaultButton(true);
        sb.setPrefWidth(100);
        gridPane.add(sb, 0, 10, 2, 10);
        GridPane.setHalignment(sb, HPos.CENTER);
        GridPane.setMargin(sb, new Insets(20, 0,20,0));




        login = new VBox();
        login.getStylesheets().add("Stylings/login.css");
        login.setPrefWidth(350);
        login.setPrefHeight(400);
        login.setLayoutX(70);
        login.setLayoutY(50);
        login.setAlignment(Pos.TOP_CENTER);
        login.getChildren().addAll(gridPane);
        login.setStyle("-fx-padding: 10;" +
               "-fx-background-color:white;"+
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-spacing:10;"+
                "-fx-border-color: white;");

     

        bottom = new AnchorPane(top,login);

        Scene s = new Scene(bottom,500,500);
        st.setScene(s);
        st.show();
      

        sb.setOnAction((ae)-> {

        if(flag){

            if(fist.getText().isEmpty()){
                errorname.setText("Enter First Name");
                errorname.setFont(Font.font("arial",FontWeight.BOLD,10));
                errorname.setTextFill(Color.RED);
                gridPane.add(errorname,0,3);
            }

           if(last.getText().isEmpty()){
                errorlname.setText("Enter Last Name");
                errorlname.setFont(Font.font("arial",FontWeight.BOLD,10));
                errorlname.setTextFill(Color.RED);
                gridPane.add(errorlname,1,3);
            }
            if(nf.getText().isEmpty()){
                errormail.setFont(Font.font("arial",FontWeight.BOLD,10));
                errormail.setText("Enter Email id");
                errormail.setTextFill(Color.RED);
                gridPane.add(errormail,1,5);}
            
            if(ef.getText().isEmpty()){
                errorpas.setText("Enter Password");
                errorpas.setFont(Font.font("arial",FontWeight.BOLD,10));
                errorpas.setTextFill(Color.RED);
                gridPane.add(errorpas,1,7);
            }
            
            if(pf.getText().isEmpty()){
                errorpasre.setText("Re-Enter your Password");
                errorpasre.setFont(Font.font("arial",FontWeight.BOLD,10));
                errorpasre.setTextFill(Color.RED);
                gridPane.add(errorpasre,1,9);
            }
            if(!(ef.getText().equals(pf.getText()))){
                errorpasre.setText("Enter Same Password");
                errorpasre.setFont(Font.font("arial",FontWeight.BOLD,10));
                errorpasre.setTextFill(Color.RED);
            }else if(!(fist.getText().isEmpty()^last.getText().isEmpty()^nf.getText().isEmpty()^pf.getText().isEmpty()^ef.getText().isEmpty())){
                m.put(ef.getText(),nf.getText());
                st.setScene(bot);
                st.show();
                showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "Signup Successful!", "Singup Sucessfully Completed \n " + fist.getText()+"  "+last.getText());
                
            }
        }
       
       });
               

            bottom.setStyle("-fx-background-color:grey;");

            
                
         
  
  
        
    
    
}

   

    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(title);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
        
        
      
       
    }
 


}
