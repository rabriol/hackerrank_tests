package datastructures.stack;

import java.util.Stack;

/**
 * Created by rabriol on 2/28/17.
 * Took 1 hour to solve
 */
public class SurvivalFishes {

    public static void main(String[] args) {
        /**
         *   ---------------Top----------------
         *   A[0] = 4    B[0] = 0 (up)
         *   A[1] = 3    B[1] = 1 (down)
         *   A[2] = 2    B[2] = 0 (up)
         *   A[3] = 1    B[3] = 0 (up)
         *   A[4] = 5    B[4] = 0 (up)
         *   -------------Bottom---------------
         */
        System.out.println(getSurvivalFishes(new int[]{4, 3, 2, 1, 5}, new int[]{0, 1, 0, 0, 0}));

        /**
         *   ---------------Top----------------
         *   A[0] = 4    B[0] = 1 (down)
         *   A[1] = 3    B[1] = 0 (up)
         *   A[2] = 2    B[2] = 1 (down)
         *   A[3] = 7    B[3] = 0 (up)
         *   A[4] = 5    B[4] = 1 (down)
         *   -------------Bottom---------------
         */
        System.out.println(getSurvivalFishes(new int[]{4, 3, 2, 7, 5}, new int[]{1, 0, 1, 0, 1}));
    }

    public static int getSurvivalFishes(int[] A, int[] B) {
        Stack<Fish> fishes = new Stack<>();

        for (int index = 0; index < A.length; index++) {
            fishes.push(new Fish(A[index], B[index]));

            if (fishes.peek().direction == 0) {
                Fish top = fishes.pop();

                while(!fishes.isEmpty() && fishes.peek().direction == 1) {
                    if (fishes.peek().size > top.size) {
                        break;
                    } else {
                        fishes.pop();
                        fishes.push(top);
                    }
                }

                if (fishes.isEmpty()) {
                    fishes.push(top);
                }
            }
        }

        return fishes.size();
    }
}

class Fish {
    int size;
    int direction;

    public Fish(int size, int direction) {
        this.size = size;
        this.direction = direction;
    }
}

/**
 You are given two non-empty zero-indexed arrays A and B consisting of N integers. Arrays A and B represent N voracious fish in a river, ordered downstream along the flow of the river.

 The fish are numbered from 0 to N − 1. If P and Q are two fish and P < Q, then fish P is initially upstream of fish Q. Initially, each fish has a unique position.

 Fish number P is represented by A[P] and B[P]. Array A contains the sizes of the fish. All its elements are unique. Array B contains the directions of the fish. It contains only 0s and/or 1s, where:
 1) 0 represents a fish flowing upstream,
 2) 1 represents a fish flowing downstream.

 If two fish move in opposite directions and there are no other (living) fish between them, they will eventually meet each other. Then only one fish can stay alive − the larger fish eats the smaller one. More precisely, we say that two fish P and Q meet each other when P < Q, B[P] = 1 and B[Q] = 0, and there are no living fish between them. After they meet:
 1) If A[P] > A[Q] then P eats Q, and P will still be flowing downstream,
 2) If A[Q] > A[P] then Q eats P, and Q will still be flowing upstream.

 We assume that all the fish are flowing at the same speed. That is, fish moving in the same direction never meet. The goal is to calculate the number of fish that will stay alive.

 For example, consider arrays A and B such that:
 ---------------Top----------------
 A[0] = 4    B[0] = 0 (up)
 A[1] = 3    B[1] = 1 (down)
 A[2] = 2    B[2] = 0 (up)
 A[3] = 1    B[3] = 0 (up)
 A[4] = 5    B[4] = 0 (up)
 -------------Bottom---------------

 Initially all the fish are alive and all except fish number 1 are moving upstream. Fish number 1 meets fish number 2 and eats it, then it meets fish number 3 and eats it too. Finally, it meets fish number 4 and is eaten by it. The remaining two fish, number 0 and 4, never meet and therefore stay alive.

 Write a function that, given two non-empty zero-indexed arrays A and B consisting of N integers, returns the number of fish that will stay alive.

 For example, given the arrays shown above, the function should return 2, as explained above.
**/
