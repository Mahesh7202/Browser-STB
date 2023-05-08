

import java.io.File;


import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import javafx.geometry.Bounds;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

import javafx.scene.shape.SVGPath;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Customize extends Stage{


   static String themeselectedcolor,tabcolor;

    BorderPane bp;
    FlowPane fp,defau,fp2;
    ColorPicker themecolor;
    int n=0;
    Boolean flag = false,flagr = true;
    String string;
    FlowPane topfortheme,topforimage;
    AnchorPane top;
    Button Customizebut;

    Button[] imgbut = new Button[100];

    Button[] colorbut = new Button[110];
   
    Button[] defaultbut = new Button[100];

    Color[] defaulttcolors = {Color.web("#f7f7f7"),Color.web("#cae0e4"),Color.web("#73d1d3"),
                                        Color.web("#a2131d"),Color.web("#f0e3e1"),Color.web("#f1cba0"),
                                        Color.web("#46546a"),Color.web("#20612d"),Color.web("#6c36b1"),
                                        Color.web("#f9bcd3"),Color.web("#56585d")};

    public Customize(){

        Button themebutton = new Button("Apply Theme");
        Button BackgroundButon = new Button("Apply");

        final FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.jpeg");
        fileChooser.getExtensionFilters().add(extFilter);

       



        Label dl = new Label("Customize your Browser with changing Theme Color and Background images");

        FlowPane d = new FlowPane();
        dl.setId("dl");
     
        d.setAlignment(Pos.CENTER);
        d.getChildren().add(dl);


        Label customizedtheme = new Label("Select the Custome Colors");

        for(int i=0;i<=10;i++){
            colorbut[i] = new Button();
            defaultbut[i] = new Button();
           
        }
        colorbut[1].setId("bb");
     

        topfortheme = new FlowPane();
        topfortheme.getChildren().addAll(themebutton);
        topfortheme.setPrefSize(1200, 30);
        topfortheme.setAlignment(Pos.CENTER_RIGHT);

     

        topforimage = new FlowPane();
        topforimage.getChildren().addAll(BackgroundButon);
        topforimage.setPrefSize(1200, 30);
        topforimage.setAlignment(Pos.CENTER_RIGHT);  

        top = new AnchorPane();
        Label l = new Label("Customize Apperance");
        l.setId("l");
        
        SVGPath lines = new SVGPath();
        lines.setContent("M2.5 12a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5zm0-4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5zm0-4a.5.5 0 0 1 .5-.5h10a.5.5 0 0 1 0 1H3a.5.5 0 0 1-.5-.5z");

        Button threelines = new Button("",lines);
        threelines.setId("threeline");

        l.setLayoutX(600);
        l.setLayoutY(15);

       threelines.setLayoutX(15);
       threelines.setLayoutY(10);


        top.getChildren().addAll(threelines,l);
        top.setPrefSize(1200,30);
      

        

      
        ListView<String> options = new ListView<>();
        options.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        options.setPrefSize(230, 300);
        options.setId("options");
        options.setStyle("-fx-background-color:transparent;"+"-fx-font-size:20px;"+"-fx-font-weight:300;"+"-fx-font-family: sans-serif;"+"-fx-font-fill:white;");
        options.getItems().addAll("Theme","Background");

        themecolor = new ColorPicker();
        themecolor.getStyleClass().add(ColorPicker.STYLE_CLASS_BUTTON);
        themecolor.setId("theme");
        themecolor.setPrefHeight(70);
        themecolor.setPrefWidth(120);

        Customizebut = new Button("Customize",themecolor);
        Customizebut.setId("Customizebut");
        Customizebut.setContentDisplay(ContentDisplay.TOP);

     

        fp = new FlowPane();
        
  
        fp.setVgap(25);
        fp.setHgap(25);
        fp.setPadding(new Insets(10));
       
        fp.getChildren().add(Customizebut);

        

        
      

         defau= new FlowPane();

        Label themelab = new Label("Theme");
        themelab.setId("themelab");

         SVGPath img = new SVGPath();
         img.setContent("M0 6a6 6 0 1 1 12 0A6 6 0 0 1 0 6zM12.93 5h1.57a.5.5 0 0 1 .5.5v9a.5.5 0 0 1-.5.5h-9a.5.5 0 0 1-.5-.5v-1.57a6.953 6.953 0 0 1-1-.22v1.79A1.5 1.5 0 0 0 5.5 16h9a1.5 1.5 0 0 0 1.5-1.5v-9A1.5 1.5 0 0 0 14.5 4h-1.79c.097.324.17.658.22 1z");
        
        
    
        Button la = new Button("",img);
        la.setPrefWidth(120);
        la.setPrefHeight(70);
        la.setAlignment(Pos.CENTER);
        la.setStyle("-fx-background-color:#7D7D7D;"+
        "-fx-padding:0;");


        Button b = new Button("color1",la);
        b.setStyle("-fx-focus-color:null;"+"-fx-background-color:gray;"+"-fx-border-radius:2;"+"-fx-text-fill:White;"+"-fx-font-style:bold;");
        b.setContentDisplay(ContentDisplay.TOP);

        defau.getChildren().add(b);
        defau.setVgap(25);
        defau.setHgap(25);
        
        defau.setPadding(new Insets(10));

        for(int i=0;i<11;i++){
            creteDefaultccolors(defaulttcolors[i],i);
        }





       VBox h = new VBox();
       h.setAlignment(Pos.CENTER);
       h.getChildren().addAll(themelab,defau,customizedtheme,fp);
       ScrollPane sp = new ScrollPane(h);
        fp.setStyle("-fx-border-color:transparent;");
        sp.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);    
        sp.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);    
        sp.viewportBoundsProperty().addListener(new ChangeListener<Bounds>()
        {
            @Override
            public void changed(ObservableValue<? extends Bounds> ov, Bounds oldBounds, Bounds bounds)
            {
                h.setPrefWidth(bounds.getWidth());
                h.setPrefHeight(bounds.getHeight());
            }
        });
    


      

       fp2 = new FlowPane();
       fp2.setAlignment(Pos.CENTER);
             
       ScrollPane sp2 = new ScrollPane(fp2);
       fp2.setStyle("-fx-border-color:transparent;");
       sp2.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);    
       sp2.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);    
       sp2.viewportBoundsProperty().addListener(new ChangeListener<Bounds>()
       {
           @Override
           public void changed(ObservableValue<? extends Bounds> ov, Bounds oldBounds, Bounds bounds)
           {
               fp2.setPrefWidth(bounds.getWidth());
               fp2.setPrefHeight(bounds.getHeight());
           }
       });
      

        SVGPath plus = new SVGPath();
        plus.setContent("M8 2a.5.5 0 0 1 .5.5v5h5a.5.5 0 0 1 0 1h-5v5a.5.5 0 0 1-1 0v-5h-5a.5.5 0 0 1 0-1h5v-5A.5.5 0 0 1 8 2Z");
        plus.setScaleX(3.5);
        plus.setScaleY(3.5);

        
        Button slect = new Button("",plus);
        slect.setContentDisplay(ContentDisplay.TOP);
        slect.setPrefSize(150, 150);
        slect.setStyle("-fx-background-color:transparent;");

        SVGPath images = new SVGPath();
        images.setContent("M6.002 5.5a1.5 1.5 0 1 1-3 0 1.5 1.5 0 0 1 3 0zM2.002 1a2 2 0 0 0-2 2v10a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V3a2 2 0 0 0-2-2h-12zm12 1a1 1 0 0 1 1 1v6.5l-3.777-1.947a.5.5 0 0 0-.577.093l-3.71 3.71-2.66-1.772a.5.5 0 0 0-.63.062L1.002 12V3a1 1 0 0 1 1-1h12z");
        images.setScaleY(4.8);
        images.setScaleX(5.8);
        Button imagebut = new Button("",images);
        imagebut.setPrefSize(150, 150);
        imagebut.setStyle("-fx-background-color:transparent;");
        
        


        fp2.getChildren().add(slect);
        fp2.setVgap(25);
        fp2.setHgap(25);
        fp2.setPadding(new Insets(10));
        fp2.getChildren().addAll(imagebut);

        for(int i=1;i<=28;i++){
            imgbut[i] = new Button();
            createimgbutton(i);
        }




        options.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if(newValue == "Background"){
                    bp.setCenter(sp2);
                 
                 l.setText("Select the Background Image");
                    bp.setBottom(topforimage);
   
               }
                 else if(newValue == "Theme"){
                    bp.setCenter(sp);
                    l.setText("Select the Theme color");
                    bp.setBottom(topfortheme);
               }
            }
        });


        bp = new BorderPane();

        bp.setTop(top);
        bp.setCenter(d);
        

        bp.setStyle("Stylings/style.css");
        top.getStylesheets().add("Stylings/style.css");
        topfortheme.getStylesheets().add("Stylings/style.css");
        topforimage.getStylesheets().add("Stylings/style.css");
        h.getStylesheets().add("Stylings/style.css");
        dl.getStylesheets().add("Stylings/style.css");
        fp2.getStylesheets().add("Stylings/style.css");

      


        themecolor.setOnAction(ae->{

            showcolors(themecolor.getValue());
           
     });
     

