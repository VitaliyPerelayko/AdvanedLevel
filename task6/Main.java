package topic3.task6;

/** Задание 6. Создать простейший логер, выводящий сообщения об ошибках в текстовый файл.
 *  Объект логера дожен быть создан с помощью ШП Singleton. У объекта должен быть обязательно
 *  один метод, получающий на вход текст сообщения об ошибке и записывающий его в файл вместе с
 *  информацией о дате и времени проишествия.
 *
 */

import java.io.FileInputStream;

public class Main {
    public static void main(String[] args) {

        LogRegister logRegister = LogRegister.getLogRegister();
        logRegister.aadInfo("LogFile is created");

        try {
            //Вызываю ошибку
            FileInputStream fileOutputStream = new FileInputStream(".\\bla.bla");

        } catch (Exception e) {
            logRegister.aadInfo(LogRegister.ExceptionToString(e));
        }

        try {
            //Вызываю ошибку
            throw new InterruptedException();
        }catch (Exception e){
            logRegister.aadInfo(LogRegister.ExceptionToString(e));
        }
        //Путь к файлу
        System.out.println("Path to logFile:\n"+logRegister.getPath());
    }



}
