package models;

import com.avaje.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by jon-bassi on 10/29/15.
 */
@Entity
public class Zipcodes  extends Model {

    @Id
    @Column(columnDefinition = "INT(5)")
    int zipcode;

    @Column(columnDefinition = "FLOAT(24)")
    float latitude;

    @Column(columnDefinition = "CHAR(1)")
    char n_s;

    @Column(columnDefinition = "FLOAT(24)")
    float longitude;

    @Column(columnDefinition = "CHAR(1)")
    char e_w;

}
