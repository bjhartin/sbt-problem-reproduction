import CucumberSettings._

lazy val `test-project` = (project in file("."))
  .settings(
    organization := "com.myorg",
    CucumberSettings
      .settings(prettyReporter ++
        htmlReporter ++
        glueLocation("/steps") ++
        featuresLocation("src/cucumber/features")),
  )
