package Data;

import Object.Link;

import java.util.Comparator;

public class LinkListSort implements Comparator<Link> {
    public int compare(Link link1, Link link2) {
        return link1.getTitle().compareTo(link2.getTitle());
    }
}
