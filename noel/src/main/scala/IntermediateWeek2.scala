import doodle.core._
import doodle.image._
import doodle.image.syntax._
import doodle.image.syntax.core._
import doodle.reactor._

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
  final case class Pet(name: String, dateOfBirth: Date, species: String, breed: String)
}
