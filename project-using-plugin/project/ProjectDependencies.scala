import sbt._

object ProjectDependencies {
  val CucumberV = "6.2.2"

  val Testing = Seq(
    "io.cucumber" %% "cucumber-scala" % CucumberV % "it,test"
  )
}
