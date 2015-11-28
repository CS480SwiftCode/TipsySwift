package models;

import com.avaje.ebean.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by jon-bassi on 10/29/15.
 */
@Entity
public class SwagZone extends Model {

    @Id @GeneratedValue
    long id;

    @Column(columnDefinition = "FLOAT(24)")
    float latitude;

    @Column(columnDefinition = "CHAR(1)")
    char n_s;

    @Column(columnDefinition = "FLOAT(24)")
    float longitude;

    @Column(columnDefinition = "CHAR(1)")
    char e_w;

}
