package org.moonzhou.backend.base.dmo;

/**
 * @Description 通用测试类
 * @Author moon-zhou <ayimin1989@163.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/8/3
 */
public class Test {
    public static void main(String[] args) {
        Test test = new Test();

        System.out.println(test.getClass().getName());
        System.out.println(Test.class.getName());
        System.out.println(Test.class.getResource(""));

        String classPath = Test.class.getName();
        System.out.println(classPath.substring(0, classPath.lastIndexOf(".")));
    }
}
