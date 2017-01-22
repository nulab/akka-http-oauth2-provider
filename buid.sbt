val akkaVersion = "2.4.7"
val commonDependenciesInTestScope = Seq(
  "org.scalatest" %% "scalatest" % "3.0.1" % "test",
  "ch.qos.logback" % "logback-classic" % "1.1.8" % "test"
)

lazy val scalaOAuth2ProviderSettings =
  Defaults.coreDefaultSettings ++
    scalariformSettings ++
    Seq(
      organization := "com.nulab-inc",
      scalaVersion := "2.11.8",
      crossScalaVersions := Seq("2.11.8"),
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
    )

lazy val root = Project(
  id = "akka-http-oauth2-provider",
  base = file("."),
  settings = scalaOAuth2ProviderSettings ++ Seq(
    name := "akka-http-oauth2-provider",
    description := "Support scala-oauth2-core library on akka-http",
    version := "1.2.1-SNAPSHOT",
    resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/maven-releases/",
    libraryDependencies ++= Seq(
      "com.nulab-inc" % "scala-oauth2-core_2.11" % "1.2.0" % "provided",
      "com.typesafe.akka" %% "akka-http-experimental" % akkaVersion,
      "com.typesafe.akka" %% "akka-http-core" % akkaVersion,
      "com.typesafe.akka" %% "akka-http-testkit" % akkaVersion,
      "com.typesafe.akka" %% "akka-http-spray-json-experimental" % akkaVersion,
      "com.typesafe.akka" %% "akka-actor" % akkaVersion
    ) ++ commonDependenciesInTestScope
  )
)
