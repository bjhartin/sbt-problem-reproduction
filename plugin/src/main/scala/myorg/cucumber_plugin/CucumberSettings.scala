package myorg.cucumber_plugin

import sbt._

object CucumberSettings {
  lazy val cucumber: InputKey[Unit] = inputKey[Unit]("Runs cucumber")

  def prettyReporter = List("--plugin", "pretty")
  def htmlReporter = List("--plugin", "html:target/test-reports/cucumber.html")
  def glueLocation(path: String) = List("--glue", path)
  def featuresLocation(path: String) = List(path)

  /*
    Accepts cucumber arguments which can be specified when invoking .settings(...) in your build, e.g.

    CucumberSettings.settings("--glue", "myorg/myproject/cucumber/steps", ".src/cucumber/features")

    They can also be specified when the task is invoked, e.g.

    cucumber --tags Foo
   */
  def settings(args: List[String] = List()): Def.Setting[InputTask[Unit]] = {
    Test / cucumber := {
      import sbt.complete.Parsers.spaceDelimited
      val userArgs = spaceDelimited("<args>").parsed
      CucumberRunner.run(args.toArray ++ userArgs)
    }
  }
}
