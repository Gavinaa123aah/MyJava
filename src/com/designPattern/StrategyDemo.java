package com.designPattern;

interface Strategy{
    public int doOperation(int num1, int num2);
}

class OperationAdd implements Strategy{
    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}

class OperationSubstract implements Strategy{
    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}

class OperationMultiply implements Strategy{
    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
}

class Context{
    private Strategy strategy;
    public Context(Strategy strategy){
        this.strategy=strategy;
    }
    public int executeStrategy(int num1, int num2){
        return strategy.doOperation(num1, num2);
    }
}

public class StrategyDemo {
    public static void main(String[] args) {
        Context context = new Context(new OperationAdd());
        System.out.println(context.executeStrategy(5,5));
        Context contextA = new Context(new OperationMultiply());
        System.out.println(contextA.executeStrategy(5,5));
        Context contextB = new Context(new OperationSubstract());
        System.out.println(contextB.executeStrategy(5,5));

    }


}
