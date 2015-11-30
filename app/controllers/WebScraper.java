package controllers;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;

public class WebScraper
{
    public static ArrayList<String> retrieveReviews(String url) throws IOException
    {
        ArrayList<String> formattedReviews = new ArrayList<>();

        for (int i = 0; i < 100; i += 20)
        {
            // Gets up to 100 reviews.
            Document doc = Jsoup.connect(url + "?start=" + i + "&q=happy+hour").timeout(60000)
                                .maxBodySize(10 * 1024 * 1024).get();
            String[] reviews = doc.select("p[itemprop]").toString().split("\n");
            if (reviews.length <= 1)
                break;

            for (String s : reviews)
            {
                s = s.substring(36, s.length() - 4);
                s = s.replace("<br />", "");
                s = s.toLowerCase();
                formattedReviews.add(s);
            }
        }
        return formattedReviews;
    }
}
