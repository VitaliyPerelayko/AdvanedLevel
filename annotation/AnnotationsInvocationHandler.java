package annotation;


import java.lang.reflect.Method;
import java.time.Duration;
import java.time.Instant;


public class AnnotationsInvocationHandler  {

    //статический метод выполняющий нужный метод переданного объекта
    public static Object invoke(Object object, String method1, Object... args) throws Throwable {
        Method method = methodFromMethodName(object,method1);

        if(method.isAnnotationPresent(TimeForMethod.class)) {

            Instant start = Instant.now();
            Object returnObj = method.invoke(object, args);
            Instant end = Instant.now();

            System.out.println("Method " + method.getName() + " executed in " + Duration.between(start,end));

            return returnObj;
        }

        return method.invoke(object, args);
    }
    //Возвращает метод по его имени
    private static Method methodFromMethodName(Object object, String name){
        Method[] methods = object.getClass().getMethods();
        int result =0;
        for (int i=0;i<methods.length;i++){
            if (methods[i].getName().contains(name)){
                result=i;
                break;
            }
        }
        return methods[result];
    }
}
