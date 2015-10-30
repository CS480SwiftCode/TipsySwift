package models;

import com.avaje.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by jon-bassi on 10/29/15.
 */
@Entity
public class Locations extends Model {

    // testing constructor only, do not use in production code
    public Locations()
    {
        hash = "0";
        name = "0";
        yelp_url = "0";
        phone = "0";
        latitude = 0;
        n_s = 'n';
        longitude = 0;
        e_w = 'w';
        rating = 0;
        hours_of_op = "0";
        happy_hour_times = "0";
    }

    @Id
    @Column(columnDefinition = "VARCHAR(64)")
    public String hash;

    @Column(columnDefinition = "VARCHAR(255)")
    String name;

    @Column(columnDefinition = "VARCHAR(255)")
    String yelp_url;

    @Column(columnDefinition = "VARCHAR(10)")
    String phone;

    @Column(columnDefinition = "FLOAT(24)")
    float latitude;

    @Column(columnDefinition = "CHAR(1)")
    char n_s;

    @Column(columnDefinition = "FLOAT(24)")
    float longitude;

    @Column(columnDefinition = "CHAR(1)")
    char e_w;

    @Column(columnDefinition = "INT(1)")
    int rating;

    @Column(columnDefinition = "BLOB NOT NULL")
    String hours_of_op;

    @Column(columnDefinition = "BLOB NOT NULL")
    String happy_hour_times;

    public static Finder<String,Locations> find = new Finder<>(Locations.class);

   public String getHash()
   {
      return hash;
   }

   public void setHash(String hash)
   {
      this.hash = hash;
   }

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

   public void setLatitude(float latitude)
   {
      this.latitude = latitude;
   }

   public char getN_s()
   {
      return n_s;
   }

   public void setN_s(char n_s)
   {
      this.n_s = n_s;
   }

   public float getLongitude()
   {
      return longitude;
   }

   public void setLongitude(float longitude)
   {
      this.longitude = longitude;
   }

   public char getE_w()
   {
      return e_w;
   }

   public void setE_w(char e_w)
   {
      this.e_w = e_w;
   }

   public int getRating()
   {
      return rating;
   }

   public void setRating(int rating)
   {
      this.rating = rating;
   }

   public String getHours_of_op()
   {
      return hours_of_op;
   }

   public void setHours_of_op(String hours_of_op)
   {
      this.hours_of_op = hours_of_op;
   }

   public String getHappy_hour_times()
   {
      return happy_hour_times;
   }

   public void setHappy_hour_times(String happy_hour_times)
   {
      this.happy_hour_times = happy_hour_times;
   }
}
