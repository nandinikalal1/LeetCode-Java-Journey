import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(); // value -> index

        for (int i = 0; i < nums.length; i++) {
            int need = target - nums[i];

            if (map.containsKey(need)) {
                return new int[]{map.get(need), i};
            }

            map.put(nums[i], i);
        }

        return new int[0]; 
    }

   
    public static void main(String[] args) {
        TwoSum ts = new TwoSum();

        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] ans = ts.twoSum(nums, target);

        System.out.println("Indices: " + ans[0] + ", " + ans[1]);
    }
}
