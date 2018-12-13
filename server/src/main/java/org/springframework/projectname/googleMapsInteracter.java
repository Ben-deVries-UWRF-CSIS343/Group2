package org.springframework.projectname;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class googleMapsInteracter implements IMapsInteractor {

    // this will download an html page into a string builder and then return it to
    // the calling function as a string
    private static String getHTMLFromURL(URL url) throws IOException {

        InputStream is = null;
        BufferedReader br;
        String line;

        StringBuilder sb = new StringBuilder(); // for storing the appended lines of HTML

        is = url.openStream(); // throws an IOException
        try {
            br = new BufferedReader(new InputStreamReader(is));
        } catch (Exception e) {
            // retry
            return getHTMLFromURL(url);
        }

        while ((line = br.readLine()) != null) {
            sb.append(line + "\n");
        }

        return sb.toString();
    }

    public double getDistanceFromAddress(Address source, Address destination) {
        double miles = 0;
        URL url = null;
        InputStream is = null;
        BufferedReader br;
        String html = "";
        String line;

        String strURL = "https://www.google.com/maps/dir/";
        strURL += source.toString();
        strURL += "/";
        strURL += destination.toString();

        // temp for testing
        // strURL="https://www.google.com/maps/dir/568+2nd+St+SW,+Britt,+IA/123+Main+St+S,+Stillwater,+MN+55082";
        try {
            int iter = 0;
            while (html.indexOf("mile") == -1) {

                url = new URL(strURL);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                String readStream = readStream(con.getInputStream());

                html = readStream;
                iter++;
                if (iter == 100) {
                    break;
                } else {
                    System.out.println("the iter is: " + iter);
                    System.out.println(strURL);
                }
            }

            // is = url.openStream(); // throws an IOException
            // br = new BufferedReader(new InputStreamReader(is));

            // while ((line = br.readLine()) != null) {
            // html += line + "\n";
            // }
        } catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if (is != null)
                    is.close();
            } catch (IOException ioe) {
                // nothing to see here
            }
        }

        // parse the HTML to get the miles value

        // the word 'miles' only exists 3 time in the file and we need the shortest
        // route so grab the first one
        int idx = html.indexOf("miles");
        // move left till we find a '>' char which is the last thing to the left of the
        // numerical miles value
        while (html.charAt(idx) != '"') {
            idx--;
        }
        idx++;

        String stringMiles = "";
        while (html.charAt(idx) != ' ') {
            stringMiles += html.charAt(idx);
            idx++;
        }

        miles = Double.parseDouble(stringMiles);
        return miles;
    }

    // this is the old one that was faulty
    private double getDistanceFromAddress2(Address source, Address destination) throws IOException {
        // this will generate a URL download and parse it passing back the distance as a
        // double
        // 456+2nd+Ave+S,+Minneapolis,+MN+55401/123+Main+St+S,+Stillwater,+MN+55082
        double miles = 0;
        String strURL = "https://www.google.com/maps/dir/";
        strURL += source.toString();
        strURL += "/";
        strURL += destination.toString();

        URL url = new URL(strURL);

        // get the HTML
        String html = getHTMLFromURL(url);
        // parse the HTML to get the miles value

        // the word 'miles' only exists 3 time in the file and we need the shortest
        // route so grab the first one
        int idx = html.indexOf("miles");
        // move left till we find a '>' char which is the last thing to the left of the
        // numerical miles value
        while (html.charAt(idx) != '"') {
            idx--;
        }
        idx++;

        String stringMiles = "";
        while (html.charAt(idx) != ' ') {
            stringMiles += html.charAt(idx);
            idx++;
        }

        miles = Double.parseDouble(stringMiles);
        return miles;
    }

    private static String readStream(InputStream in) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(in));) {
            String nextLine = "";
            while ((nextLine = reader.readLine()) != null) {
                sb.append(nextLine + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

}