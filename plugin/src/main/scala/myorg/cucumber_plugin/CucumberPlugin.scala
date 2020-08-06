package myorg.cucumber_plugin

import sbt.AutoPlugin

object SbtCorePlugin extends AutoPlugin {
  object autoImport {
    val cucumberSettings: CucumberSettings.type = CucumberSettings
  }
}
