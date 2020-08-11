import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @program: IntelliJ IDEA
 * @description:List扑克牌
 * @author: HAOYI
 * @date:2020-08-11 11:42
 **/
class Card{
    public int rank; // 牌面值
    public String suit; // 花色

    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return String.format("[%s %d]",suit,rank);
    }
}
public class CardDemo {
    public static final String[] SUITS= {"♥","♠","♦","♣"};
    public static List<Card> buyDeck(){
        List<Card> deck = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <=13 ; j++) {
                int rank = j;
                String suit = SUITS[i];
                Card card = new Card(rank,suit);
                deck.add(card);
            }
        }
        return deck;
    }
    public static void swap(List<Card> deck,int index,int i){
          Card tmp = deck.get(index);
          deck.set(index,deck.get(i));
          deck.set(i,tmp);
    }
    public static void shuffle(List<Card> deck){
        for (int i = deck.size()-1; i >0 ; i--) {
            Random random = new Random();
            int index = random.nextInt(i);//[0,i)随机数
            swap(deck,index,i);
        }
    }
    public static void main(String[] args) {
         List<Card> deck = buyDeck();
        System.out.println(deck);
        System.out.println("==洗牌==");
        shuffle(deck);
        System.out.println(deck);
        List<List<Card>> hand = new ArrayList<>();
        List<Card> hands1 = new ArrayList<>();
        List<Card> hands2 = new ArrayList<>();
        List<Card> hands3 = new ArrayList<>();
        hand.add(hands1);
        hand.add(hands2);
        hand.add(hands3);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                Card card = deck.remove(0);
                hand.get(j).add(card);
            }
        }
        System.out.println("第一个人的牌：");
        System.out.println(hands1);
        System.out.println("第二个人的牌：");
        System.out.println(hands2);
        System.out.println("第三个人的牌：");
        System.out.println(hands3);
        System.out.println("剩下的牌");
        System.out.println(deck);
    }
}
