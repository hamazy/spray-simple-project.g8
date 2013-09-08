import sbt._
import Keys._

object BuildSettings {
  val buildSettings = Defaults.defaultSettings ++ Seq(
    organization := "$package$",
    version := "1.0-SNAPSHOT",
    scalaVersion := "2.10.2",
    scalacOptions ++= Seq("-deprecation", "-unchecked", "-feature", "-encoding", "utf8")
  )
}

object Dependencies {
  val sprayCan = "io.spray"            %   "spray-can"         % "1.2-M8"
  val sprayRouting = "io.spray"            %   "spray-routing"     % "1.2-M8"
  val sprayTest = "io.spray"            %   "spray-testkit"     % "1.2-M8" % "test"
  val akkaActor = "com.typesafe.akka"   %%  "akka-actor"        % "2.2.0-RC1"
  val akkaTestkit = "com.typesafe.akka"   %%  "akka-testkit"      % "2.2.0-RC1" % "test"
  val scalaLogging = "com.typesafe"        %% "scalalogging-slf4j" % "1.0.1"
  val scalatest = "org.scalatest"       %% "scalatest"          % "1.9.1" % "test"
  val mockito = "org.mockito"         % "mockito-core"        % "1.9.5" % "test"

val commonDeps = Seq(
    sprayCan,
    sprayRouting,
    sprayTest,
    akkaActor,
    akkaTestkit,
    scalaLogging,
    scalatest,
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

  lazy val root = Project("$name;format="normalize"$", 
			  file("."),
			  settings = buildSettings ++
				Seq(libraryDependencies ++= commonDeps,
				    resolvers := Resolvers.resolvers) ++ Revolver.settings)
}
