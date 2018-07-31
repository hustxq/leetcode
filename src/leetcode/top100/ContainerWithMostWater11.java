package leetcode.top100;

/**
 * Created by qxiong on 2018/1/9.
 */
public class ContainerWithMostWater11 {
    public static void main(String[] args) {
        int[] harr = new int[]{3,2,1,3};
                //{1, 2, 3, 4, 5};
        System.out.println(maxArea(harr));
    }

    public static int maxArea(int[] height) {
        int max = 0;
        int l = 0, r = height.length - 1;
        while (l < r) {
            max = Math.max(max,Math.min(height[l],height[r])*(r-l));
            if (height[l]<height[r]){
                l++;
            }else {
                r--;
            }
        }
        return max;
    }

    /**
     * 短板容器
     *
     * @param height
     * @return
     */
    public static int maxArea1(int[] height) {
        int len = height.length;
        int max = 0;
//        int[][] varr = new int[len][len];
        for (int i = 0; i < len - 1; i++) {
            int h = height[i];
            for (int j = i + 1; j < len; j++) {
                int l = j - i;
                if (height[j] < h) {
                    h = height[j];
                }
//                varr[i][j] = l*h;
                if (max < l * h) {
                    max = l * h;
                }
            }
        }
        return max;
    }
}
