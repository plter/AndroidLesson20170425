import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * Created by plter on 5/17/17.
 */
public class Main {

    public static void main(String[] args) {

        try {
            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File("data.xml"));

            NodeList students = document.getElementsByTagName("student");
            Node student = students.item(0);

            //trim 函数是用于去除字符串首部与尾部不呈现的字符
            System.out.println(student.getTextContent().trim());


//            Node root = document.getFirstChild();
//
//            Node node = root.getFirstChild();
//            do {
//                System.out.println(node);
//            } while ((node = node.getNextSibling()) != null);

        } catch (SAXException | ParserConfigurationException | IOException e) {
            e.printStackTrace();
        }

    }
}
