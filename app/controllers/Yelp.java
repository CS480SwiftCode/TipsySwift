package controllers;

import java.io.FileWriter;
import java.io.IOException;

public class Yelp
{

//    public static void main(String[] args) throws IOException
//    {
//        YelpAPI yelp = new YelpAPI();
//        Business[] b = yelp.returnEverythingWithinRadius(yelp, 34.1447199, -118.2586542, 10, 8046);
//
//        for (Business q : b)
//        {
//            System.out.println(q);
//        }

//		for (Business q : b)
//		{
//			System.out.println(q.getUrl());
//		}
//
//		generateCsvFile("test.csv", b);
//    }

    private static void generateCsvFile(String sFileName, Business[] businesses)
    {
        try
        {
            FileWriter writer = new FileWriter(sFileName);

            writer.append(
                    "Name, Address, City, State, ZipCode, CountryCode, URL, Phone, Rating, Latitude, Longitude, HappyHour \n");
            for (Business b : businesses)
            {
                writer.append(b.getName() + ", ");
                writer.append(b.getLocationAddress() + ", ");
                writer.append(b.getCity() + ", ");
                writer.append(b.getState() + ", ");
                writer.append(b.getZipCode() + ", ");
                writer.append(b.getCountryCode() + ", ");
                writer.append(b.getUrl() + ", ");
                writer.append(b.getPhone() + ", ");
                writer.append(b.getRating() + ", ");
                writer.append(b.getLatitude() + ", ");
                writer.append(b.getLongitude() + ", ");
                writer.append(b.getHappyHour() + "\n");

            }
            writer.flush();
            writer.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
