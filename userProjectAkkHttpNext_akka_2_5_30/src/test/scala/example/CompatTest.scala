package example

import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class CompatTest extends AnyWordSpec with Matchers {
  "Accessing library compiled with older version" should {
    "work" in {
      try Test.http
      finally Test.system.terminate()
    }
  }
}
