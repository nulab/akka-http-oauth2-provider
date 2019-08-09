val akkaHttpVersion = "10.1.9"
val akkaVersion = "2.5.23"

val commonDependenciesInTestScope = Seq(
  "org.scalatest" %% "scalatest" % "3.0.8" % "test",
  "ch.qos.logback" % "logback-classic" % "1.2.3" % "test"
)

lazy val scalaOAuth2ProviderSettings =
  Defaults.coreDefaultSettings ++
    Seq(
      organization := "com.nulab-inc",
      scalaVersion := "2.13.0",
      crossScalaVersions := Seq("2.13.0","2.12.8", "2.11.12"),
      scalacOptions ++= Seq("-deprecation", "-unchecked", "-feature"),
      publishTo := {
        val v = version.value
        val nexus = "https://oss.sonatype.org/"
        if (v.trim.endsWith("SNAPSHOT")) Some("snapshots" at nexus + "content/repositories/snapshots")
        else Some("releases" at nexus + "service/local/staging/deploy/maven2")
      },
      publishMavenStyle := true,
      publishArtifact in Test := false,
      pomIncludeRepository := { x => false },
      pomExtra := <url>https://github.com/nulab/akka-http-oauth2-provider</url>
        <licenses>
          <license>
            <name>MIT License</name>
            <url>http://www.opensource.org/licenses/mit-license.php</url>
            <distribution>repo</distribution>
          </license>
        </licenses>
        <scm>
          <url>https://github.com/nulab/akka-http-oauth2-provider</url>
          <connection>scm:git:git@github.com:nulab/akka-http-oauth2-provider.git</connection>
        </scm>
        <developers>
          <developer>
            <id>tsuyoshizawa</id>
            <name>Tsuyoshi Yoshizawa</name>
            <url>https://github.com/tsuyoshizawa</url>
          </developer>
        </developers>
    )

lazy val root = (project in file("."))
  .settings(
    scalaOAuth2ProviderSettings,
    name := "akka-http-oauth2-provider",
    description := "Support scala-oauth2-core library on akka-http",
    version := "1.4.1-SNAPSHOT",
    libraryDependencies ++= Seq(
      "com.nulab-inc" %% "scala-oauth2-core" % "1.4.0" % "provided",
      "com.typesafe.akka" %% "akka-http-core" % akkaHttpVersion % "provided",
      "com.typesafe.akka" %% "akka-http" % akkaHttpVersion % "provided",
      "com.typesafe.akka" %% "akka-stream" % akkaVersion % "provided",
      "com.typesafe.akka" %% "akka-http-testkit" % akkaHttpVersion % "provided",
      "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion % "provided",
      "com.typesafe.akka" %% "akka-stream-testkit" % akkaVersion % "provided"
    ) ++ commonDependenciesInTestScope
  )
