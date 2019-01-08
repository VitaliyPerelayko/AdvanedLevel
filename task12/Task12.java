package topic4XML.task12;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.IOException;

/** Задание 12. Напишите программу преобразующую созданный в преыдущих заданиях * файл в *,
 * аналогично данному примеру, в каждой ячейке дополнительно к координате должны выводится
 * еденицы измерения. Результат должен записываться в файл на диск.
 *
 */

public class Task12 {
    public static final String PATHtoXSLT ="E:\\Работа\\Віталюга\\It-academi\\AdvancedLevel\\src\\topic4XML\\task12\\Task12XSLT.xsl";
    public static final String PATHtoXML ="E:\\Работа\\Віталюга\\It-academi\\AdvancedLevel\\src\\topic4XML\\PointList.xml";

    public static void main(String[] args) {
        File HTMLresult = new File("pointList.html");
        try {
            HTMLresult.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Transformer transformer = TransformerFactory.
                    newInstance().
                    newTransformer(new StreamSource(
                            new File(PATHtoXSLT)));
            transformer.transform(new StreamSource(new File(PATHtoXML)),new StreamResult(HTMLresult));
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(HTMLresult.getCanonicalPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
