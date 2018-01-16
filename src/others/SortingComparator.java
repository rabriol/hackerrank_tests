package others;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by rabriol on 8/13/17.
 */
class Checker implements Comparator<Player>{
    @Override
    public int compare(Player o1, Player o2) {
        if (o1.score > o2.score) return -1;
        if (o2.score > o1.score) return 1;
        return compareAlphabetically(o1.name, 0, o2.name, 0);
    }

    public int compareAlphabetically(String name1, int i1, String name2, int i2) {
        if(name1.length() ==  i1 && name2.length() == i2) return 0;
        if (name1.length() ==  i1) return -1;
        if (name2.length() == i2) return 1;
        if (name1.charAt(i1) > name2.charAt(i2)) return 1;
        if (name2.charAt(i2) > name1.charAt(i1)) return -1;
        return compareAlphabetically(name1, ++i1, name2, ++i2);
    }
}

class Player{
    String name;
    int score;

    Player(String name, int score){
        this.name = name;
        this.score = score;
    }
}

class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        Player[] player = new Player[n];
        Checker checker = new Checker();

        for(int i = 0; i < n; i++){
            player[i] = new Player(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }
}
