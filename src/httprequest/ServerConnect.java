package httprequest;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author T.Smit
 */
public class ServerConnect {

    private HttpURLConnection httpConn = null;
    private String openURL;

    public ServerConnect(String openurl) throws MalformedURLException, IOException {
        this.openURL = openurl;
    }

    private void setURLConnection() throws MalformedURLException, IOException {
        URL url = new URL(this.openURL);
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        this.httpConn = httpConn;
    }

    private void setURLDisconnection() {
        this.httpConn.disconnect();
        this.httpConn = null;
    }

    public int sendDataToServer(String data) throws Exception {
        this.setURLConnection();
        OutputStream os;
        this.httpConn.setDoOutput(true);
        os = this.httpConn.getOutputStream();
        try (BufferedWriter osw = new BufferedWriter(new OutputStreamWriter(os))) {
            osw.write(data);
            osw.flush();
        }
        int httpResponse = this.httpConn.getResponseCode();
        return httpResponse;
    }

    public String getResponseFromServer() throws MalformedURLException, IOException {
        String returnString = null;
        StringBuffer sb = null;
        BufferedInputStream in;
        in = new BufferedInputStream(this.httpConn.getInputStream());
        int x = 0;
        sb = new StringBuffer();
        while ((x = in.read()) != -1) {
            sb.append((char) x);
        }
        in.close();
        in = null;
        this.setURLDisconnection();
        returnString = sb.toString();
        return returnString;
    }

}
