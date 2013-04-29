import com.teamdev.jxbrowser.Browser;
import com.teamdev.jxbrowser.BrowserFactory;
 
import javax.swing.*;
import java.awt.*;
 
/**
 * This sample demonstrates how to create JxBrowser instance,
 * how to add JxBrowser component to JFrame container,
 * how to navigate to web site www.google.com
 */
public class CancelNavigationSample {

    String username;
    public CancelNavigationSample() {
        Browser browser = BrowserFactory.createBrowser();
 
        JFrame frame = new JFrame();
        frame.add(browser.getComponent(), BorderLayout.CENTER);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
 
        username=Login.name;
       // username="yogesh";
        browser.navigate("http://10.18.1.36/FarmManagement/site/reports.jsp?username="+username);
    }
    
    
}