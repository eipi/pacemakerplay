name := "pacemakerplay"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  javaWs,
  "net.sf.flexjson" % "flexjson" % "3.1",
  "postgresql" % "postgresql" % "9.1-901-1.jdbc4",
  "com.google.code.gson" % "gson" % "2.2"
)

