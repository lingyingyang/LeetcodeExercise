package leetcode.tree.prolemsolving;

import leetcode.tree.TreeNode;
import org.junit.jupiter.api.Test;
import util.NodeUtil;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CodecTest {
    @Test
    void test() {
        Codec test = new Codec();
        String out = test.serialize(NodeUtil.getInstance());
        System.out.println(out);
        assertEquals("1,X,2,3,X,X,X,", out);
        TreeNode root = test.deserialize(out);
        NodeUtil.print(root);
    }
}