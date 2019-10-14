/*
Week 5 - courtesy of Scott Cutts and Stefano P
Lighter Intermediate set
https://github.com/scalabridgelondon/lesson-plans/blob/master/intermediate-2/questions/week-5.md
*/

sealed trait Tree[A] {
  def fold[B](leafF: A => B, nodeF: (B, B) => B): B = {
    this match {
      case Leaf(a) => leafF(a)
      case Node(a, left, right) =>
        val b1 = leafF(a)
        val b2 = left.fold(leafF, nodeF)
        val b3 = right.fold(leafF, nodeF)

        val b4 = nodeF(b2, b3)
        nodeF(b1, b4)
    }
  }
  def size2: Int = fold(_ => 1, (l: Int, r: Int) => l + r)
  def prettyPrint2: String = fold((value: A) => value.toString, (l: String, r: String) => l + r)
  def contains2(term: A): Boolean = fold((value: A) => Boolean =  value == term, (l: Boolean, r: Boolean) => l || r)
}

final case class Leaf[A](value: A) extends Tree[A]
final case class Node[A](value: A, left: Tree[A], right: Tree[A]) extends Tree[A]

object Tree {
  def size[A](input: Tree[A]): Int = {
    input match {
      case Leaf(name) => 1
      case Node(name, left, right) => ((1 + size(left)) + size(right))
    }
  }

  def prettyPrint[A](input: Tree[A]): String = {
    input match {
      case Leaf(name) => name.toString
      case Node(name, left, right) => s"$name, ${prettyPrint(left)}, ${prettyPrint(right)}"
    }
  }

  def contains[A](term: A, tree: Tree[A]): Boolean = {
    tree match {
      case Leaf(name) => term == name
      case Node(name, left, right) => term == name || contains(term, left) || contains(term, right)
    }
  }

  val intF: Int => Int = { i => i + 1 }
  intF(1)
  val highF: (Int => Int) => (Int => Int) = f => f.andThen(_ + 1)
  highF(intF)(1)

}
