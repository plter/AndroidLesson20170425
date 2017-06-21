package top.yunp.readquestions;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            QuestionsReader reader = new QuestionsReader(this, R.raw.questions);

            for (Question q : reader.getQuestions()) {
                System.out.println("Question start");
                System.out.println(q.getTitle());
                System.out.println(q.getA());
                System.out.println(q.getB());
                System.out.println(q.getC());
                System.out.println(q.getD());
                System.out.println(q.getAnswer());
                System.out.println("Question end");
            }

        } catch (SAXException e) {
            e.printStackTrace();
        }
    }
}
