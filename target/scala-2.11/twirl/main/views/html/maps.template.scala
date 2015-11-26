
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object maps_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._

class maps extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/()(content: Html):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.19*/("""

"""),format.raw/*3.1*/("""<!DOCTYPE html>
<html>
<link href="/assets/maps/mainController.css" rel="stylesheet" />
<h1>Find your pin of happy<h1>
    <body>
    <div ng-controller="mapController as dm">
        <form name="searchForm" novalidate
              ng-submit="search()">
            <div class="input-group">
                <input name="place" type="text" class="form-control"
                       ng-model="searchPlace" required autofocus />
            <span class="input-group-btn">
                <button class="btn btn-primary"
                        ng-disabled="searchForm.$invalid">Search</button>
            </span>
            </div>
        </form>
        <div id="map"></div>
</html>
<div>
    <action-menus>
        options="dm.pages">
    </action-menus>
</div>
</div>
</div>
</body>"""))
      }
    }
  }

  def render(content:Html): play.twirl.api.HtmlFormat.Appendable = apply()(content)

  def f:(() => (Html) => play.twirl.api.HtmlFormat.Appendable) = () => (content) => apply()(content)

  def ref: this.type = this

}


}

/**/
object maps extends maps_Scope0.maps
              /*
                  -- GENERATED --
                  DATE: Wed Nov 25 19:21:38 PST 2015
                  SOURCE: /Users/cfrancis/projects/TipsySwift/app/views/maps.scala.html
                  HASH: 64bdc5506729abae4a86b8af36976ae1804620d5
                  MATRIX: 741->1|853->18|881->20
                  LINES: 27->1|32->1|34->3
                  -- GENERATED --
              */
          