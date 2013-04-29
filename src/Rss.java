
import com.teamdev.jxbrowser.Browser;
import com.teamdev.jxbrowser.BrowserFactory;
import java.awt.BorderLayout;
import javax.swing.JFrame;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author BlackPearl
 */

    public class Rss {

    String username;
    public Rss() {
        Browser browser = BrowserFactory.createBrowser();
 
        JFrame frame = new JFrame();
        frame.add(browser.getComponent(), BorderLayout.CENTER);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
 
        
       // username="yogesh";
        browser.navigate("http://10.18.1.36/FarmManagement/site/rss.jsp");
    }
    
    
}
    

