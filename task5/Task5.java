package topic2.task5;

import java.util.Locale;
import java.util.ResourceBundle;

/**     Задание 5. Создать программу, которая может приветствовать пользователя на трёх
 * языквх: английском, русском, белоруском. Требуемый язык и страна должны сообщаться программе в
 * качестве входных параметров. Если входные параметры отсутствуют, программа должна выдавать
 * сообщение на английском.
 *
 */

public class Task5 {
    private static final String NAME_PROPERTIES = "topic2.task5.messages";
    public static void getMessage(String message){
        ResourceBundle resourceBundle =
                ResourceBundle.getBundle(NAME_PROPERTIES,new Locale("en"));
        System.out.println(resourceBundle.getString(message));

    }
    public static void getMessage(String languageCode,String message){
        ResourceBundle resourceBundle =
                ResourceBundle.getBundle(NAME_PROPERTIES,new Locale(languageCode));
        System.out.println(resourceBundle.getString(message));
    }
    public static void main(String[] args) {
        getMessage("greetings");
        getMessage("goodbye");

        getMessage("de","greetings");
        getMessage("de","goodbye");

        getMessage("en","greetings");
        getMessage("en","goodbye");

        getMessage("ru","greetings");
        getMessage("ru","goodbye");

        getMessage("by","greetings");
        getMessage("by","goodbye");

    }
}
