import io.cucumber.core.options.{CommandlineOptionsParser, RuntimeOptions}
import io.cucumber.core.runtime.Runtime
import scala.util.control.NoStackTrace

/*
  This allows us to run the cucumber tests from SBT.

  We were using the cucumber-sbt plugin but it uses an older version of
  cucumber which caused some problems.
 */
object CucumberRunner {
  // This exception overrides toString and uses NoStackTrace so as to integrate nicely with SBT's logger.
  // When tests fail, we don't want to see a big stack trace or full class name - we just want to see the toString output.
  case object CucumberTestsFailedException extends RuntimeException with NoStackTrace {
    override def toString: String = "Cucumber Tests failed"
  }

  def run(args: Array[String]): Unit = {
    val parser = new CommandlineOptionsParser(System.out)
    val opts = parser.parse(args: _*).build()
    val runtime = buildRuntime(opts)
    runtime.run()

    if (runtime.exitStatus().toInt != 0) {
      throw CucumberTestsFailedException
    }
  }

  private def buildRuntime(opts: RuntimeOptions) = {
    Runtime
      .builder()
      .withRuntimeOptions(opts)
      .build()
  }
}
