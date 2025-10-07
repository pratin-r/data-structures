import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        Subsets obj = new Subsets();
        obj.subsets(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> set = new ArrayList<>();
        obj.subsetUsingDFS(0, set, res, nums);
        System.out.println(res.toString());
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for (int num : nums) {
            int size = res.size();
            for (int i = 0; i < size; i++) {
                List<Integer> subsets = new ArrayList<>(res.get(i));
                subsets.add(num);
                res.add(subsets);
            }
        }
        res.forEach(v -> System.out.println(v.toString()));
        return res;
    }

    public void subsetUsingDFS(int i, List<Integer> subset, List<List<Integer>> res, int[] nums) {
        /*
         * one important note
         * 
         * 1) if you do res.add(subset), what you are doing is actually passing the
         * address of 'subset' to 'res'
         * 
         * 2) 'subset' is prone to changes as it is adding and removing the values in
         * recursion.
         * 
         * 3) if i pass 'subset' directly, then in the end, the res contains only empty
         * arraylist.
         * 
         * 4)thats why we created a ArrayList inside 'add' method, which will contain
         * the copy of subset present at that time of recursion.
         */

        if (i >= nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[i]);
        subsetUsingDFS(i + 1, subset, res, nums);
        subset.remove(subset.size() - 1);
        subsetUsingDFS(i + 1, subset, res, nums);
    }
}
