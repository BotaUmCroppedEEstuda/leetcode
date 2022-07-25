package twosum;

import java.util.HashMap;

public class TwoSumSolutionLeticia {

    public int[] twoSum(int[] nums, int target) {
        int[] result = null;

        HashMap<Integer, Integer> mapInicial = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            mapInicial.put(i, nums[i]);

            if (result != null) {
                break;
            }

            for (int j = 1; j < nums.length; j++) {

                if (result != null) {
                    break;
                }

                if (nums[i] + nums[j] == target && i != j) {

                    System.out.println("posicao: " + i + " valor inicial: " + nums[i]);


                    System.out.println("posicao: " + j + " valor atual: " + nums[j]);

                    result = new int[]{i, j};

                }
            }
        }

        return result;

    }
}
