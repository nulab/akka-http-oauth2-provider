# akka-http-oauth2-provider [![CI](https://github.com/nulab/akka-http-oauth2-provider/actions/workflows/ci.yml/badge.svg)](https://github.com/nulab/akka-http-oauth2-provider/actions/workflows/ci.yml)

This library is enabled using [scala-oauth2-provider](https://github.com/nulab/scala-oauth2-provider) in Akka HTTP.

## Setup

Add "akka-http-oauth2-provider" to library dependencies of your project.

```scala
libraryDependencies ++= Seq(
  "com.nulab-inc" %% "scala-oauth2-core" % "1.5.0",
  "com.nulab-inc" %% "akka-http-oauth2-provider" % "1.4.0"
)
```

Library version | Akka HTTP version
--------------- | ------------
1.4.0           | 10.1.x
1.3.0           | 2.4.x
