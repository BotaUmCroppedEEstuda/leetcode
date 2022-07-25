package findfirstandlastpositionofelementinsortedarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SolutionLeticia {

    public static void main(String[] args) {
        int[] nums = {3,3,3};
        int target = 3;
        int[] result = searchRange(nums, target);
        System.out.println(Arrays.toString(result));
    }
    public static int[] searchRange(int[] nums, int target) {

        List<Integer> result = new ArrayList<>();

        for(int count = 0; count < nums.length; count++) {
            int value = nums[count];

            if (target == value) {
                result.add(count);
            }
        }

        if (result.isEmpty()) {
            return new int[]{-1, -1};
        }

        return new int[]{Collections.min(result), Collections.max(result)};
    }
}
