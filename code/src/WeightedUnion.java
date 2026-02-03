import java.util.Arrays;

public class WeightedUnion {
    int[] parent;
    int[] size;

    public WeightedUnion(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            size[i] = 1;
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
        if (size[i_root] < size[j_root]) {
            parent[i_root] = j_root;
            size[j_root] += size[i_root];
        } else {
            parent[j_root] = i_root;
            size[i_root] += size[j_root];
        }
    }
}
