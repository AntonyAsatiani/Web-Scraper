import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.*;
/**
 * Created by user on 6/24/17.
 */
public class WebScrap {

    public static void main(String[] args) throws IOException {
         
       // String url = "";
      /*Read from file
      try
      {
          File file = new File("input.txt");
          FileReader fileReader = new FileReader(file);
          BufferedReader bufferedReader = new BufferedReader(fileReader);
          url = bufferedReader.readLine();
      }
      catch (IOException e)
      {
          e.printStackTrace();
      }

         */
       String url = "http://google.com";
       Document doc = Jsoup.connect(url).get();   // Connect to the web site
       Elements links = doc.select("a[href]");   // List of the links
       Elements img = doc.select("img[src]");       // List of the images


        //Iterate on image list
       for(Element src : img)
        {
          //Here display tagname, full path of the image, width and heigth
          print(" * <%s> %s %sx%s ",
               src.tagName(), src.attr("abs:src"), src.attr("width"), src.attr("height"));
        }
       //Iterate on links
       for(Element link : links)
       {
           print(" * a: <%s>  (%s)", link.attr("abs:href"), trim(link.text(), 35));
       }

    }
    // Method for printing data,first argument is text formating and second received data
    private static void print(String msg, Object... args)
    {
        System.out.println(String.format(msg, args));
    }
    private static String trim(String s, int width)
    {
        if (s.length() > width)
            return s.substring(0, width-1) + ".";
        else
            return s;
    }
}
