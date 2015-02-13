name := "GameEngine"

version := "1.0"

scalaVersion := "2.11.2"

resolvers += "Typesafe Repository" at
             "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.3.9"

libraryDependencies += "org.apache.commons" % "commons-math3" % "3.2"
