package com.luokp;

/**
 * @author: luokp
 * @date: 2018/12/6 21:54
 * @description:
 */
public class _42TrapingRainWater {

    public static int trap(int[] height) {
        if(height == null || height.length <= 2) {
            return 0;
        }
        int len = height.length;
        int volum = 0;
        int start = 0, end = len - 1;
        while(start < len - 1 && height[start] == 0) {
            start++;
        }

        int leftMaxHeight = height[start];
        int leftCursor = start + 1;
        int leftTempVolum = 0;

        while(end > 0 && height[end] == 0) {
            end--;
        }
        int rightMaxHeight = height[end];
        int rightCursor = end - 1;
        int rightTempVolum = 0;

        if(start >= len - 1 || end < 2 ) {
            return 0;
        }

        while(start < end ) {
            //left fo first --->
            while(leftCursor < len && height[leftCursor] < leftMaxHeight ){
                leftTempVolum -= height[leftCursor];
                leftCursor++;
            }if(leftCursor < len && height[leftCursor] >= leftMaxHeight ){
                leftTempVolum += (leftCursor - start - 1) * leftMaxHeight;
                volum += leftTempVolum;
                start = leftCursor;
                leftMaxHeight = height[leftCursor];
                leftTempVolum = 0;
                leftCursor++;
            }
            if(start >= len - 1 && volum != 0) {
                return volum;
            }

            //then right go <---
            while(rightCursor >= 0 && height[rightCursor] < rightMaxHeight && start < end){
                rightTempVolum -= height[rightCursor];
                rightCursor--;
            }
            if(rightCursor >= 0 && height[rightCursor] >= rightMaxHeight && start < end){
                rightTempVolum += (end - rightCursor  - 1) * rightMaxHeight;
                volum += rightTempVolum;
                end = rightCursor;
                rightMaxHeight = height[rightCursor];
                rightTempVolum = 0;
            }
            rightCursor--;

        }
        return volum;
    }

    public static void main(String[] args) {
        int[] height = {0,1,1,1,0};
        System.out.println(trap(height));
    }

}
