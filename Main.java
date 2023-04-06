import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vector<Card> deck = Card.createDeck();
        int choice;
        do {
            System.out.println("1. Print the deck");
            System.out.println("2. Deal cards");
            System.out.println("3. Sort the deck");
            System.out.println("4. Search for a card");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    Card.printDeck(deck);
                    break;
                case 2:
                    int numCards = scanner.nextInt();
                    Card.dealCards(deck, numCards);
                    break;
                case 3:
                    Card.sortDeck(deck);
                    System.out.println("Deck sorted!");
                    break;
                case 4:
                    System.out.print("Enter the rank of the card (0-12): ");
                    int rank = scanner.nextInt();
                    System.out.print("Enter the suit of the card (0-3): ");
                    int suit = scanner.nextInt();
                    Card card = new Card(rank, suit);
                    int index = Card.findCard(deck, card);
                    if (index == -1) {
                    System.out.println("Card not found in the deck!");
                    } else {
                    System.out.println("Card found at index " + index + " in the deck.");
                    }
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
             }
            System.out.println();
            } while (choice != 0);
        scanner.close();
    }
}
import java.util.*;
public class Card 
{
    private int rank;
    private int suit;
    public Card() // Default constructor sets rank and suit to 0
    {
        this.rank = 0;
        this.suit = 0;
    }
    public Card(int rank, int suit)     // Parameterized constructor sets rank and suit to given values

    {
        this.rank = rank;
        this.suit = suit;
    }
    public int getRank()    // Getter methods for rank and suit
    {
        return rank;
    }
    public int getSuit() 
    {
        return suit;
    }
    public void printCard()
    {
        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        System.out.println(ranks[rank] + " of " + suits[suit]);
    }
    public static Vector<Card> createDeck() 
    {
        Vector<Card> deck = new Vector<Card>();
        for (int suit = 0; suit < 4; suit++) 
        {
            for (int rank = 0; rank < 13; rank++)
            {
                deck.add(new Card(rank, suit));
            }
        }
        return deck;
    }
    public static void printDeck(Vector<Card> deck)
    {
        for (int i = 0; i < deck.size(); i++) 
        {
            deck.get(i).printCard();
        }
    }
    public static boolean sameCard(Card c1, Card c2)
    {
        return c1.getRank() == c2.getRank() && c1.getSuit() == c2.getSuit();
    }
    public static int compareCard(Card c1, Card c2)
    {
        if (c1.getRank() < c2.getRank()) 
        {
            return -1;
        } 
        else if (c1.getRank() > c2.getRank()) 
        {
            return 1;
        }
        else
        {
            return Integer.compare(c1.getSuit(), c2.getSuit());
        }
    }
    public static void sortDeck(Vector<Card> deck)
    {
        Collections.sort(deck, new Comparator<Card>()
        {
            @Override
            public int compare(Card c1, Card c2)
            {
                return compareCard(c1, c2);
            }
        });
    }
    
    public static int findCard(Vector<Card> deck, Card card) 
    {
        for (int i = 0; i < deck.size(); i++)
        {
            if (sameCard(deck.get(i), card)) 
            {
                return i;
            }
        }
        return -1;
    }
    public static void dealCards(Vector<Card> deck, int numCards)
    {
        Random rand = new Random();
        for (int i = 0; i < numCards; i++) {
            int index = rand.nextInt(deck.size());
            Card card = deck.remove(index);
            card.printCard();
        }
    }
}
