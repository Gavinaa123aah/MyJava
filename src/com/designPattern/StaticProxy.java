package com.designPattern;

public class StaticProxy {
    public static void main(String[] args){
        BookStore realBookStore = new RealBookStore();
        BookStore proxyBookStore = new ProxyBookStore(realBookStore);
        proxyBookStore.sell();
        proxyBookStore.ad();
    }
}

interface BookStore{
    void sell();
    void ad();
}

class RealBookStore implements BookStore{
    @Override
    public void sell() {
        System.out.println("i'm selling");
    }

    @Override
    public void ad() {
        System.out.println("i'm advertising");
    }
}

class ProxyBookStore implements BookStore{

    private BookStore bookStore;
    public ProxyBookStore(BookStore bookStore){
        this.bookStore = bookStore;
    }
    @Override
    public void sell() {
        System.out.println("before");
        bookStore.sell();
        System.out.println("after");
    }

    @Override
    public void ad() {
        System.out.println("before");
        bookStore.ad();
        System.out.println("after");
    }
}