threelines.setOnAction(ae->{
  if(flagr){
    bp.setLeft(options);
    flagr = false;
  }else{
    bp.setLeft(null);
    flagr = true;
  }
});


    colorbut[0].setOnAction(ae->{
       setThemeColor(colorbut[0].getText());
       Tabs.changebackgrondtheme();
        Tabs.setTabcolor();
        
      
    });

     colorbut[1].setOnAction(ae->{
        setThemeColor(colorbut[1].getText());
       Tabs.changebackgrondtheme();
         Tabs.setTabcolor();
        
     });

     colorbut[2].setOnAction(ae->{
         setThemeColor(colorbut[2].getText());
        Tabs.changebackgrondtheme();
          Tabs.setTabcolor();
         
     });

     colorbut[3].setOnAction(ae->{
         setThemeColor(colorbut[3].getText());
        Tabs.changebackgrondtheme();
          Tabs.setTabcolor();
         
     });

     colorbut[4].setOnAction(ae->{
         
         setThemeColor(colorbut[4].getText());
        Tabs.changebackgrondtheme();
          Tabs.setTabcolor();
         
     });

     colorbut[5].setOnAction(ae->{
         
         setThemeColor(colorbut[5].getText());
        Tabs.changebackgrondtheme();
          Tabs.setTabcolor();
         
     });

     colorbut[6].setOnAction(ae->{
         
         setThemeColor(colorbut[6].getText());
         Tabs.changebackgrondtheme();
          Tabs.setTabcolor();
          
         
     });
     colorbut[7].setOnAction(ae->{
         
         setThemeColor(colorbut[7].getText());
        Tabs.changebackgrondtheme();
          Tabs.setTabcolor();
         
     });
     colorbut[8].setOnAction(ae->{
         
         setThemeColor(colorbut[8].getText());
        Tabs.changebackgrondtheme();
          Tabs.setTabcolor();
         
     });
     colorbut[9].setOnAction(ae->{
         
         setThemeColor(colorbut[9].getText());
        Tabs.changebackgrondtheme();
          Tabs.setTabcolor();
         
     });

     colorbut[10].setOnAction(ae->{
         
         setThemeColor(colorbut[10].getText());
        Tabs.changebackgrondtheme();
          Tabs.setTabcolor();
         
     });
    



     
    defaultbut[0].setOnAction(ae->{
         
        setThemeColor(defaultbut[0].getText());
       Tabs.changebackgrondtheme();
         Tabs.setTabcolor();
         
        
    });

    b.setOnAction(ae->{
        
      setThemeColor("gray");
      Tabs.changebackgrondtheme();
        Tabs.setTabcolor();
    });

   defaultbut[1].setOnAction(ae->{
       
       setThemeColor(defaultbut[1].getText());
      Tabs.changebackgrondtheme();
        Tabs.setTabcolor();
        
       
   });

   defaultbut[2].setOnAction(ae->{
       
       setThemeColor(defaultbut[2].getText());
      Tabs.changebackgrondtheme();
        Tabs.setTabcolor();
       
   });

   defaultbut[3].setOnAction(ae->{
       
       setThemeColor(defaultbut[3].getText());
      Tabs.changebackgrondtheme();
        Tabs.setTabcolor();
       
   });

   defaultbut[4].setOnAction(ae->{
       
       setThemeColor(defaultbut[4].getText());
      Tabs.changebackgrondtheme();
        Tabs.setTabcolor();
       
   });

   defaultbut[5].setOnAction(ae->{
       
       setThemeColor(defaultbut[5].getText());
      Tabs.changebackgrondtheme();
        Tabs.setTabcolor();
       
   });

   defaultbut[6].setOnAction(ae->{
       
       setThemeColor(defaultbut[6].getText());
      Tabs.changebackgrondtheme();
        Tabs.setTabcolor();
       
   });
   defaultbut[7].setOnAction(ae->{
       
       setThemeColor(defaultbut[7].getText());
      Tabs.changebackgrondtheme();
        Tabs.setTabcolor();
       
   });
   defaultbut[8].setOnAction(ae->{
       
       setThemeColor(defaultbut[8].getText());
      Tabs.changebackgrondtheme();
        Tabs.setTabcolor();
       
   });
   defaultbut[9].setOnAction(ae->{
       
       setThemeColor(defaultbut[9].getText());
      Tabs.changebackgrondtheme();
        Tabs.setTabcolor();
       
   });

   defaultbut[10].setOnAction(ae->{   
       setThemeColor(defaultbut[10].getText());
      Tabs.changebackgrondtheme();
        Tabs.setTabcolor();
       
   });
  


 imgbut[1].setOnAction(ae->{
   
  Tabs.changebackgrondImage(""+"background/background("+1+").jpg");
});

