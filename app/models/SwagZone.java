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

    public SwagZone(String coords)
    {
        coordinates = coords;
    }


    @Id @GeneratedValue
    long id;

    @Column(columnDefinition = "VARCHAR(255)", unique = true)
    String coordinates;

}
