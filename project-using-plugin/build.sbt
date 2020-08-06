import ProjectDependencies._
import cucumberSettings._

lazy val `sbt-problem-project-a` = (project in file("."))
  .settings(
    organization := "com.myorg",
    libraryDependencies ++= (Testing),
    cucumberSettings
      .settings(prettyReporter ++
        htmlReporter ++
        glueLocation("/steps") ++
        featuresLocation("src/cucumber/features")),
  )
