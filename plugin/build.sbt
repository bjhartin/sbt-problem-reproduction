import ProjectDependencies._


// Gives better compiler error info for some things - must be in this file.
addCompilerPlugin("io.tryp" % "splain" % splainV cross CrossVersion.patch)

lazy val `cucumber-plugin` = (project in file("."))
  .settings(
    organization := "myorg",
    sbtPlugin := true,  // Important, see SbtCorePlugin.scala
    ScalaSettings.settings,
    JavaOptions.settings,
    libraryDependencies ++= Seq(
      "io.cucumber" %% "cucumber-scala" % cucumberV
    )
  )
