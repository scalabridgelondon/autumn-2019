/*

Week 4 - courtesy of Scott Cutts
Lighter Intermediate set

This week we can build on our Algebraic Data Type and Structural Recursion knowledge,
and begin to introduce Generics and passing some functions around.
Read Chapter 5, sections 5.1 and 5.2.
Some links from the Scala docs with potentially simpler explanations:
Generics https://docs.scala-lang.org/tour/generic-classes.html
Higher Order Functions (Section 5.2.1 & 5.2.2 in Essential Scala cover this well too)
https://docs.scala-lang.org/tour/higher-order-functions.html

1. There are 4 types of DNA (Deoxyribonucleic acid)
* C - cytosine
* G - guanine
* A - adenine
* T - thymine

Whats a good way to represent them in Scala? Lets implement it.
 */

sealed trait DNA
case object C extends DNA
case object G extends DNA
case object A extends DNA
case object T extends DNA

/*
2. A Strand of DNA is made up of either:
* Nucleotides -  which has one DNA value and a Covalent Bond that holds the rest of the Strand
(Yes, its really 4 DNA values per nucleotide but this makes it easier for us!)
* A Terminator - a section of nucleic acid that signifies the end of a strand
Lets model this as well.
*/

sealed trait Strand[A]
final case class Nucleotide[A](value: A, covalent: Strand[A]) extends Strand[A]
final case class Terminator[A]() extends Strand[A]

def contains[A](strand: Strand[A], f: A => Boolean): Boolean = {
  strand match {
    case Nucleotide(value, covalent) =>
      val result = f(value)
//      result || contains(covalent, f)
      if (result) {
        true
      } else {
        contains(covalent, f)
      }
    case Terminator() => false
  }
}

contains(Nucleotide(G, Nucleotide(T, Terminator())), d => d == G)
contains(Nucleotide(Z, Terminator(), d => d == S))

/*
3. Now lets write a method that returns a String containing the genetic code of a strand e.g. "TCATTGGA"
What strategies do we know for working with a structure like a DNA Strand in Scala?
Where is the best place to implement this method?
*/

Nucleotide(G, Nucleotide(T, Terminator()))
def code(something: Strand): String = {
  something match {
    case Nucleotide(value, covalent) =>
      val result = code(covalent)
      s"$value$result"
    case Terminator() => ""
  }
}

/*
4. DNA is double stranded, which means it always comes in a Pair and
always according to the following rules of DNA Base Pairing:
* A with T
* C with G
Let write a method to find the base pair DNA for a given DNA. Where should this go?
 */

def dna(letter: DNA): DNA = {
  letter match {
    case A => T
    case C => G
    case T => A
    case G => C
  }
}

/*
5. By using the above method, we can now create a new method
for finding the matching Pair Strand for a given strand of DNA.
 e.g given the Strand AGGT, our Pair Strand method will return TCCA.
 */

def matchStrand(letters: Strand): Strand = {
  letters match {
    case Nucleotide(value, covalent) =>
      val first = dna(value)
      val second = matchStrand(covalent)
      Nucleotide(first, second)
    case Terminator() => Terminator()
  }
}

 /*
6. We've discovered Alien life! Some little potato shaped things near Alpha-Centauri.

 They are built out of ZNA (Zanynucleic acid). Just like DNA, there are four types of ZNA:
 * Z - zanine
   * V - vacuracil
   * W - wowadine
   * P - potatoes

   Implement ZNA.
  */

sealed trait ZNA
case object Z extends ZNA
case object V extends ZNA
case object W extends ZNA
case object P extends ZNA

/*
Question 7
7a) What are Generics and what do they allow us to do?
Generic classes take a letter as a parameter, which means they can take any type.

7b) What strategies exist that can help us to convert an algebraic data type into a generic?
Identify the types that you want to make generic and add a letter in a square bracket parameter.

7c) Generic types can be declared in trait and class declerations - can we use this in our ADTs then?


8. A strand of ZNA works in exactly the same way as DNA.
We have a strategy for this so lets change our Strand ADT into a generic!
What happens now if we call the genetic code method for ZNA?
What about Pair Strands?
*/

case class Box[A](x: A)


