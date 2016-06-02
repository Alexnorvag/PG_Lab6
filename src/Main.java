import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by norvag on 02.06.2016.
 * Ввести текст и список слов.
 * Для каждого слова из заданного списка найти,
 * сколько раз оно встречается в тексте,
 * и рассортировать слова по убыванию количества вхождений.
 */
public class Main {
    private static String Text = "E8YS9 Solar System, EL8Z-M Constellation, Immensea Region\n" +
            "20.01.106 - 05:41 EVT\n" +
            "Failure always begets reflection, and Mattias found himself asking the same question over and over again:\n" +
            "How could it have come to this?\n" +
            "He stared in crushed disbelief at the rippling translucent inner membrane of the warp tunnel, watching the planets and moons of the E8-YS9 system shoot past his ship. The Blackbird-class cruiser at his command was hurtling through the tunnel at hundreds of times the speed of light. Mattias was amazed the battered vessel was still capable of sustaining this speed without breaking apart.\n" +
            "We were so close to killing him, he thought. So very, very close.\n" +
            "The tragedy would not be in his own death, but in the fact that his prey would continue to live out its wretched, despicable existence. For Mattias and the team of loyal bounty hunters that he had dedicated his life to, this was the ultimate failure. They had lost the bounty, were about to lose their lives, and worst of all, lost an opportunity to do some good in a galaxy controlled by greed and evil above all else.\n" +
            "“Do you believe in God, Mattias?” asked the voice of his enemy. Mattias cursed his own misfortune and refused to answer.\n" +
            "“And what of the Amarr and Minmatar comrades that you are leading to death?” the wicked voice sneered. “Are they believers in an afterlife?”\n" +
            "In an instant, Mattias thought of the entire history of the two outstanding bounty hunters—and great friends—whose lives were in as much peril as his own. Kirlana was an Amarr by birth, but had rebelled against her lavish upbringing and become ashamed of her cultural roots. She renounced her family name and turned her back on the fortune that would have been hers by birthright. The only “possession” she took with her was Matuno, the Brutor slave that had looked after her since childhood. She transformed him into an independent, Tempest-class battleship captain. Now, he answered to no one. But he would never forget those he was beholden to.\n" +
            "Forever grateful for being set free of Amarrian bondage, Matuno found himself unable to leave Kirlana's side, and together they sought greater purpose in life. After months of wandering Empire space, fate would introduce them to Mattias Kakkichi. Inspired by his passion for truth and justice, they readily joined his self-appointed mission: To become the arm of justice where the laws of Empire space could not reach. The money received from collected bounties was unimportant to them. The real reward was the righted wrong, accomplished through the kill itself. Watching evil succumb to the thunder of guns filled each of their souls with delicious satisfaction. No single feeling was more powerful than knowing that an injustice had been avenged. But on this day, the odds of lethal misfortune for pursuing such a risky profession finally caught up with them.\n" +
            "Mattias, Kirlana, and Matuno were fleeing from the scene of an assassination attempt on Trald Vukenda, the leader of the infamous Angel Cartel and the highest profile target they had ever hunted. The operation had gone horribly wrong. Within sight of their prey, the enemy surprised the bounty hunters with reinforcements, and they suddenly found themselves greatly outnumbered. Their ships were punished almost to the breaking point, and they were lucky to have escaped into warp. But there were only two jumpgates leading out of the system, and Trald already knew which one the bounty hunters were running towards. Both exits were already blockaded by Angel Cartel ships.\n" +
            "“I'm going to nail your self-righteous corpse to that jumpgate, Mattias,” snarled Trald. “As a reminder to others about the perils in pursuing delusional moral obligations.”";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> listOfWords = new ArrayList<>();

        System.out.println("Введите список из 5 слов: ");
        for (int i = 0; i < 5; i++) {
            listOfWords.add(reader.readLine());
        }

        String delemiters = " \t\n\r\f,.!?—";
        StringTokenizer tokenizer = new StringTokenizer(Text, delemiters);

        Map<String, Integer> words = new TreeMap<String, Integer>();
        String word;
        Integer count;
        while (tokenizer.hasMoreTokens()) {
            word = tokenizer.nextToken().toLowerCase();
            count = words.get(word);
            count = (count == null) ? 1 : count + 1;
            words.put(word, count);
        }

        Set<String> keys = words.keySet();
        for (String key : keys) {
            for (int i = 0; i < listOfWords.size(); i++) {
                if (key.equals(listOfWords.get(i))) {
                    System.out.println(key + " " + words.get(key));
                }
            }
        }
    }
}
