package example

import akka.actor.ActorSystem
import akka.http.scaladsl.Http

object Test {
  implicit val system = ActorSystem()
  val http = Http()
}
