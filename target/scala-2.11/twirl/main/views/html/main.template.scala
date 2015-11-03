
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

class main extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[String,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(main : String)(content: Html):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.32*/("""


"""),format.raw/*4.1*/("""<!DOCTYPE html>
<html lang="en" ng-app="app">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>Tipsy Swift</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="/assets/bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" />
    <link href="/assets/maps/mainController.css" rel="stylesheet" />
    <link href="/assets/stylesheets/tipsySwift.css" rel="stylesheet" />


    <!-- Javascript dependencies -->
    <script type="text/javascript" src='/assets/bower_components/angular/angular.js'></script>
    <script type='text/javascript' src='/assets/bower_components/jquery/dist/jquery.min.js'></script>
    <script type='text/javascript' src='/assets/bower_components/bootstrap/dist/js/bootstrap.min.js'></script>
    <script src="/assets/bower_components/angular-ui/ui-bootstrap-tpls.min.js"></script>
    <script src="/assets/bower_components/angular-route/angular-route.min.js"></script>
    <script src="/assets/bower_components/lodash/dist/lodash.min.js"></script>
    <script type="text/javascript" src="/assets/bower_components/angular-cookies/angular-cookies.js"></script>
    <script type="text/javascript" src="/assets/bower_components/angular-sanitize/angular-sanitize.min.js"></script>
    <script type="text/javascript" src="/assets/bower_components/d3/d3.min.js"></script>
    <!--script src="https://maps.googleapis.com/maps/api/js&libraries=places"></script-->
    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js"></script>

    <script type="text/javascript" src='/assets/javascripts/mainPage.js'></script>
    <script type="text/javascript" src="/assets/javascripts/zipCodeController.js"></script>
    <script type="text/javascript" src="/assets/maps/mapController.js"></script>

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

  def render(main:String,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(main)(content)

  def f:((String) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (main) => (content) => apply(main)(content)

  def ref: this.type = this

}


}

/**/
object main extends main_Scope0.main
              /*
                  -- GENERATED --
                  DATE: Tue Nov 03 09:33:19 PST 2015
                  SOURCE: /Users/jon-bassi/Documents/javaworkspace/CS480SwiftCode/TipsySwift/app/views/main.scala.html
                  HASH: d443497b4d57d760230ddf757299b68935070f9e
                  MATRIX: 748->1|873->31|902->34
                  LINES: 27->1|32->1|35->4
                  -- GENERATED --
              */
          