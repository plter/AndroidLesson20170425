package top.yunp.readquestions;

/**
 * Created by plter on 6/21/17.
 */

public class Question {

    private String title, a, b, c, d, answer, type;

    public Question(String title, String a, String b, String c, String d, String answer, String type) {
        this.title = title;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.answer = answer;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public String getA() {
        return a;
    }

    public String getB() {
        return b;
    }

    public String getC() {
        return c;
    }

    public String getD() {
        return d;
    }

    public String getAnswer() {
        return answer;
    }

    public String getType() {
        return type;
    }
}
