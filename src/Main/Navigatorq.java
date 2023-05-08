

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.*;

import javafx.scene.layout.*;
import javafx.scene.shape.SVGPath;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebHistory;
import javafx.scene.web.WebView;
import javafx.stage.Screen;
import javafx.stage.StageStyle;
import javafx.stage.Window;


public class Navigatorq extends HBox {


   
    boolean flag = false;
    String[] a = {"https","http","www.",".com"};

    Navigatorq(WebView webView, BorderPane bp) {

        HBox search = new HBox();
        
        TextField topsearchbar;
        Button back, forward, refresh,login, home;
        Button searchbut,logo;
        HBox leftside, rightside;
        

        searchbut = new Button();
        searchbut.setId("searchbut");
        searchbut.setTooltip(new Tooltip("Search"));


       
        logo = new Button("");
        
       
        logo.setId("logo");

        
        topsearchbar = new TextField();
        topsearchbar.setId("tophbar");
        topsearchbar.setTooltip(new Tooltip("Search bar to search the content"));
        topsearchbar.setPrefWidth((Screen.getPrimary().getVisualBounds().getWidth())*3/4-10);
        topsearchbar.setPrefHeight(16);
        topsearchbar.setMaxWidth((Screen.getPrimary().getVisualBounds().getWidth())*3/4);
        
        topsearchbar.setMaxHeight(Region.USE_COMPUTED_SIZE);
        topsearchbar.setPromptText("Search here...");
        
        search.getHgrow(topsearchbar);
        
        search.setAlignment(Pos.CENTER);
        search.setPrefHeight(15);
        search.setPrefWidth((Screen.getPrimary().getVisualBounds().getWidth())*3/4);
        search.setStyle(
            "-fx-spacing:5px;"+
            "-fx-padding: 0 10 0 10;"+
            " -fx-background-color:rgba(252, 252, 252, 0.932);"+
            "-fx-background-radius:7em;"+
            "-fx-border-radius:7em;"+
            "-fx-border-color:rgb(51, 127, 214);"+
            "-fx-border-width:1.2;"
        );
        search.getChildren().addAll(logo,new Separator(Orientation.VERTICAL),topsearchbar,new Separator(Orientation.VERTICAL),searchbut);


        back = new Button("");
        back.setDisable(true);
        forward = new Button("");
        forward.setDisable(true);
        refresh = new Button("");

        back.setId("backbut");
        forward.setId("forwardbut");
        refresh.setId("refreshbut");



        back.setTooltip(new Tooltip("back button to go previous page"));
        forward.setTooltip(new Tooltip("forward button to go next page"));
        refresh.setTooltip(new Tooltip("reload the current page"));


        BrowserHistory bh = new BrowserHistory(webView, back, forward);

        leftside = new HBox();

        leftside.setAlignment(Pos.CENTER_LEFT);
        leftside.setStyle("-fx-spacing:5;"+
        "-fx-padding:5px;");
        

        HBox.setHgrow(leftside, Priority.ALWAYS);

        leftside.getChildren().addAll(back,forward,refresh,search,bh);


        login = new Button("");
        login.setId("loginbut");

        login.setTooltip(new Tooltip("login"));



        home = new Button("");
        home.setId("homebut");

        home.setTooltip(new Tooltip("home goes to home page"));

        rightside = new HBox();
        rightside.setStyle(
            "-fx-spacing:9;"+
            "-fx-padding:5px;"
        );
        

        rightside.getChildren().addAll(login, home);

        rightside.setAlignment(Pos.CENTER_RIGHT);

        HBox.setHgrow(rightside, Priority.ALWAYS);

        this.getChildren().addAll(leftside, rightside);
        this.getStylesheets().add("Stylings/navigation.css");
        this.setWidth(Screen.getPrimary().getVisualBounds().getWidth());
        this.setHeight(10);
        this.setStyle("-fx-spacing:10px");

        WebMenu webmenu = new WebMenu(webView);
        rightside.getChildren().add(webmenu);



        
        WebEngine webEngine = webView.getEngine();

        
        WebHistory history = webView.getEngine().getHistory();

        webEngine.locationProperty().addListener(new ChangeListener<String>()
        {
            public void changed(ObservableValue<? extends String> ov,
                                final String oldvalue, final String newvalue)
            {
                
                topsearchbar.setText(newvalue);
            }
        });
        
     
        topsearchbar.setOnAction(ae-> {
            if(topsearchbar.getText() != null){
            AutoSearch as = new AutoSearch(topsearchbar.getText());
            for(String s:a) {
                if (topsearchbar.getText().contains(s)) {
                    webEngine.load(topsearchbar.getText());
                    flag = true;
                }
            }
            if(!flag)
                webEngine.loadContent(as.getDoc());
            bp.setCenter(webView);
            ae.consume();
        }

        });

        refresh.setOnAction(ae->{
                webEngine.reload();
             ae.consume();
        });


        home.setOnAction(ae->{
            ActualScene aa = new ActualScene(webView,bp);
            bp.setCenter(aa);
            ae.consume();
        });

        searchbut.setOnAction(ae->{
            if(topsearchbar.getText() != null){
                AutoSearch as = new AutoSearch(topsearchbar.getText());
                for(String s:a) {
                   if (topsearchbar.getText().contains(s)) {
                              webEngine.load(topsearchbar.getText());
                              flag = true;
                     }
                }   
                if(!flag)
                   webEngine.loadContent(as.getDoc());
                bp.setCenter(webView);
            }
            ae.consume();


        });

        login.setOnAction(ae->{

                String str = Login.getval();
                showAlert(Alert.AlertType.INFORMATION, this.getScene().getWindow(), "Personal Information", str+"\n Welcome to the browser.");
        

        });

       

       
    }
  

    public void navigationchangecolor(String sttr){
        this.setStyle("-fx-background-color:"+sttr+";");
    }


    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setHeaderText(title);
        alert.setContentText(message);
        alert.initOwner(owner);
        SVGPath image = new SVGPath();
        image.setContent("M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0zm4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4zm-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10z");
        Button imagebut = new Button();
        imagebut.setStyle("-fx-background-color:transparent;");
        imagebut.setPrefHeight(130);
        imagebut.setPrefWidth(130);
        image.setScaleX(9);
        image.setScaleY(9);
        imagebut.setGraphic(image);
        imagebut.setStyle("-fx-background-color:transparent;");
        alert.getDialogPane().setGraphic(imagebut);
        alert.show();
        alert.initStyle(StageStyle.UNDECORATED);
       
      
    }
}


