public class googleMapsInteracter {

    // this will download an html page into a string builder and then return it to
    // the calling function as a string
    public static String getHTMLFromURL(URL url) {

        InputStream is = null;
        BufferedReader br;
        String line;

        StringBuilder sb = new StringBuilder(); // for storing the appended lines of html

        is = url.openStream(); // throws an IOException
        br = new BufferedReader(new InputStreamReader(is));

        while ((line = br.readLine()) != null) {
            sb.append(line + "\n");
        }

        return sb.toString();
    }

    public static double getDistanceFromAddress(address source, address destination) {
        // this will generate a URL download and parse it passing back the distance as a
        // double
        // 456+2nd+Ave+S,+Minneapolis,+MN+55401/123+Main+St+S,+Stillwater,+MN+55082
        String url = "https://www.google.com/maps/dir/";
        url += source.toString();
        url += "/";
        url += destination.toString();

        // get the html
        String html = getHTMLFromURL(url);
        // parse the html to get the miles value

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

        return Double.parseDouble(stringMiles);
    }
}