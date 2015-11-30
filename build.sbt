name := """TipsySwift"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs,
  "junit" % "junit" % "4.11",
  "junit" % "junit" % "4.11" % "test",
  "mysql" % "mysql-connector-java" % "5.1.35",
  "org.scribe" % "scribe" % "1.3.5",
  "org.jsoup" % "jsoup" % "1.7.2",
  "com.googlecode.json-simple" % "json-simple" % "1.1",
  "com.beust" % "jcommander" % "1.48"

)

// Play provides two styles of routers, one expects its actions to be injected, the
// other, legacy style, accesses its actions statically.
routesGenerator := InjectedRoutesGenerator
