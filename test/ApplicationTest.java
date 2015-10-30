import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.avaje.ebean.Ebean;
import com.fasterxml.jackson.databind.JsonNode;
import models.Locations;
import org.junit.*;

import play.Application;
import play.mvc.*;
import play.test.*;
import play.data.DynamicForm;
import play.data.validation.ValidationError;
import play.data.validation.Constraints.RequiredValidator;
import play.i18n.Lang;
import play.libs.F;
import play.libs.F.*;
import play.twirl.api.Content;

import static play.test.Helpers.*;
import static org.junit.Assert.*;


/**
*
* Simple (JUnit) tests that can call all parts of a play app.
* If you are interested in mocking a whole application, see the wiki for more details.
*
*/
public class ApplicationTest {

    private Application application;

    @Test
    public void simpleCheck() {
        int a = 1 + 1;
        assertEquals(2, a);
    }

    @Test
    public void renderTemplate() {
        Content html = views.html.index.render("Your new application is ready.");
        assertEquals("text/html", contentType(html));
        assertTrue(contentAsString(html).contains("Your new application is ready."));
    }

    @Before
    public void setup() {
        application = Helpers.fakeApplication();
        Helpers.start(application);
    }

    @Test
    public void mysqlInsertCheck() {

        int size = Locations.find.all().size();
        Locations loc = new Locations();
        loc.save();
        assert(Locations.find.all().size() - size == 1);
        Locations.find.ref("0").delete();
        assert(Locations.find.all().size() - size == 0);
   }

    @After
    public void teardown() {
        Helpers.stop(application);
    }

}
