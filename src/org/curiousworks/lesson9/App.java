package org.curiousworks.lesson9;

import javax.swing.*;
import java.util.*;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //TASK 1
        List<Character> characters = new ArrayList<>();
        Arrays.stream(FileHelper.loadMetaData().split(System.getProperty("line.separator")))
                .skip(1)
                .forEach(line -> {
                    String[] characterItems = line.split(", ");
                    String characterName = characterItems[0];
                    String allegiance = characterItems[1];
                    String messageFile = characterItems[2];
                    characters.add(new Character(characterName, allegiance, messageFile));
                });
        System.out.println("\nTASK 1. Print all Characters data:");
        System.out.println(characters);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //TASK 2
        Map<String, List<String>> characterMessages = new HashMap<>();
        characters.forEach(character -> characterMessages.put(character.getCharacterName(), new ArrayList<>()));
        characters.forEach(character ->
            characterMessages
                    .put(character.getCharacterName(),
                            FileHelper.loadMessages(character.getMessageFile())
                            .stream()
                            .skip(1)
                            .filter(message -> !message.isEmpty())
                            .collect(Collectors.toList())));
        System.out.println("\nTASK 2. Print all Daenerys' messages:");
        System.out.println(characterMessages.get("Daenerys Stormborn"));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //TASK 3
        StringBuilder numberOfMessagePerCharacter = new StringBuilder();
        characterMessages.entrySet().forEach(entry ->
            numberOfMessagePerCharacter
                    .append(entry.getKey() + " has sent : " + entry.getValue().size() + " messages \n")
        );
        System.out.println("\nTASK 3. Results are showing in JPane...");
        JOptionPane.showMessageDialog(null, numberOfMessagePerCharacter.toString());
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //TASK 4
        int happyCounter;
        int sadCounter;

        happyCounter = getDispositionCounterForCharacter(characterMessages, "Tyrion Lannister",
                EmojiHelper.loadHappyEmojis());
        sadCounter = getDispositionCounterForCharacter(characterMessages, "Tyrion Lannister",
                EmojiHelper.loadSadEmojis());

        System.out.println("\nTASK 4. Print Tyrion's disposition:");
        if (happyCounter > sadCounter) {
            System.out.println("Tyrion has a positive disposition");
        } else {
            System.out.println("Tyrion has a negative disposition");
        }
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //TASK 5
        Character characterWithMostPositiveDisposition = null;
        Character characterWithMostNegativeDisposition = null;
        int mostPositiveDispositionCounter = 0;
        int mostNegativeDispositionCounter = 0;

        for (Character character : characters) {
            happyCounter = getDispositionCounterForCharacter(characterMessages, character.getCharacterName(),
                    EmojiHelper.loadHappyEmojis());
            sadCounter = getDispositionCounterForCharacter(characterMessages, character.getCharacterName(),
                    EmojiHelper.loadSadEmojis());
            if (happyCounter > mostPositiveDispositionCounter) {
                mostPositiveDispositionCounter = happyCounter;
                characterWithMostPositiveDisposition = character;
            }
            if (sadCounter > mostNegativeDispositionCounter) {
                mostNegativeDispositionCounter = sadCounter;
                characterWithMostNegativeDisposition = character;
            }
        }
        System.out.println("\nTASK 5.");
        System.out.println("Print character with the most positive disposition: "
                + characterWithMostPositiveDisposition.getCharacterName());
        System.out.println("Print character with the most negative disposition: "
                + characterWithMostNegativeDisposition.getCharacterName());
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //TASK 6
        int lovingCounterJon = getDispositionCounterForCharacter(characterMessages, "Jon Snow",
                EmojiHelper.loadLovingEmojis());
        int lovingCounterDaenerys = getDispositionCounterForCharacter(characterMessages, "Daenerys Stormborn",
                EmojiHelper.loadLovingEmojis());
        System.out.println("\nTASK 6.");
        if (lovingCounterJon > lovingCounterDaenerys) {
            System.out.println("Jon loves Daenerys more than she loves him");
        } else {
            System.out.println("Daenerys loves Jon more than he loves her or they are equal");
        }
    }

    private static int getDispositionCounterForCharacter(Map<String, List<String>> characterMessages,
                                                         String characterName, List<Emoji> dispositionEmojis) {
        int counter = 0;
        for (String message : characterMessages.get(characterName)) {
            for (Emoji emoji : dispositionEmojis) {
                counter = counter + message.split(emoji.getUnicode(), -1).length - 1;
            }
        }
        return counter;
    }
}