imgbut[2].setOnAction(ae->{
   
  Tabs.changebackgrondImage(""+"background/background("+2+").jpg");
});

imgbut[3].setOnAction(ae->{
   Tabs.changebackgrondImage(""+"background/background("+3+").jpg");
});

imgbut[4].setOnAction(ae->{


  Tabs.changebackgrondImage(""+"background/background("+4+").jpg");
});
imgbut[5].setOnAction(ae->{


  Tabs.changebackgrondImage(""+"background/background("+5+").jpg");
});
imgbut[6].setOnAction(ae->{


   Tabs.changebackgrondImage(""+"background/background("+6+").jpg");
});
imgbut[7].setOnAction(ae->{
   Tabs.changebackgrondImage(""+"background/background("+7+").jpg");
});
imgbut[8].setOnAction(ae->{
   
   Tabs.changebackgrondImage(""+"background/background("+8+").jpg");
});
imgbut[9].setOnAction(ae->{
   
   Tabs.changebackgrondImage(""+"background/background("+9+").jpg");
});
imgbut[10].setOnAction(ae->{
Tabs.changebackgrondImage(""+"background/background("+10+").jpg");

});

imgbut[11].setOnAction(ae->{
   Tabs.changebackgrondImage(""+"background/background("+11+").jpg");
 });
 
 imgbut[12].setOnAction(ae->{
    
   Tabs.changebackgrondImage(""+"background/background("+12+").jpg");
 });
 
 imgbut[13].setOnAction(ae->{
    
   Tabs.changebackgrondImage(""+"background/background("+13+").jpg");
 });
 
 imgbut[14].setOnAction(ae->{
    
   Tabs.changebackgrondImage(""+"background/background("+14+").jpg");
 });
 
 imgbut[15].setOnAction(ae->{
    
   Tabs.changebackgrondImage(""+"background/background("+15+").jpg");
 });
 
 imgbut[16].setOnAction(ae->{
    
    Tabs.changebackgrondImage(""+"background/background("+16+").jpg");
 });
 imgbut[17].setOnAction(ae->{
    Tabs.changebackgrondImage(""+"background/background("+17+").jpg");
 });
 imgbut[18].setOnAction(ae->{
    
    Tabs.changebackgrondImage(""+"background/background("+18+").jpg");
 });
 imgbut[19].setOnAction(ae->{
    
    Tabs.changebackgrondImage(""+"background/background("+19+").jpg");
 });
 
 imgbut[20].setOnAction(ae->{
    Tabs.changebackgrondImage(""+"background/background("+20+").jpg");
 });
 
 imgbut[21].setOnAction(ae->{
   
   Tabs.changebackgrondImage(""+"background/background("+21+").jpg");
 });
 
 imgbut[22].setOnAction(ae->{
    
   Tabs.changebackgrondImage(""+"background/background("+22+").jpg");
 });
 
 imgbut[23].setOnAction(ae->{
    
   Tabs.changebackgrondImage(""+"background/background("+23+").jpg");
 });
 
 imgbut[24].setOnAction(ae->{
    
   Tabs.changebackgrondImage(""+"background/background("+24+").jpg");
 });
 
 imgbut[25].setOnAction(ae->{
    
   Tabs.changebackgrondImage(""+"background/background("+25+").jpg");
 });
 
 imgbut[26].setOnAction(ae->{
    
    Tabs.changebackgrondImage(""+"background/background("+26+").jpg");
 });
 imgbut[27].setOnAction(ae->{
    Tabs.changebackgrondImage(""+"background/background("+27+").jpg");
 });
 imgbut[28].setOnAction(ae->{
    
    Tabs.changebackgrondImage(""+"background/background("+28+").jpg");
 });



  slect.setOnAction(ae->{
    File file = fileChooser.showOpenDialog(this);
    if(file!=null){
       Tabs.changebackgrondImage(file.toURI().toString());
    }
 });
  imagebut.setOnAction(ae->{
    Tabs.resetbackgrondImage();
    this.close();
  });

  themebutton.setOnAction(ae->{
    FirstScenea.tabcolor();
    this.close();
  });
  BackgroundButon.setOnAction(ae->{
    this.close();
  });

     Scene s = new Scene(bp,1200,600);

    
     this.initStyle(StageStyle.TRANSPARENT);
     bp.setStyle("-fx-border-color:black;"+"-fx-border-width:2px;");
     this.setScene(s);
     this.show();


        

}

