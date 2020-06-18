package introspector;

import leetcode.tree.TreeNode;

import java.beans.*;

public class IntrospectorDemo {
    public static void main(String[] args) throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(TreeNode.class);
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        MethodDescriptor[] methodDescriptors = beanInfo.getMethodDescriptors();
        BeanDescriptor beanDescriptor = beanInfo.getBeanDescriptor();
        for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
            System.out.println(propertyDescriptor.getName() + " " + propertyDescriptor.getReadMethod());
        }
        System.out.println("========");
        for (MethodDescriptor methodDescriptor : methodDescriptors) {
            System.out.println(methodDescriptor.getName());
        }

    }
}
