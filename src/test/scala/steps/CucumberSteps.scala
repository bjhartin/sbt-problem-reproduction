package steps

import io.cucumber.scala.{EN, ScalaDsl, Scenario}

class CucumberSteps extends ScalaDsl with EN {
  Given("The service is running") { () =>
    ()
  }

  Given("""A request arrives""") { () =>
    ()
  }

  When("""A response is sent""") { () =>
    ()
  }
}
