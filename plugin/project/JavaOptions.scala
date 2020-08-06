import sbt.Keys.{javaOptions, javacOptions, run}
import sbt.librarymanagement.syntax.Compile

object JavaOptions {
  lazy val settings = Seq(
    javaOptions in run ++= Seq("-encoding", "UTF-8"),
    javacOptions in Compile ++= Seq("-Xlint:unchecked", "-Xlint:deprecation")
  )
}
