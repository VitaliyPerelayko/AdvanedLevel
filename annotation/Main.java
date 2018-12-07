package annotation;


import java.util.Random;

public class Main {
    private int field =25;
    private Random random = new Random();

    @TimeForMethod
    public void isEqual(){
        while (random.nextInt(1000000)!= field){
        }
        System.out.println("end");
    }

    public static void main(String[] args)  {

        Main main= new Main();
        try {
            AnnotationsInvocationHandler.invoke(main,"isEqual");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

        NoAnnotation noAnnotation = new NoAnnotation();
        try {
            String text = (String) AnnotationsInvocationHandler.invoke(noAnnotation,"getText",5);
            System.out.println(text);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

    }
}
