package top.yunp.ts.models;

/**
 * Created by plter on 5/22/17.
 */
public class User extends AbstractModel {


    public User() {
    }

    public User(String name, int age, String gender) {
        setName(name);
        setAge(age);
        setGender(gender);
    }

    public User(String json) {
        super(json);
    }

    public String getName() {
        return getJsonObject().getString("name");
    }

    public void setName(String name) {
        getJsonObject().put("name", name);
    }

    public int getAge() {
        return getJsonObject().getInt("age");
    }

    public void setAge(int age) {
        getJsonObject().put("age", age);
    }

    public String getGender() {
        return getJsonObject().getString("gender");
    }

    public void setGender(String gender) {
        getJsonObject().put("gender", gender);
    }
}
