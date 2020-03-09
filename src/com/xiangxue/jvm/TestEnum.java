package com.xiangxue.jvm;

/**
 * @ClassName FoodBuilder
 * @Description TODO
 * @Author 郭洪昌  枚举类中的双重用法
 * @Date 2020/3/9 11:14
 * @Version 1.0
 */
public enum TestEnum {

        A(Test2.type1),B(Test2.type2);
        private Test2  test2;

        TestEnum(Test2  test2) {
            this.test2 =test2;
        }
        Integer getValue() {
            return test2.getValue();
        }

        private enum  Test2 {
            type1 {
                @Override
                Integer getValue() {
                    return null;
                }
            }, type2 {
                @Override
                Integer getValue() {
                    return null;
                }
            };

            abstract Integer getValue();
        }

}
