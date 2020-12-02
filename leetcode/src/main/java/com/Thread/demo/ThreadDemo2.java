package com.Thread.demo;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ThreadDemo2 extends Thread{
    private String url;
    private String name;

    public ThreadDemo2(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        WebDownload webDownload = new WebDownload();
        webDownload.downloader(url, name);
        System.out.println("下载了文件" + name);
    }

    public static void main(String[] args) {
        Thread t1 = new ThreadDemo2("https://ns-strategy.cdn.bcebos.com/ns-strategy/upload/fc_big_pic/part-00666-2712.jpg", "1.jpg");
        Thread t2 = new ThreadDemo2("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=1582373193,2567665585&fm=26&gp=0.jpg", "2.jpg");
        Thread t3 = new ThreadDemo2("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3948485664,2431734131&fm=26&gp=0.jpg", "3.jpg");

        t1.start();
        t2.start();
        t3.start();
    }
}

class WebDownload {
    public void downloader(String url, String name) {
        try {
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}