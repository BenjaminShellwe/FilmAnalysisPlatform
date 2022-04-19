package com.bap;


/*
 * Copyright from TernaryProject (c) 2022.
 * Author BenjaminThomasShellwe
 * Date 2022/4/17 9:45:46
 */

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Method;
import java.lang.reflect.ReflectPermission;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class BapAdminApplicationTests {


    @Test
    void contextLoads(){

    }
//    void contextLoads() {
//
///**
// *      这是一个简单的检测类中定义方法的工具 仅输出方法名
// */
//        Class c = JpaRepository.class;
//        Method[] m = c.getDeclaredMethods();
//        for (int i = 0; i < m.length; i++) {
//            System.out.println(m[i].getName());
//        }
////      检测类工具 返回整个类方法,且输出 源码在最后
//        getClassMethods(c);
//
////      简单的检测类中定义工具 类推
//        Class c1 = GetInfoService.class;
//        Method[] m1 = c1.getDeclaredMethods();
//        for (int i = 0; i < m1.length; i++) {
//            System.out.println(m1[i].getName());
//        }
///**
// *      获取方法名即可输出
// *      Service层服务类似DAO层中所继承的JpaRepository
// *      区别在于JpaRepository已经定义好方法直接调用
// *            Service层中服务则需要重新声明与定义
// *
// *      以下则是对应示例
// */
//        Result result = getInfoService.getByIdEn(20220001);
//        System.out.println( "result = " + result +
//                            "hashCode() = " + getInfoService.hashCode() +
//                            "getClass()" + getInfoService.getClass()
//        );
//        Result result1 = getInfoService.getByIdPe(20220001);
//        System.out.println("result1 = " + result1);
//        Result result2 = globalDicService.queryAll();
//        System.out.println("result2 = " + result2);
//        Result result3 = globalDicService.getByTypeName("证件类型");
//        System.out.println("result3 = " + result3);
//        Result result4 = systemLogEventService.queryAll();
//        System.out.println("result4 = " + result4);
//        Result result5 = monitorService.queryAll();
//        System.out.println("result4 = " + result5);
//        Result result6 = performanceService.queryAll();
//        System.out.println("result4 = " + result6);
//        Result result7 = vacancyComingService.queryAll();
//        System.out.println("result4 = " + result7);
//        Result result8 = vacancyService.queryAll();
//        System.out.println("result4 = " + result8);
//    }



    private Method[] getClassMethods(Class<?> cls) {
        Map<String, Method> uniqueMethods = new HashMap<String, Method>();
        Class<?> currentClass = cls;
        while (currentClass != null && currentClass != Object.class) {
            addUniqueMethods(uniqueMethods, currentClass.getDeclaredMethods());

            //获取接口中的所有方法
            Class<?>[] interfaces = currentClass.getInterfaces();
            for (Class<?> anInterface : interfaces) {
                addUniqueMethods(uniqueMethods, anInterface.getMethods());
            }
            //获取父类，继续while循环
            currentClass = currentClass.getSuperclass();
        }

        Collection<Method> methods = uniqueMethods.values();
        System.out.println("methods = " + methods);
        return methods.toArray(new Method[methods.size()]);
    }

    private void addUniqueMethods(Map<String, Method> uniqueMethods, Method[] methods) {
        for (Method currentMethod : methods) {
            if (!currentMethod.isBridge()) {
                //获取方法的签名，格式是：返回值类型#方法名称:参数类型列表
                String signature = getSignature(currentMethod);
                //检查是否在子类中已经添加过该方法，如果在子类中已经添加过，则表示子类覆盖了该方法，无须再向uniqueMethods集合中添加该方法了
                if (!uniqueMethods.containsKey(signature)) {
                    if (canControlMemberAccessible()) {
                        try {
                            currentMethod.setAccessible(true);
                        } catch (Exception e) {
                        }
                    }
                    uniqueMethods.put(signature, currentMethod);
                }
            }
        }
    }

    private String getSignature(Method method) {
        StringBuilder sb = new StringBuilder();
        Class<?> returnType = method.getReturnType();
        if (returnType != null) {
            sb.append(returnType.getName()).append('#');
        }
        sb.append(method.getName());
        Class<?>[] parameters = method.getParameterTypes();
        for (int i = 0; i < parameters.length; i++) {
            if (i == 0) {
                sb.append(':');
            } else {
                sb.append(',');
            }
            sb.append(parameters[i].getName());
        }
        return sb.toString();
    }

    /**
     * 检查是否可以访问控制成员变量。
     * @return 若可访问, 即可返回 {@literal true}
     */
    public static boolean canControlMemberAccessible() {
        try {
            SecurityManager securityManager = System.getSecurityManager();
            if (null != securityManager) {
                securityManager.checkPermission(new ReflectPermission("suppressAccessChecks"));
            }
        } catch (SecurityException e) {
            return false;
        }
        return true;
    }
}
