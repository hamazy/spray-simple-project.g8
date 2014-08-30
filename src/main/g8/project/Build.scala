import sbt._
import Keys._

object BuildSettings {
  val buildSettings = Defaults.coreDefaultSettings ++ Seq(
    organization := "$package$",
    version := "$version$",
    scalaVersion := "2.10.3",
    scalacOptions ++= Seq("-deprecation", "-unchecked", "-feature", "-encoding", "utf8"),
    shellPrompt := { state => Project.extract(state).currentProject.id + " > " }
  )
}

object Dependencies {
  val akkaVersion = "2.3.0"
  val sprayVersion = "1.3.1"
  val sprayCan = "io.spray" % "spray-can" % sprayVersion
  val sprayRouting = "io.spray" % "spray-routing" % sprayVersion
  val sprayJson = "io.spray" %% "spray-json" % "1.2.6"
  val sprayTest = "io.spray" % "spray-testkit" % sprayVersion % "test"
  val akkaActor = "com.typesafe.akka" %% "akka-actor" % akkaVersion
  val akkaSlf4j = "com.typesafe.akka"   %%  "akka-slf4j" % akkaVersion
  val akkaTestkit = "com.typesafe.akka" %% "akka-testkit" % akkaVersion % "test"
  val scalaLogging = "com.typesafe" %% "scalalogging-slf4j" % "1.0.1"
  val logback = "ch.qos.logback" % "logback-classic" % "1.0.13"
  val scalatest = "org.scalatest" %% "scalatest" % "2.1.5" % "test"
  val pegdown = "org.pegdown" % "pegdown" % "1.0.1" % "test"
  val mockito = "org.mockito" % "mockito-core" % "1.9.5" % "test"

  val commonDeps = Seq(
    sprayCan,
    sprayRouting,
    sprayJson,
    sprayTest,
    akkaActor,
    akkaSlf4j,
    akkaTestkit,
    scalaLogging,
    logback,
    scalatest,
    pegdown,
    mockito
  )
}

object Resolvers {
  val sprayRepo = "spray repo" at "http://repo.spray.io/"

  val resolvers = Seq(sprayRepo)
}

object $name;format="Camel"$Build extends Build {

  import BuildSettings.buildSettings
  import Dependencies.commonDeps
  import spray.revolver.RevolverPlugin.Revolver
  import org.scalastyle.sbt.ScalastylePlugin.{Settings => ScalastyleSettings}
  import sbtassembly.Plugin.AssemblyKeys
  import sbtassembly.Plugin.assemblySettings
  import ScctPlugin.instrumentSettings

  lazy val root = Project("$name;format="normalize"$",
    file("."),
    settings = buildSettings ++
      instrumentSettings ++
      ScalastyleSettings ++
      assemblySettings ++
      Revolver.settings) settings (
    libraryDependencies ++= commonDeps,
        resolvers := Resolvers.resolvers,
        mainClass in AssemblyKeys.assembly := Some("$organization$.Boot"),
        testOptions in Test += Tests.Argument(TestFrameworks.ScalaTest, "-h", "target/report", "-u", "target/junitxml", "-o"))
}
