void main() {
    // to see how IntelliJ IDEA suggests fixing it.
    int[] num = {2, 7, 11, 15};
    int target = 9;
    int[] sol = twoSum(num, target);
    System.out.println(Arrays.toString(sol));
}

public int[] twoSum(int[] numbers, int target) {
    int[] sol = new int[2];
    for (int i = 0; i < numbers.length; i++) {
        for (int j = i+1; j < numbers.length; j++) {
            if (numbers[i] + numbers[j] == target) {
                sol[0] = i;
                sol[1] = j;
                return sol;
            }
        }
    }

    return sol;
}
