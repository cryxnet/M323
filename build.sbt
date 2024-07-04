name := "NQueensSolver"

version := "0.1"

scalaVersion := "2.13.8"

// Library dependencies
libraryDependencies ++= Seq(
  "org.scala-lang" % "scala-library" % scalaVersion.value
)

lazy val root = (project in file("."))
  .settings(
    name := "NQueensSolver",
    version := "0.1",
    scalaVersion := "2.13.8"
  )

// To enable parallel collections if needed in the future
libraryDependencies += "org.scala-lang.modules" %% "scala-parallel-collections" % "1.0.4"
