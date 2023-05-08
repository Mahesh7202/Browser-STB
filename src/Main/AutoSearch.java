

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class AutoSearch {
    Document doc;
String st;
    AutoSearch(String searchterm){
        int num = 8;
        st = searchterm;
         String GOOGLE_SEARCH_URL = "https://www.google.com/search";


            String searchURL = GOOGLE_SEARCH_URL + "?q="+searchterm+"&num="+num;
          
        doc = null;
        try {
            doc = Jsoup.connect(searchURL).userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/94.0.4606.81 Safari/537.36").get();
        } catch (IOException e) {
            e.printStackTrace();
        }


           // Elements results = doc.select("h3.r > a");


        // againsearch(doc.select("input[value]"));





        //     for (Element result : results) {
        //         String linkHref = result.attr("href");
        //         String linkText = result.text();
        //        System.out.println("Text::" + linkText + ", URL::" + linkHref.substring(6, linkHref.indexOf("&")));
        //     }
        //
     }
     public void againsearch(Elements elements){
        for(Element result : elements){
            String str = result.attr("value");
              if(!str.equals(st)){
                new AutoSearch(str);
            }
        }
    }
 
    public String getDoc(){
        return doc.html();
    }
}

