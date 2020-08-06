import sbt.Keys.{scalaVersion, scalacOptions}

object ScalaSettings {
  lazy val settings = Seq(
    scalaVersion := "2.12.8",
    scalacOptions := Seq(
    "-target:jvm-1.8",
    "-encoding",
    "UTF-8",
    "-unchecked",
    "-deprecation",
    "-Xfuture",
    "-Yno-adapted-args",
    "-Ywarn-dead-code",
    "-Ywarn-numeric-widen",
    "-Ywarn-value-discard",
    "-Ywarn-unused",
    "-Ywarn-unused-import",
    "-feature",
    "-language:postfixOps",
    "-language:implicitConversions",
    "-Xlint:missing-interpolator",
    "-Xfatal-warnings",
    "-Ypartial-unification",
    "-language:experimental.macros",
    "-language:higherKinds"
  ))
}
