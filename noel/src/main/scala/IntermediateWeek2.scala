import doodle.core._
import doodle.image._
import doodle.image.syntax._
import doodle.image.syntax.core._
import doodle.java2d._
import doodle.reactor._
import scala.concurrent.duration._
import scala.runtime.SymbolLiteral

object IntermediateWeek2 {
  // Question 1: A reasonable answer is that a class is a template for an
  // object. It allows us to create many objects that share some common
  // properties and share the same type.
  //
  // A constructor is called when an object is created from a class. It allows
  // us to make objects from the same class differ in some ways.

  // Question 2:
  //
  // This is the kind of information a Vet might be interested in
  import java.time.LocalDate
  final case class Pet(
      name: String,
      dateOfBirth: Date,
      species: String,
      breed: String
  )

  // Question 3 and 4:
  // See the mentor notes

  // Question 5
  //
  // This exericse is probably too complicated for our situation. We're trying
  // to geta little bit of practice extending a class but to get something
  // working you need to understand a lot of the details of Reactor. Anyway,
  // here is an example.
  object Orbits extends Reactor[Angle] {
    // Some images we'll use in drawing
    val planet = Image.circle(50).fillColor(Color.royalBlue).noStroke
    val firstMoon = Image.circle(25).fillColor(Color.steelBlue).noStroke
    val secondMoon = Image.circle(15).fillColor(Color.seagreen).noStroke

    // Start at 0 degrees
    val initial = 0.degrees

    // Increment angle by 5 degrees every tick
    def onTick(value: Angle): Angle =
      value + 5.degrees

    // Tick every 20 ms
    def tickRate = 20.millis

    // Draw something cool
    def render(value: Angle): Image = {
      val scene =
        secondMoon
          .at(150, value * 5)
          .on(firstMoon)
          .at(100, value * -3)
          .on(planet)
          .at(300, value)

      scene
    }

    // Don't stop (till you get enough)
    def stop(value: Angle): Boolean =
      false
  }


  // Question 6
  //
  // Algebraic data types are the main thing you should learn this week. An
  // algebraic data type is any data that can be described in terms of logical
  // ands and logical ors.

  // Question 7
  //
  // This is an algebraic data type, so just spam the pattern
  sealed trait Star
  final case class MainSequence() extends Star
  final case class RedGiant() extends Star
  final case class Supernova() extends Star
  final case class Neutron() extends Star


  // Question 9
  //
  // Another algebriac data type. Just another repetition of the pattern.
  sealed trait Expr
  final case class Literal(value: Double) extends Expr
  final case class Addition(left: Expr, right: Expr) extends Expr
  final case class Multiplication(left: Expr, right: Expr) extends Expr
}
