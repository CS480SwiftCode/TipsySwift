package controllers;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.scribe.builder.ServiceBuilder;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.oauth.OAuthService;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class YelpAPI
{

    private static final String API_HOST = "api.yelp.com";
    // private static final String DEFAULT_TERM = "Happy Hour";
    private static final int SEARCH_LIMIT = 3;
    private static final String SEARCH_PATH = "/v2/search";
    private static final String BUSINESS_PATH = "/v2/business";

    private static final String CONSUMER_KEY;
    private static final String CONSUMER_SECRET;
    private static final String TOKEN;
    private static final String TOKEN_SECRET;

    static
    {
        try
        {
            File keys = new File("public/key.cfg");
            Properties prop = new Properties();
            prop.load(new FileReader(keys));
            CONSUMER_KEY = prop.getProperty("CKEY");
            CONSUMER_SECRET = prop.getProperty("CSECRET");
            TOKEN = prop.getProperty("TOKEN");
            TOKEN_SECRET = prop.getProperty("TOKENSECRET");
        } catch (Exception e)
        {
            e.printStackTrace();
            throw new RuntimeException("Init failed. Requires key.cfg.");
        }
    }

    OAuthService service;
    Token accessToken;

    public YelpAPI()
    {
        this.service = new ServiceBuilder().provider(TwoStepOAuth.class).apiKey(CONSUMER_KEY).apiSecret(CONSUMER_SECRET)
                                           .build();
        this.accessToken = new Token(TOKEN, TOKEN_SECRET);
    }

    public YelpAPI(String consumerKey, String consumerSecret, String token, String tokenSecret)
    {
        this.service = new ServiceBuilder().provider(TwoStepOAuth.class).apiKey(consumerKey).apiSecret(consumerSecret)
                                           .build();
        this.accessToken = new Token(token, tokenSecret);
    }

    private static JSONArray queryAPI(YelpAPI yelpApi, String term, String location, int limit)
    {
        String searchResponseJSON = yelpApi.searchForBusinessesByLocation(term, location, limit);

        JSONParser parser = new JSONParser();
        JSONObject response = null;
        try
        {
            response = (JSONObject) parser.parse(searchResponseJSON);
        } catch (ParseException pe)
        {
            System.out.println("Error: could not parse JSON response:");
            System.out.println(searchResponseJSON);
            System.exit(1);
        }

        JSONArray businesses = (JSONArray) response.get("businesses");
        return businesses;
    }

    private static JSONArray queryAPI(YelpAPI yelpApi, String term, String location, int limit, int radius)
    {
        String searchResponseJSON = yelpApi.searchForBusinessesByLocation(term, location, limit, radius);

        JSONParser parser = new JSONParser();
        JSONObject response = null;
        try
        {
            response = (JSONObject) parser.parse(searchResponseJSON);
        } catch (ParseException pe)
        {
            System.out.println("Error: could not parse JSON response:");
            System.out.println(searchResponseJSON);
            System.exit(1);
        }

        JSONArray businesses = (JSONArray) response.get("businesses");
        return businesses;
    }

    private static JSONArray queryAPI(YelpAPI yelpApi, double lat, double longi, int limit, int radius)
    {
        String searchResponseJSON = yelpApi.searchForBusinessesByLocation("Happy Hour", lat, longi, limit, radius);

        JSONParser parser = new JSONParser();
        JSONObject response = null;
        try
        {
            response = (JSONObject) parser.parse(searchResponseJSON);
        } catch (ParseException pe)
        {
            System.out.println("Error: could not parse JSON response:");
            System.out.println(searchResponseJSON);
            System.exit(1);
        }

        JSONArray businesses = (JSONArray) response.get("businesses");
        return businesses;
    }

    public String searchForBusinessesByLocation(String term, String location)
    {
        OAuthRequest request = createOAuthRequest(SEARCH_PATH);
        request.addQuerystringParameter("term", term);
        request.addQuerystringParameter("location", location);
        request.addQuerystringParameter("limit", String.valueOf(SEARCH_LIMIT));
        return sendRequestAndGetResponse(request);
    }

    public String searchForBusinessesByLocation(String term, String location, int limit)
    {
        OAuthRequest request = createOAuthRequest(SEARCH_PATH);
        request.addQuerystringParameter("term", term);
        request.addQuerystringParameter("location", location);
        request.addQuerystringParameter("limit", String.valueOf(limit));
        return sendRequestAndGetResponse(request);
    }

    public String searchForBusinessesByLocation(String term, String location, int limit, int radius)
    {
        OAuthRequest request = createOAuthRequest(SEARCH_PATH);
        request.addQuerystringParameter("term", term);
        request.addQuerystringParameter("location", location);
        request.addQuerystringParameter("limit", String.valueOf(limit));
        request.addQuerystringParameter("radius_filter", String.valueOf(radius));
        return sendRequestAndGetResponse(request);
    }

    public String searchForBusinessesByLocation(String term, double lat, double longi, int limit, int radius)
    {
        OAuthRequest request = createOAuthRequest(SEARCH_PATH);
        request.addQuerystringParameter("term", term);
        request.addQuerystringParameter("ll", lat + "," + longi);
        request.addQuerystringParameter("limit", String.valueOf(limit));
        request.addQuerystringParameter("radius_filter", String.valueOf(radius));
        return sendRequestAndGetResponse(request);
    }

    public String searchByBusinessId(String businessID)
    {
        OAuthRequest request = createOAuthRequest(BUSINESS_PATH + "/" + businessID);
        return sendRequestAndGetResponse(request);
    }

    private OAuthRequest createOAuthRequest(String path)
    {
        OAuthRequest request = new OAuthRequest(Verb.GET, "http://" + API_HOST + path);
        return request;
    }

    private String sendRequestAndGetResponse(OAuthRequest request)
    {
        System.out.println("Querying " + request.getCompleteUrl() + " ...");
        this.service.signRequest(this.accessToken, request);
        Response response = request.send();
        return response.getBody();
    }

    public JSONObject queryAPI(YelpAPI yelpApi, String term, String location)
    {
        String searchResponseJSON = yelpApi.searchForBusinessesByLocation(term, location);

        JSONParser parser = new JSONParser();
        JSONObject response = null;
        try
        {
            response = (JSONObject) parser.parse(searchResponseJSON);
        } catch (ParseException pe)
        {
            System.out.println("Error: could not parse JSON response:");
            System.out.println(searchResponseJSON);
            System.exit(1);
        }

        JSONArray businesses = (JSONArray) response.get("businesses");
        JSONObject firstBusiness = (JSONObject) businesses.get(0);
        String firstBusinessID = firstBusiness.get("id").toString();
        System.out.println(String.format("%s businesses found, querying business info for the top result \"%s\" ...",
                                         businesses.size(), firstBusinessID));

        // Select the first business and display business details
        String businessResponseJSON = yelpApi.searchByBusinessId(firstBusinessID.toString());
        System.out.println(String.format("Result for business \"%s\" found:", firstBusinessID));
        System.out.println(businessResponseJSON);
        return firstBusiness;
    }

    public Business[] returnBusinesses(YelpAPI yelp, String term, String location, int limit)
    {
        Business[] businesses = new Business[limit];
        JSONArray businessJSON = queryAPI(yelp, term, location, limit);

        return fillArray(businesses, businessJSON);
    }

    public Business[] returnBusinesses(YelpAPI yelp, String term, String location, int limit, int radius)
    {
        Business[] businesses = new Business[limit];
        JSONArray businessJSON = queryAPI(yelp, term, location, limit, radius);

        return fillArray(businesses, businessJSON);
    }

    public Business[] fillArray(Business[] businesses, JSONArray businessJSON)
    {
        for (int i = 0; i < businessJSON.size(); i++)
        {
            Business b = new Business();

            JSONObject obj = (JSONObject) businessJSON.get(i);
            JSONObject loc = (JSONObject) obj.get("location");
            JSONObject coord = (JSONObject) loc.get("coordinate");

            b.setName((String) obj.get("name"));
            try
            {
                b.setLocationAddress((String) ((JSONArray) (loc.get("address"))).get(0));
            } catch (Exception e)
            {
                // Rare case of no address. Will be set to null.
                System.out.println("Null address. Skipping.");
            }
            b.setCity((String) loc.get("city"));
            b.setState((String) loc.get("state_code"));
            b.setZipCode((String) loc.get("postal_code"));
            b.setCountryCode((String) loc.get("country_code"));
            b.setUrl((String) obj.get("url"));
            b.setPhone((String) obj.get("phone"));
            b.setRating((double) obj.get("rating"));
            b.setLatitude((double) coord.get("latitude"));
            b.setLongitude((double) coord.get("longitude"));

            businesses[i] = b;
        }
        return businesses;
    }

    public Business[] returnEverythingWithinRadius(YelpAPI yelp, double lat, double longi, int limit, int radius) throws
            IOException
    {
        Business[] businesses = new Business[limit];
        JSONArray businessJSON = queryAPI(yelp, lat, longi, limit, radius);
        fillArray(businesses, businessJSON);

        File cache = new File("businessCache");
        if (!cache.exists())
            cache.createNewFile();

        FileInputStream input = new FileInputStream("businessCache");
        for (Business q : businesses)
        {
            try
            {
                String url = q.getUrl();
                String busName = url.substring(24, url.length());

                // Check cache for current business. Skips if cached.
                FileChannel channel = input.getChannel();
                ByteBuffer bbuf = channel.map(FileChannel.MapMode.READ_ONLY, 0, (int) channel.size());
                CharBuffer cbuf = Charset.forName("8859_1").newDecoder().decode(bbuf);
                Pattern pattern = Pattern.compile(busName);
                Matcher matcher = pattern.matcher(cbuf);
                if (matcher.find())
                    continue;
                //
                ArrayList<String> reviews = null;
                try
                {
                    reviews = WebScraper.retrieveReviews(url);
                }
                catch (Exception e)
                {
                    reviews = new ArrayList<>();
                }
                // If can get reviews. Place in cache.
                if (reviews.size() > 0)
                {
                    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(cache, true)));
                    out.println(busName);

                    // Write reviews to cache. Can take this out in production.
                    for (String s : reviews)
                        out.println(s);
                    //
                    out.close();
                }
                //

                String happyHour = TextAnalyzer.analyze(reviews);
                q.setHappyHour(happyHour);
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        return businesses;
    }
}