public void showcolors(Color c){
    if(n>10){
        n = 0;
       flag = true;
    }
       if(n<=10){
        Button l = new Button("");
        l.setPrefWidth(120);
        l.setPrefHeight(70);
        l.setAlignment(Pos.TOP_LEFT);
        l.setStyle("-fx-background-color:linear-gradient(to top ,"+toHexString(c)+" 70%,"+toHexString(c.darker())+" 30%);"+
        "-fx-padding:0;");


        colorbut[n].setText(""+toHexString(c));
        colorbut[n].setGraphic(l);
        
        colorbut[n].setStyle("-fx-focus-color:null;"+"-fx-background-color:black;"+"-fx-border-radius:2;"+"-fx-text-fill:White;");
        colorbut[n].setContentDisplay(ContentDisplay.TOP);
        if(!flag){
        fp.getChildren().addAll(colorbut[n]);
        }
        n++;
            
    }
  

}

public void creteDefaultccolors(Color c,int k){

    Button ll = new Button("");
    ll.setPrefWidth(120);
    ll.setPrefHeight(70);
    ll.setAlignment(Pos.TOP_LEFT);
    ll.setStyle("-fx-background-color:linear-gradient(to top ,"+toHexString(c)+" 70%,"+toHexString(c.darker())+" 30%);"+
    "-fx-padding:0;");


    defaultbut[k].setText(""+toHexString(c));
    defaultbut[k].setGraphic(ll);

    defaultbut[k].setStyle("-fx-focus-color:null;"+"-fx-background-color:black;"+"-fx-border-radius:2;"+"-fx-text-fill:White;");
    defaultbut[k].setContentDisplay(ContentDisplay.TOP);

    defau.getChildren().add(defaultbut[k]);

}


public void setThemeColor(String str){
    themeselectedcolor = str;
}  

public static String getThemeColor(){
    return themeselectedcolor;
}
public static String getTabColor(){
    Color ca = Color.web(themeselectedcolor);
    tabcolor = String.valueOf(toHexString(ca.darker()));
    return tabcolor;
}
   

private static String toHexString(Color color) {
    int r = ((int) Math.round(color.getRed()     * 255)) << 24;
    int g = ((int) Math.round(color.getGreen()   * 255)) << 16;
    int b = ((int) Math.round(color.getBlue()    * 255)) << 8;
    int a = ((int) Math.round(color.getOpacity() * 255));

    return String.format("#%08X", (r + g + b + a));
  }


public void createimgbutton(int i){
    String str = ""+"background/background("+i+").jpg";
    Image oi = new Image(str,150,150,false,true);

    ImageView iv = new ImageView(oi);


    imgbut[i].setGraphic(iv);
    imgbut[i].setStyle("-fx-background-color:transparent;");
    fp2.getChildren().add(imgbut[i]);
}
}
