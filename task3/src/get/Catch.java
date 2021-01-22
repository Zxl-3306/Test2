package get;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Catch {
    public String getJsonByURL(String url){
        url=url.replaceAll(" ","%20");
        StringBuilder json = new StringBuilder();
        try {
            URL urlObject = new URL(url);
            URLConnection uc = urlObject.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
            String inputLine = null;
            while ( (inputLine = in.readLine()) != null) {
                json.append(inputLine);
            }
            in.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json.toString();
    }

    public static void main(String[] args) {
        Catch catchInfo=new Catch();
        String json=catchInfo.getJsonByURL("https://covid-api.mmediagroup.fr/v1/cases?country=United Kingdom");
        System.out.println(json);
    }
}
