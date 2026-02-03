import java.util.Arrays;
public class UnionFind {
    int[] id;

    public UnionFind(int n) {
        id = new int[n];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    public int find(int i) {
        return id[i];
    }

    public void union(int i, int j) {
        int i_set = id[i];
        int j_set = id[j];
        for (int s = 0; s < id.length; s++) {
            if (id[s] == i_set) {
                id[s] = j_set;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println();
        UnionFind qf = new UnionFind(8);
        System.out.println("\nInitial -> " + Arrays.toString(qf.id));
        qf.union(1, 3);
        System.out.print("\nunion(1,3) -> ");
        System.out.println(Arrays.toString(qf.id));
        qf.union(5, 6);
        System.out.print("\nunion(5,6) -> ");
        System.out.println(Arrays.toString(qf.id));
        qf.union(3, 6);
        System.out.print("\nunion(3,6) -> ");
        System.out.println(Arrays.toString(qf.id));
        System.out.println("\nfind(1) -> " + qf.find(1));
        System.out.println();
    }
}
