package topic4XML;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/** Задание 10. Напишите программу, которая будет разбирать XML файл сделанный в предыдущих заданиях
 *  с помощью DOM, и будет выводить его на экран в текстовом виде. Каждая точка должна выводиться
 *  на отдельной строке в виде двух чисел, разделённых запятой, при этом должна выводиться еденица
 *  измерения. Например: 10px, 30px
 */

public class Task10 {
    private final static String PATH="E:\\Работа\\Віталюга\\It-academi\\AdvancedLevel\\src\\topic4XML\\PointList.xml";

    public static void main(String[] args) {
        //List<Point> pointList = new ArrayList<>();
        File xmlFile = new File(PATH);
        try {
            Document xmlDoc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(xmlFile);
            xmlDoc.getDocumentElement().normalize();
            NodeList nodeList = xmlDoc.getElementsByTagName("point");
            for (int i=0;i<nodeList.getLength();i++){
                //pointList.add(getPoint(nodeList.item(i)));
                System.out.println(getPoint(nodeList.item(i)));
            }
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = nodeList.item(0);
        return node.getNodeValue();
    }

    private static Point getPoint(Node node) {
        Point point = new Point();
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            point.unit=(getTagValue("unit", element));
            point.x= Integer.parseInt(getTagValue("x", element));
            point.y=Integer.parseInt(getTagValue("y", element));
        }

        return point;
    }

    static class Point {
        private int x;
        private int y;
        private String unit;

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public String getUnit() {
            return unit;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }

        public void setUnit(String unit) {
            this.unit = unit;
        }

        @Override
        public String toString() {
            return  x+unit+", "+y+unit;
        }
    }
}
