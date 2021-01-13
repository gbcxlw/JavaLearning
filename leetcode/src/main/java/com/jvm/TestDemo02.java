package com.jvm;

public class TestDemo02 {
    public static void main(String[] args) {
        long maxMemory = Runtime.getRuntime().maxMemory();   //jvm试图申请使用的最大内存
        long totalMemory = Runtime.getRuntime().totalMemory();   //jvm

        System.out.println("max=" + maxMemory + "字节 " + (double)(maxMemory/1024/1024) + "MB");
        System.out.println("max=" + totalMemory + "字节 " + (double)(totalMemory/1024/1024) + "MB");

        //OOM异常处理思路
            //1. 尝试扩大堆内存看结果
            //2. 分析内存，看一下那个地方出现了问题（专业工具）
        //-Xms1024m -Xmx1024m -XX:+PrintGCDetails
    }
}
