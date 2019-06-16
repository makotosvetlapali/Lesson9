package org.curiousworks.lesson9;

public class Character {
    private String characterName;
    private String allegiance;
    private String messageFile;

    public Character(String characterName, String allegiance, String messageFile) {
        this.characterName = characterName;
        this.allegiance = allegiance;
        this.messageFile = messageFile;
    }

    public String getCharacterName() {
        return characterName;
    }

    public String getMessageFile() {
        return messageFile;
    }

    @Override
    public String toString() {
        return "Character{" +
                "characterName='" + characterName + '\'' +
                ", allegiance='" + allegiance + '\'' +
                ", messageFile='" + messageFile + '\'' +
                '}';
    }
}
