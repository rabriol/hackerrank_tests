import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by peo_rboliveira on 26/12/16.
 */
public class BinarySearchIceCreamParlor {

    public static int binarySearch(int first, int last, IceCream[] arr, int search) {
        if (first > last) {
            return -1;
        }

        int mid = (first+last)/2;
        if (arr[mid].flavor == search) {
            return arr[mid].index;
        } else if (search < arr[mid].flavor) {
            return binarySearch(first, mid-1, arr, search);
        } else {
            return binarySearch(mid+1, last, arr, search);
        }
    }

    public static void main(String[] args) {
        int t;
        int n, m;

        Scanner in = new Scanner(System.in);
        t = in.nextInt();
        for(int test = 0; test < t; test++) {

            m = in.nextInt();
            n = in.nextInt();
            IceCream[] arr = new IceCream[n];

            for (int i = 0; i < n; i++)
                arr[i] = new IceCream(in.nextInt(), i + 1);

            Arrays.sort(arr);
            for(int i = 0; i < n - 1 ; i++) {
                int search = m - arr[i].flavor;
                if(search >= arr[i].flavor) {
                    int index = binarySearch(i + 1, n - 1, arr, search);
                    if( index != -1 ) {
                        System.out.println(Math.min(arr[i].index, index) + " " + Math.max(arr[i].index, index));
                        break;

                    }
                }
            }

        }
    }
}

class IceCream implements Comparable {
    int flavor;
    int index;

    public IceCream(int flavor, int index) {
        this.flavor = flavor;
        this.index = index;
    }

    @Override
    public int compareTo(Object o) {
        if (flavor < ((IceCream)o).flavor) {
            return -1;
        } else if (this.equals(0)) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IceCream iceCream = (IceCream) o;

        if (flavor != iceCream.flavor) return false;
        return index == iceCream.index;

    }

    @Override
    public int hashCode() {
        int result = flavor;
        result = 31 * result + index;
        return result;
    }
}
