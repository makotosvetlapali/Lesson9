package org.curiousworks.lesson9;

public class Emoji {
    private String name;
    private String unicode;
    private Disposition disposition;

    public Emoji(String name, String unicode, Disposition disposition) {
        this.name = name;
        this.unicode = unicode;
        this.disposition = disposition;
    }

    public String getUnicode() {
        return unicode;
    }

    public Disposition getDisposition() {
        return disposition;
    }
}
