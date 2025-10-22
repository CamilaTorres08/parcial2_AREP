package edu.eci.arep.proxy;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController
public class ProxyController {
    int serverNumber = 0;
    String[] servers = new String[]{
            "http://ec2-98-88-119-196.compute-1.amazonaws.com:8080/",
            "http://ec2-54-81-9-20.compute-1.amazonaws.com:8080/"
    };

    private static final String USER_AGENT = "Mozilla/5.0";
    @GetMapping("/binarySearch")
    public ResponseEntity<?> binarySearch(@RequestParam int value, @RequestParam String list){
        try{
            return ResponseEntity.ok(manageServer(value,list));
        }catch(Exception ex){
            return ResponseEntity.status(500).body(ex.getMessage());
        }

    }

    @GetMapping("/linearSearch")
    public ResponseEntity<?> linearSearch(@RequestParam int value, @RequestParam String list){
        try{
            return ResponseEntity.ok(manageServer(value,list));
        }catch(Exception ex){
            return ResponseEntity.status(500).body(ex.getMessage());
        }
    }

    public String manageServer(int value, String list) throws Exception{
        try{
            String fullUrl = servers[serverNumber] + "binarySearch?value="+value+"&list="+list;
            return getRequest(fullUrl);
        }catch(IOException e){
            serverNumber = (serverNumber + 1) % 2;
            return manageServer(value, list);
        }
    }
    public String getRequest(String url) throws IOException, Exception {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);

        //The following invocation perform the connection implicitly before getting the code
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            System.out.println(response.toString());
            return response.toString();
        } else {
            throw new Exception("An error ocurred");
        }
    }

}
