import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class client {

    public static void main(String[] args) throws IOException {
     try  (
           Socket s = new Socket("localhost",4999);
           OutputStreamWriter out = new OutputStreamWriter(s.getOutputStream());
           BufferedReader inReader = new BufferedReader(new InputStreamReader(s.getInputStream()));
          ) {
            //GET etc.
            //Remember \r\n because it marks the end of a line.
            //At the very end of the HTTP request we have to use \r\n\r\n as it ends the http request.
            }
     catch (Exception e) {
         System.err.println(e);
     }


    }

}
