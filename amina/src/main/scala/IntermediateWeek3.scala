
// Week 3 - Lower Intermediate lesson questions courtesy of Scott Cutts

// Here is the pre-class reading:
// https://github.com/scalabridgelondon/lesson-plans/blob/master/intermediate/questions/week-3.md

// Here is the code we wrote during the lesson:
// Recursion examples:

def count(max: Int): Int = {
  max match {
    case 0 => 0
    case curr => count(curr - 1) + 1
  }
}

def double(value: Int): Int = {
  value match {
    case 1 => 2
    case curr => double(curr - 1) + 2
  }
}

// Traffic Lights Algebraic Sum Data Type:
sealed trait TrafficLight
case object Red extends TrafficLight
case object Amber extends TrafficLight
case object Green extends TrafficLight

// Traffic Lights Structural Recursion and runner:
object Runner extends App {

  def nextLight(light: TrafficLight): TrafficLight = {
    light match {
      case Red => Amber
      case Amber => Green
      case Green => Red
    }
  }

  println(nextLight(Red))
}



