package top.yunp.addusers.models;

/**
 * Created by plter on 6/8/17.
 */

public class UserGroup {

    private int id;
    private String name;

    public UserGroup(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getName();
    }
}
