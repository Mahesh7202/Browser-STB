
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.shape.SVGPath;
import javafx.scene.layout.*;
import javafx.scene.control.*;


public class Tabs{
  static String stri;
  static TabPane tabPane;
  static Tab newTab;
  static BorderPane[] bp = new BorderPane[100];
  static int i = 0;
  static boolean flagc = false,flagt = false,reset = false;;

    public Tabs(Stage stage){
       
        tabPane = new TabPane();


        newTab = new Tab();
        newTab.setTooltip(new Tooltip("Add New Tab"));
      



        tabPane.getTabs().add(newTab);

        
        SVGPath img = new SVGPath();
        img.setContent("M8 4a.5.5 0 0 1 .5.5v3h3a.5.5 0 0 1 0 1h-3v3a.5.5 0 0 1-1 0v-3h-3a.5.5 0 0 1 0-1h3v-3A.5.5 0 0 1 8 4z");
        newTab.setId("main");
        newTab.setGraphic(img);
      // newTab.setStyle("fx-normal-background-color:#101010; -fx-hovered-background-color:#aaaaaa;");
      
        bp[i] =  new BorderPane();
       
       new FirstScenea(tabPane,bp[i],i);
        i++;

        tabPane.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Tab>() {
            @Override
            public void changed(ObservableValue<? extends Tab> observable,
                                Tab oldSelectedTab, Tab newSelectedTab) {
                if (newSelectedTab == newTab) {
                    bp[i] = new BorderPane();
                    new FirstScenea(tabPane,bp[i],i);
                      i++;
                    if(flagc == true){
                      changebackgrondtheme();
                    }
                    if(flagt == true){
                      changebackgrondImage(stri);
                    }
                    if(reset == true){
                      resetbackgrondImage();
                    }
                  
                }
            }
        });
     

        tabPane.setPrefHeight(Screen.getPrimary().getVisualBounds().getHeight());
        tabPane.setPrefWidth(Screen.getPrimary().getVisualBounds().getWidth());
        tabPane.getStyleClass().add(TabPane.STYLE_CLASS_FLOATING);
        
            AnchorPane root = new AnchorPane();
          

            root.setId("topbackground");

            root.getChildren().addAll(tabPane);


               Scene s = new Scene(root, Screen.getPrimary().getVisualBounds().getWidth(), Screen.getPrimary().getVisualBounds().getHeight());



               tabPane.getStylesheets().add("Stylings/tabstyle.css");

            stage.setX(0);
            stage.setY(0);
            stage.setScene(s);
            stage.show();


        }
        public static void setTabcolor(){
            tabPane.setStyle("-fx-background-color:"+Customize.getTabColor()+";");
            newTab.setStyle("-fx-background-color:"+Customize.getTabColor()+";");
            FirstScenea.tabcolor();
        }

        
    public static void changebackgrondtheme(){
      for(int j=0;j<i;j++){
         bp[j].setStyle("-fx-background-color:"+Customize.getThemeColor()+";");
      }
      flagc = true;
      flagt = false;
      reset = false;
  }
  
 
  public static void changebackgrondImage(String str){
    stri = str;
         
    FirstScenea.bgcolor(str);

    flagt = true;
    flagc = false;
    reset = false;
  }
  public static void resetbackgrondImage(){
    for(int j=0;j<i;j++){              
      bp[j].setStyle("-fx-background-image: null;");
    }
    reset = true;
    flagt = false;
    changebackgrondtheme();
  }
}
