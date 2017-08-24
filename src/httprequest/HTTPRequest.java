package httprequest;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author T.Smit
 */
public class HTTPRequest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ServerConnect serverConn=null;
        try {
            serverConn = new ServerConnect("http://127.0.0.1/HTTPREQUEST/PARSEXMTest.php");
            if (serverConn.sendDataToServer("nummer1=zrhndtenmhtziusghforihjgv") == 200) {
                System.out.println(serverConn.getResponseFromServer());
            }
        } catch (IOException ex) {
            Logger.getLogger(HTTPRequest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(HTTPRequest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            if (serverConn.sendDataToServer("nummer1=huhu") == 200) {
                System.out.println(serverConn.getResponseFromServer());
            }
        } catch (IOException ex) {
            Logger.getLogger(HTTPRequest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(HTTPRequest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
