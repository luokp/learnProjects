package com.luokp;

import com.luokp.models.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: luokp
 * @date: 2019/4/3 20:04
 * @description:
 */
public class _113PathSUm {

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        pathSumCore(root, sum, result, list);
        return result;
    }

    private static void pathSumCore(TreeNode root, int sum, List<List<Integer>> result, List<Integer> list) {
        if(root == null ) {return;}
        if(root.val == sum) {
            list.add(root.val);
            if(root.right == null && root.left == null) {
                result.add(new ArrayList(list));
            }
            list.remove(list.size()-1);
            return;
        }
        list.add(root.val);
        pathSumCore(root.left, sum-root.val, result, list);
        pathSumCore(root.right, sum-root.val, result, list);
        list.remove(list.size()-1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-2);
        root.left = null;
        root.right = new TreeNode(-3);
        System.out.println(pathSum(root, -5));

    }
}
