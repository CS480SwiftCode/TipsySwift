package models;

import com.avaje.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Map;

/**
 * Created by jon-bassi on 10/29/15.
 */
@Entity
public class Locations extends Model {

    @Id
    @Column(columnDefinition = "VARCHAR(64)")
    String hash;

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

}
