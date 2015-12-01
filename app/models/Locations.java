package models;

import com.avaje.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import controllers.Business;

/**
 * Created by jon-bassi on 10/29/15.
 */
@Entity
public class Locations extends Model {

    // testing constructor only, do not use in production code
    public Locations()
    {
        name = "0";
        yelp_url = "0";
        phone = "0";
        latitude = 0;
        longitude = 0;
        rating = 0;
        happy_hour_times = "0";
    }

    public Locations(Business b)
    {
        name = b.getName();
        yelp_url = b.getUrl();
        phone = b.getPhone();
        rating = b.getRating();
        happy_hour_times = b.getHappyHour();
        address = b.getLocationAddress();
        city = b.getCity();
        state = b.getState();
        zip_code = b.getZipCode();
        latitude = (float) b.getLatitude();
        longitude = (float) b.getLongitude();
    }

    @Id @GeneratedValue
    long id;

    @Column(columnDefinition = "VARCHAR(255)")
    String name;

    @Column(columnDefinition = "VARCHAR(255)", unique = true)
    String yelp_url;

    @Column(columnDefinition = "VARCHAR(255)")
    String address;

    @Column(columnDefinition = "VARCHAR(255)")
    String city;

    @Column(columnDefinition = "VARCHAR(255)")
    String state;

    @Column(columnDefinition = "VARCHAR(255)")
    String zip_code;

    @Column(columnDefinition = "VARCHAR(10)")
    String phone;

    @Column(columnDefinition = "FLOAT(24)")
    float latitude;

    @Column(columnDefinition = "FLOAT(24)")
    float longitude;

    @Column(columnDefinition = "INT(1)")
    double rating;

    @Column(columnDefinition = "BLOB NOT NULL")
    String happy_hour_times;

   public String getName()
   {
      return name;
   }

   public void setName(String name)
   {
      this.name = name;
   }

   public String getYelp_url()
   {
      return yelp_url;
   }

   public void setYelp_url(String yelp_url)
   {
      this.yelp_url = yelp_url;
   }

   public String getPhone()
   {
      return phone;
   }

   public void setPhone(String phone)
   {
      this.phone = phone;
   }

   public float getLatitude()
   {
      return latitude;
   }

   public void setLatitude(double latitude)
   {
      this.latitude = (long)latitude;
   }

   public float getLongitude()
   {
      return longitude;
   }

   public void setLongitude(double longitude)
   {
      this.longitude = (long)longitude;
   }

   public double getRating()
   {
      return rating;
   }

   public void setRating(double rating)
   {
      this.rating = rating;
   }

   public String getHappy_hour_times()
   {
      return happy_hour_times;
   }

   public void setHappy_hour_times(String happy_hour_times)
   {
      this.happy_hour_times = happy_hour_times;
   }

    /**
     * returns the latitude and longitude in correct format
     * @return
     */
    private String getLatLon()
    {
        return latitude + "," + longitude;
    }

    /**
     * "Name,Address,City,hh_times,ZipCode,CountryCode,URL,Phone,Rating,Latitude,Longitude"
     * @return
     */
    public String toString()
    {
        return name + "," + address + "," + city + "," + getHappy_hour_times() + "," + zip_code + "," + "," + yelp_url + "," + phone
                + "," + rating + "," + getLatLon();
    }
}
