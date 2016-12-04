/* Card
o type = “class”
o category = “CardGames”
o description = “Represents a card object used to play games with.”
 */
@CardsAnnotation(type = "class",
        category = "CardGames",
        description = "Represents a card object used to play games with.")

public class Card implements Comparable {

    private CardRank rank;
    private CardSuit suit;

    public Card(CardRank rank, CardSuit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        String result = this.rank + " of " + this.suit;
        return result;
    }

    public int compareTo(Card card) {
        int result = this.getRank().compareTo(card.rank);
        return result;
    }

    public CardRank getRank() {
        return rank;
    }

    public CardSuit getSuit() {
        return suit;
    }

    public void setRank(CardRank rank) {
        this.rank = rank;
    }

    public void setSuit(CardSuit suit) {
        this.suit = suit;
    }

}
