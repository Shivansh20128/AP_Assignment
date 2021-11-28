package com.brickBracker;

public class Generic <T>{
    private final T param1;
    private final T param2;
    public Generic(T input1,T input2){
        this.param1=input1;
        this.param2=input2;
    }
    public int divide() throws ArithmeticException{
        try {
            return (int) param1 / (int) param2;
        }catch(ArithmeticException ae){
            System.out.println("Oops! Zero division error. As this is our fault, you can enter -1 to win the prize!!");
        }
        return -1;
    }
     public String join(){
         return param1.toString().concat(param2.toString());
     }
}
