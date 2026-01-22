# CS112 - Data Structures
## Lecture 2 (1/22)
### Union-Find
Can be used to check if two nodes in a graph are connected. Eg. 
```
A --- B     E---F
|     |     |
|     |     G
C     D
```
Is there a path from `C` to `D`? Can you connect `G` to `A`? These are all questions that can be solved using union-find.

Consider representing each node as a singleton set. For example:

```
{0}, {1}, {2}, {3}, {4}, {5}, {6}, {7}
```

and ask are $0$ and $3$ in the same set? To answer we find which set $0$ is in and which set $3$ is in and check if they're the same. To do this, we give each set an id: `id[i] = i` which results in the following definition for the `find` function:
> `find(i) = id[i]` returns the id of the set containing `i`

- `find(0) = id[0] = 0`
- `find(3) = id[3] = 3`

since $0 \neq 3$ we now know that $0$ and $3$ are not in the same set (not the distinction between the ids and the elements in the set). This is called **Quick Find** and it has a big-O of `O(1)` since reading from an array is done in constant time. 

We now define the `union` function in the following manner:
> `union(x, y)` is the union of the set to which `x` belongs with the set to which `y` belongs

Continuing with the example above we might have `union(1, 3)` which results in 

```
{1, 3}, {0}, {2}, {4}, {5}, {6}, {7}
```

However, we must now set update the `id` array accordingly since $1$ and $3$ are in the same set (i.e. `id[i]` should be equal to `id[3]` so that `find(1) == find(3)`). For now we define that after `union(x, y)` we set `id[x] = id[y]` (note that this change is arbitrary and we could've easily made `id[y] = id[x]` with zero difference). Applying this to our example results in the following `id` array: 

```
[0, 3, 2, 3, 4, 5, 6, 7]
```

Continuing after `union(1, 3)`, consider `union(3, 6)` which results in 
```
{1, 3, 6}, {0}, {2}, {4}, {5}, {7}
```
and an `id` array of 
```
[0, 6, 2, 6, 4, 5, 6, 7]
```

> To summarize: We started off with 8 singleton sets from `0` to `7`. Then we did `union(1, 3)` which combined `1` and `3` into a single set and changed `id[1]` to `3`. Next we did `union(3, 6)` which combined the set containing `3` (`{1, 3}`) with the set containing `6`. This changed `id[1]=id[3]=id[6]=6`. 

To demostrate these ideas algorithmically lets continue with `union(4, 5)`. Now our steps would be

> - scan the array for each item that has `id[i] = 4`
> - then change all of those elements to have `id[i]=5`

So this leaves us with an `id` array of 

```
[0, 6, 2, 6, 5, 5, 6, 7]
```
which reflects a physical mapping of 
```
{0}, {1, 3, 6}, {4, 5}, {2}, {7}
```

We can now do `union(1, 5)` which will update every element such that `id[i] = 6` to `id[i] = 5`. Again, this gives an `id` array of 
```
[0, 5, 2, 5, 5, 5, 5, 7]
```
which reflects
```
{0}, {1, 3, 6, 4, 5}, {2}, {7}
```
---
We now consider this as a program

```java
public class UnionFind {
    private int[] id;
    public UnionFind(int n){
        id = new int[n];
        // initialize the id arry
        for (int i = 0; i < n; i ++) {
            id[i] = i;
        }
    }

    public int quickfind (int i) {
        // O(1)
        return id[i];
    }

    public void union(int i, int j) {
        int x = id[i];
        int y = id[j];

        // any element with an id == x should have their id switched to y
        for (int s = 0; s < id.length; s++) {
            if (id[s] == x) {
                id[s] = y;
            }
        }
    }
}
```

The above discussion and program should make it pretty clear that `UnionFind` has a big-O of `O(n)` since the `union()` function requires passing through the entire array.