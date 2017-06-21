package top.yunp.readquestions;

import android.content.Context;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Created by plter on 6/21/17.
 */

public class QuestionsReader {

    private Document document;
    private List<Question> questions = new ArrayList<>();


    public QuestionsReader(Context context, int resid) throws SAXException {
        try {
            document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(context.getResources().openRawResource(resid));
            NodeList questionsNodeList = document.getElementsByTagName("question");
            Node questionNode;
            for (int i = 0; i < questionsNodeList.getLength(); i++) {
                questionNode = questionsNodeList.item(i);

                NodeList childNodes = questionNode.getChildNodes();
                Node child;
                Map<String, String> childrenMap = new HashMap<>();
                for (int j = 0; j < childNodes.getLength(); j++) {
                    child = childNodes.item(j);
                    if (!child.getNodeName().equals("#text")) {
                        childrenMap.put(child.getNodeName(), child.getTextContent().trim());
                    }
                }
                questions.add(new Question(
                                childrenMap.get("title"),
                                childrenMap.get("a"),
                                childrenMap.get("b"),
                                childrenMap.get("c"),
                                childrenMap.get("d"),
                                childrenMap.get("answer"),
                                childrenMap.get("type")
                        )
                );
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    public List<Question> getQuestions() {
        return questions;
    }
}
