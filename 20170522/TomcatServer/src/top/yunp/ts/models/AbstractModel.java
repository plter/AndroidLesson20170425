package top.yunp.ts.models;

import org.json.JSONObject;

/**
 * Created by plter on 5/22/17.
 */
public abstract class AbstractModel {


    private JSONObject jsonObject;

    public AbstractModel() {
        jsonObject = new JSONObject();
    }

    public AbstractModel(String json) {
        this.jsonObject = new JSONObject(json);
    }

    public JSONObject getJsonObject() {
        return jsonObject;
    }

    @Override
    public String toString() {
        return getJsonObject().toString();
    }
}
