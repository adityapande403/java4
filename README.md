# java4

There are 52 cards in a standard deck. Each card belongs to one of four suits and one of 13 ranks. The suits are Spades, Hearts, Diamonds, and Clubs. The ranks are Ace, 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, and King.

If we want to define a class to represent a playing card, it is pretty obvious what the instance variables should be: rank and suit. It is not as obvious what types they should be. One possibility is a String containing things like "Spade" for suits and "Queen" for ranks. A problem with this design is that it would not be easy to compare cards to see which had a higher rank or suit.

An alternative is to use integers to encode the ranks and suits. By “encode” we don’t mean to encrypt or translate into a secret code. We mean “define a mapping between a sequence of numbers and the things we want to represent.”

When you create a new class, the first step is to declare the instance variables and write constructors. A good next step is to write toString, which is useful for debugging and incremental development.

To display Card objects in a way that humans can read easily, we need to map the integer codes onto words. A natural way to do that is with an array of Strings.

Local variables are created when a method is invoked, and their space is reclaimed when the method ends. Instance variables are created when you construct an object and reclaimed when the object is garbage-collected.

Now it’s time to learn about class variables. Like instance variables, class variables are defined in a class definition, before the method definitions. But they are identified by the keyword static. They are created when the program begins (or when the class is used for the first time) and survive until the program ends. Class variables are shared across all instances of the class.

The set of playing cards is “partially ordered”, which means that sometimes we can compare cards and sometimes not. For example, we know that the 3 of Clubs is higher than the 2 of Clubs, and the 3 of Diamonds is higher than the 3 of Clubs. But which is better, the 3 of Clubs or the 2 of Diamonds? One has a higher rank, but the other has a higher suit.

To make cards comparable, we have to decide which is more important: rank or suit. The choice is arbitrary, and it might be different for different games. But when you buy a new deck of cards, it comes sorted with all the Clubs together, followed by all the Diamonds, and so on. So for now, let’s say that suit is more important.

