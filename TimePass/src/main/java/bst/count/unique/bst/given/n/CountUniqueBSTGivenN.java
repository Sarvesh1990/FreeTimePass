package bst.count.unique.bst.given.n;


public class CountUniqueBSTGivenN {
    public static void main(String[] args) {
        CountUniqueBSTGivenN cu = new CountUniqueBSTGivenN();
        System.out.println(cu.numTrees(3));
    }

    public int numTrees(int n) {
        int[] countBST = new int[n+1];
        countBST[0] = 1;

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                countBST[i] += countBST[j - 1] * countBST[i - j];
            }
        }

        return countBST[n];
    }
}
