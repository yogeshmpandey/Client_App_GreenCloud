import com.teamdev.jxbrowser.Browser;
import com.teamdev.jxbrowser.BrowserFactory;
 
import javax.swing.*;
import java.awt.*;
 
/**
 * This sample demonstrates how to create JxBrowser instance,
 * how to add JxBrowser component to JFrame container,
 * how to navigate to web site www.google.com
 */
public class Geolocate {

    String username;
    public Geolocate() {
        Browser browser = BrowserFactory.createBrowser();
 
        JFrame frame = new JFrame();
        frame.add(browser.getComponent(), BorderLayout.CENTER);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
 
        
       // username="yogesh";
       // browser.navigate("http://localhost/FarmManagement/site/geolocate.jsp");
    }
    
    
}