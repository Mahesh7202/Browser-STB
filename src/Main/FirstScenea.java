

import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.scene.input.MouseButton;
import javafx.scene.web.WebView;
import javafx.stage.Popup;
import javafx.scene.control.*;
import javafx.scene.layout.*;



public class FirstScenea {
   static ObservableList<Tab> tabs;
    static Tab tab;
    Popup p;
    static String s;
    ListView<String> l;
    static ActualScene[] as = new ActualScene[100];
    static Navigatorq[] bb = new Navigatorq[100];
    static int i;
    Button logo2;
    static boolean flag = false , flagi = false;
   FirstScenea(TabPane tabPane,BorderPane bp,int is){
     
        i=is;
     

       tab = new Tab("New Tab");
       tab.setTooltip(new Tooltip("New tab"));
       tabs = tabPane.getTabs();

       tab.closableProperty().bind(Bindings.size(tabs).greaterThan(2));
       tabs.add(tabs.size() - 1, tab);
       tabPane.getSelectionModel().select(tab);

      


        

        WebView webView = new WebView();

        
        
        webView.getEngine().titleProperty().addListener(new ChangeListener<String>()
        {
            public void changed(ObservableValue<? extends String> ov,
                                final String oldvalue, final String newvalue)
            {
                
                tabPane.getSelectionModel().getSelectedItem().setText(newvalue);
                tabPane.getSelectionModel().getSelectedItem().setTooltip(new Tooltip(newvalue));
            }
        });





        VBox vv = new VBox();

        bb[i] = new Navigatorq(webView,bp);

        as[i] = new ActualScene(webView,bp);



        vv.getChildren().addAll(bb[i]);

    
        VBox v= new VBox();
        v.getChildren().addAll(as[i]);

        
     
        l = new ListView<String>();
        
        l.setPrefWidth(100);
        l.setPrefHeight(80);
        l.getItems().add("Exit");
        p = new Popup();
        p.getContent().add(l);

       bp.setOnMouseClicked(event->{
           if(event.getButton() == MouseButton.SECONDARY){
                p.show(bp.getScene().getWindow());
           }
       });
       l.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
        @Override
        public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
            if(newValue == "Exit"){
                p.hide();
                Platform.exit();
           }
        }
    });
     

       
        
        bp.setTop(vv);
        bp.setCenter(v);
        tab.setContent(bp);
        if(flag){
            tabcolor();
        }
	if(flagi){
	    bgcolor(s);
	}
   
    }

    
    public static void tabcolor(){
      
        for(Tab tab:tabs){
            tab.styleProperty().bind(Bindings.when(tab.selectedProperty()).then("-fx-background-color:"+Customize.getThemeColor()+";").otherwise("-fx-background-color:"+Customize.getTabColor()+";"));
              
         }
         for(int j=0;j<=i;j++){
            bb[j].navigationchangecolor(Customize.getThemeColor());
         }
        flag = true;
    }

    public static void bgcolor(String str){
	s = str;
        for(int j=0;j<=i;j++){ 
            as[j].changebackground(str);
        }

	flagi = true;
    }

    
}




