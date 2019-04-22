package com.luokp;

import com.luokp.models.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: luokp
 * @date: 2019/4/17 17:40
 * @description:
 */
public class _173BSTIterator {
    private Queue<Integer> queue;
    private TreeNode root;

    public _173BSTIterator(TreeNode root) {
        this.root = root;
        this.queue = new LinkedList<>();
        travel(root);

    }

    private void travel(TreeNode node){
        if(node == null) {
            return;
        }
        if(node.left == null && node.right == null) {
            queue.offer(node.val);
            return;
        }
        if(node.left != null) {
            travel(node.left);
        }
        queue.offer(node.val);
        if(node.right != null) {
            travel(node.right);
        }
    }


    /** @return the next smallest number */
    public int next() {
        return queue.poll();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}
