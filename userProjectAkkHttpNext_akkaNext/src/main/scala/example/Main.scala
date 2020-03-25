package example

import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.http.scaladsl.Http

object Main extends App {
  Test.http
  Test.system.terminate()

  implicit val typedSystem = ActorSystem(Behaviors.empty, "test")
  val http = Http()
  typedSystem.terminate()
}
