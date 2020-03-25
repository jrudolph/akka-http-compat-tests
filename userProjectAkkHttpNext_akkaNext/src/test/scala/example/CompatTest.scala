package example

import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.http.scaladsl.Http
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class CompatTest extends AnyWordSpec with Matchers {
  "Accessing library compiled with older version" should {
    "work" in {
      try Test.http
      finally Test.system.terminate()
    }
  }
  "Using Akka HTTP seemlessly with Akka 2.6" should {
    "work" in {
      implicit val typedSystem = ActorSystem(Behaviors.empty, "test")
      try Http()
      finally typedSystem.terminate()
    }
  }
}
