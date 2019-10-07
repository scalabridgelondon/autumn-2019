/*
https://github.com/scalabridgelondon/lesson-plans/blob/master/intermediate/questions/week-1.md

Question 1:
An expression evaluates to a value. They exist at compile time. For example, 1 + 1 is an expression.
An object is a grouping of data, for example the Integer 2 is an object.
A value is an object.
A literal literally evaluates to whatever you have typed, for example "Hello World" is a string literal.
A method is an operation which can be performed eg the addition operator lets us add to values.
 */

// Question 2
// Operators are methods. Methods like addition, minus and division can be used as infix operators.
10 + 1
// They can also be called with dot notation, for example:
10.+(1)

/*
Question 3
Declare an object called ScalaBridge with:
- a field, called theAnswer, given the value 42; and
- a method called hello that accepts two parameters called name and answer.
- The parameter called name should be a String and the parameter called answer should be an Int.
- The method should return a String that reads "Hello , the answer is "
  (replacing name and answer with the appropriate values).
 */
  object ScalaBridge {
    val theAnswer = 42
    def hello(name: String, answer: Int): String = {
      s"Hello $name, the answer is $answer"
    }
  }

/*
Question 4
Every expression in Scala has a type, which is determined at compile time.
- 4/2 evaluates to 2 and is type Int
- 2/4 evaluates to 0.5 and is type Double
- 1/0 an error is raised because we cannot divide by zero. The type is Int.

Questions 5 & 6
There are different learning strategies we can employ, for example:
- asking people or google for help
- trying to use our own logic to come up with an answer
- observation

Question 7
7a) What is the difference between a declaration and an expression? What can each do that the other cannot?
The defining characteristic of an expression is that it evaluates to a value and it only exists at compile time.
A declaration does not evaluate to a value. Instead it associates a name with a value.

7b) Why do we have these different parts of programs?
  ...??????

Question 8
In Scala, `if` is an expression.
This is advantageous because..??????

Question 9
`Image` is brought into scope by object AnExample
image is in scope at point <A>
ziggy is in scope at point <B>

Question
Image.circle(100) = type
Image.circle(100).draw() = type
4 + 2 = type
println(4 + 2) = type
What is the difference between the above expressions that goes beyond their types?
???????

Question 11
Types are an approximation to programme behaviour, because they exist only at compile time.
 */
