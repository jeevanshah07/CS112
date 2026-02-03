import java.util.Arrays;

public class QuickUnion {
    int[] parent;

    public QuickUnion(int n ) {
        parent = new int[n];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }

    public int find(int i) {
        while (i != parent[i]) {
            i = parent[i];
        }
        return i;
    }

    public void union(int i, int j) {
        int i_root = find(i);
        int j_root = find(j);
        parent[i_root] = j_root;
    }

    public static void main(String[] args) {
        System.out.println();
        QuickUnion qf = new QuickUnion(8);

        System.out.println("\nInitial -> " + Arrays.toString(qf.parent));

        qf.union(0, 2);
        System.out.print("\nunion(0,2) -> ");
        System.out.println(Arrays.toString(qf.parent));

        qf.union(4, 7);
        System.out.print("\nunion(4,7) -> ");
        System.out.println(Arrays.toString(qf.parent));

        qf.union(0, 4);
        System.out.print("\nunion(0,4) -> ");
        System.out.println(Arrays.toString(qf.parent));

        System.out.println("\nfind(0) -> " + qf.find(0));
        System.out.println();
    }
}