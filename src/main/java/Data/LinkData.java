package Data;

import Controller.SceneController.LinkListController;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONObject;
import org.json.JSONTokener;

import Object.Link;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LinkData {

    private static ArrayList<Link> LinkList;

    public LinkData() {
        getLinkListData();
    }

    public void getLinkListData() {
        LinkList = new ArrayList<>();
        InputStream is = LinkListController.class.getResourceAsStream("/Links.json");
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        JSONTokener jt = new JSONTokener(reader);
        JSONObject jo = new JSONObject(jt);
        for (String key : jo.keySet()) {
            Link link = new Link(jo.get(key).toString(), key);
            LinkList.add(link);
        }
        Collections.sort(LinkList, new LinkListSort());
    }

    public List<Link> getLinkList() {
        return LinkList;
    }

}
