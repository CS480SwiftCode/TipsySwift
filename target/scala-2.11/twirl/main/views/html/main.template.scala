
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object main_Scope0 {
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

class main extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/()(content: Html):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.19*/("""


"""),format.raw/*4.1*/("""<!DOCTYPE html>
<html lang="en" ng-app="app">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>Login Tests</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="/assets/bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" />
    <link href="/assets/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet" />


    <!-- Javascript dependencies -->
    <script type="text/javascript" src='/assets/bower_components/angular/angular.js'></script>
    <script type="text/javascript" src="/assets/bower_components/papaparse/papaparse.min.js"></script>
    <script type='text/javascript' src='/assets/bower_components/jquery/dist/jquery.min.js'></script>
    <script type='text/javascript' src='/assets/bower_components/bootstrap/dist/js/bootstrap.min.js'></script>
    <script src="/assets/bower_components/angular-ui/ui-bootstrap-tpls.min.js"></script>
    <script src="/assets/bower_components/angular-route/angular-route.min.js"></script>
    <script src="/assets/bower_components/lodash/dist/lodash.min.js"></script>
    <script type="text/javascript" src="/assets/bower_components/angular-cookies/angular-cookies.js"></script>
    <script type="text/javascript" src="/assets/bower_components/angular-sanitize/angular-sanitize.min.js"></script>
    <script type="text/javascript" src="/assets/bower_components/d3/d3.min.js"></script>
    <script type="text/javascript" src="/assets/bower_components/lodash/dist/lodash.min.js"></script>
    <script type="text/javascript" src="/assets/bower_components/angularjs-dropdown-multiselect/dist/angularjs-dropdown-multiselect.min.js"></script>
    <script type="text/javascript" src="/assets/bower_components/angular-cookies/angular-cookies.min.js"></script>
    <script type="text/javascript" src="http://maps.googleapis.com/maps/api/js?libraries=places&sensor=false"></script>
    <script type="text/javascript" src='/assets/javascripts/mainPage.js'></script>
    <script type="text/javascript" src="/assets/javascripts/zipCodeController.js"></script>
    <script type="text/javascript" src="/assets/maps/mapController.js"></script>
    <script type="text/javascript" src="/assets/tables/tableController.js"></script>
    <script type="text/javascript" src="/assets/forms/formController.js"></script>

</head>

<body class="container-fluid">
<div id="main">
    <div ng-view></div>
</div>

</body>
</html>
"""))
      }
    }
  }

  def render(content:Html): play.twirl.api.HtmlFormat.Appendable = apply()(content)

  def f:(() => (Html) => play.twirl.api.HtmlFormat.Appendable) = () => (content) => apply()(content)

  def ref: this.type = this

}


}

/**/
object main extends main_Scope0.main
              /*
                  -- GENERATED --
                  DATE: Wed Nov 25 19:21:38 PST 2015
                  SOURCE: /Users/cfrancis/projects/TipsySwift/app/views/main.scala.html
                  HASH: 134587b54f4ca89ebe55558b0a2bcc10de31f1e9
                  MATRIX: 741->1|853->18|882->21
                  LINES: 27->1|32->1|35->4
                  -- GENERATED --
              */
          