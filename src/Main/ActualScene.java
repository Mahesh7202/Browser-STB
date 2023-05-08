
import javafx.geometry.Pos;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;

public class ActualScene extends VBox {
   
    HBox mainSearch = new HBox();
    Button search,customize;
    TextField searchbar;
    HBox butt;
    String[] a = {"https","http","www.",".com"};
    boolean flag = false;
    String ss = "#000000";

    ActualScene(WebView webView,BorderPane bp) {
     
        searchbar = new TextField();
        searchbar.setId("searchbarb");
        searchbar.setTooltip(new Tooltip("Search bar to search the content"));
        searchbar.setPrefWidth((Screen.getPrimary().getVisualBounds().getWidth())*2/4-10);
        searchbar.setPrefHeight(40);
        searchbar.setMaxWidth((Screen.getPrimary().getVisualBounds().getWidth())*2/4-10);
      
        searchbar.setMaxHeight(40);
        searchbar.setPromptText("search here...");
       


        

        search = new Button();

        search.setTooltip(new Tooltip("Search button"));

        search.setId("searchbut");
        search.setTooltip(new Tooltip("Search"));
        mainSearch.setHgrow(searchbar,Priority.ALWAYS);
        
        mainSearch.setMaxWidth((Screen.getPrimary().getVisualBounds().getWidth())*2/4);


        mainSearch.setStyle(
            "-fx-border-color:rgb(51, 127, 214);"+
            " -fx-background-color:rgba(252, 252, 252, 0.932);"+
             "-fx-border-radius:7em;"+
             "-fx-padding: 0 10 0 5;" +
             "-fx-background-radius:7em;"+
             "-fx-border-width:1.2;"
       
        
        );
        mainSearch.setAlignment(Pos.CENTER);
        mainSearch.getChildren().addAll(searchbar,search);


        this.getStylesheets().add("Stylings/actualscene.css");

        this.setAlignment(Pos.CENTER);

        this.getChildren().addAll(mainSearch);
        

        WebEngine webEngine = webView.getEngine();

        searchbar.setOnAction(ae -> {
            if(searchbar.getText() != null){ 
            for(String s:a) {
                if (searchbar.getText().contains(s)) {
                    webEngine.load(searchbar.getText());
                    flag = true;
                }
            }
            if(!flag){
                AutoSearch as = new AutoSearch(searchbar.getText());
                webEngine.loadContent(as.getDoc());}
            bp.setCenter(webView);
            }
            ae.consume();
        });
        search.setOnAction(ae -> {
            if(searchbar.getText() != null){
            for(String s:a) {
                if (searchbar.getText().contains(s)) {
                    webEngine.load(searchbar.getText());
                    flag = true;
                }
            }
            if(!flag){
                AutoSearch as = new AutoSearch(searchbar.getText());
                webEngine.loadContent(as.getDoc());}
            bp.setCenter(webView);
            }
            ae.consume();
            

        });

        this.setPrefWidth((Screen.getPrimary().getVisualBounds().getWidth()));
        this.setPrefHeight((Screen.getPrimary().getVisualBounds().getHeight()));


        SVGPath googlei = new SVGPath();
        googlei.setContent("M15.545 6.558a9.42 9.42 0 0 1 .139 1.626c0 2.434-.87 4.492-2.384 5.885h.002C11.978 15.292 10.158 16 8 16A8 8 0 1 1 8 0a7.689 7.689 0 0 1 5.352 2.082l-2.284 2.284A4.347 4.347 0 0 0 8 3.166c-2.087 0-3.86 1.408-4.492 3.304a4.792 4.792 0 0 0 0 3.063h.003c.635 1.893 2.405 3.301 4.492 3.301 1.078 0 2.004-.276 2.722-.764h-.003a3.702 3.702 0 0 0 1.599-2.431H8v-3.08h7.545z");
        googlei.setFill(Color.web(ss));

        SVGPath youtubei= new SVGPath();
        youtubei.setContent(" M8.051 1.999h.089c.822.003 4.987.033 6.11.335a2.01 2.01 0 0 1 1.415 1.42c.101.38.172.883.22 1.402l.01.104.022.26.008.104c.065.914.073 1.77.074 1.957v.075c-.001.194-.01 1.108-.082 2.06l-.008.105-.009.104c-.05.572-.124 1.14-.235 1.558a2.007 2.007 0 0 1-1.415 1.42c-1.16.312-5.569.334-6.18.335h-.142c-.309 0-1.587-.006-2.927-.052l-.17-.006-.087-.004-.171-.007-.171-.007c-1.11-.049-2.167-.128-2.654-.26a2.007 2.007 0 0 1-1.415-1.419c-.111-.417-.185-.986-.235-1.558L.09 9.82l-.008-.104A31.4 31.4 0 0 1 0 7.68v-.123c.002-.215.01-.958.064-1.778l.007-.103.003-.052.008-.104.022-.26.01-.104c.048-.519.119-1.023.22-1.402a2.007 2.007 0 0 1 1.415-1.42c.487-.13 1.544-.21 2.654-.26l.17-.007.172-.006.086-.003.171-.007A99.788 99.788 0 0 1 7.858 2h.193zM6.4 5.209v4.818l4.157-2.408L6.4 5.209z");
        youtubei.setFill(Color.web(ss));

        SVGPath twitteri= new SVGPath();
        twitteri.setContent("M5.026 15c6.038 0 9.341-5.003 9.341-9.334 0-.14 0-.282-.006-.422A6.685 6.685 0 0 0 16 3.542a6.658 6.658 0 0 1-1.889.518 3.301 3.301 0 0 0 1.447-1.817 6.533 6.533 0 0 1-2.087.793A3.286 3.286 0 0 0 7.875 6.03a9.325 9.325 0 0 1-6.767-3.429 3.289 3.289 0 0 0 1.018 4.382A3.323 3.323 0 0 1 .64 6.575v.045a3.288 3.288 0 0 0 2.632 3.218 3.203 3.203 0 0 1-.865.115 3.23 3.23 0 0 1-.614-.057 3.283 3.283 0 0 0 3.067 2.277A6.588 6.588 0 0 1 .78 13.58a6.32 6.32 0 0 1-.78-.045A9.344 9.344 0 0 0 5.026 15M5.026 15c6.038 0 9.341-5.003 9.341-9.334 0-.14 0-.282-.006-.422A6.685 6.685 0 0 0 16 3.542a6.658 6.658 0 0 1-1.889.518 3.301 3.301 0 0 0 1.447-1.817 6.533 6.533 0 0 1-2.087.793A3.286 3.286 0 0 0 7.875 6.03a9.325 9.325 0 0 1-6.767-3.429 3.289 3.289 0 0 0 1.018 4.382A3.323 3.323 0 0 1 .64 6.575v.045a3.288 3.288 0 0 0 2.632 3.218 3.203 3.203 0 0 1-.865.115 3.23 3.23 0 0 1-.614-.057 3.283 3.283 0 0 0 3.067 2.277A6.588 6.588 0 0 1 .78 13.58a6.32 6.32 0 0 1-.78-.045A9.344 9.344 0 0 0 5.026 15z");
        twitteri.setFill(Color.web(ss));

        Button google = new Button("Google",googlei);
        google.setTooltip(new Tooltip("Google Page"));
        Button twitter = new Button("Twitter",twitteri);
        twitter.setTooltip(new Tooltip("Twitter Page"));
        Button youtube = new Button("Youtube",youtubei);
        youtube.setTooltip(new Tooltip("Youtube Page"));

        google.setContentDisplay(ContentDisplay.TOP);
        youtube.setContentDisplay(ContentDisplay.TOP);
        twitter.setContentDisplay(ContentDisplay.TOP);
       
        butt = new HBox();
        butt.getChildren().addAll(google,youtube,twitter);
        butt.setAlignment(Pos.CENTER);
        butt.setSpacing(40);
        butt.getStylesheets().add("Stylings/customize.css");

                



        customize = new Button();
        customize.setTooltip(new Tooltip("Customize"));
        customize.setId("customize");
        customize.setAlignment(Pos.BASELINE_RIGHT);
       
        this.setSpacing(30);

        this.getChildren().addAll(butt,customize);
        this.getStylesheets().add("Stylings/customize.css");



        customize.setOnAction(ae->{
           new Customize();
        });

        google.setOnAction(ae->{
            webEngine.load("https://www.google.com/");
            bp.setCenter(webView);
         });

         youtube.setOnAction(ae->{
            webEngine.load("https://www.youtube.com/");
            bp.setCenter(webView);
         });

         twitter.setOnAction(ae->{
            webEngine.load("https://twitter.com/");
            bp.setCenter(webView);
         });



    }
   
    public void changebackground(String sttr){
        ss = sttr;
        this.setStyle("-fx-background-image: url('"+sttr+"');"+
        "-fx-background-repeat: no-repeat;"+
         "-fx-background-size: stretch;"+
         "-fx-background-position:center;");
       
    }
    



}

