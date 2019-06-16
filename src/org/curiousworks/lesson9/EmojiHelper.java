package org.curiousworks.lesson9;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EmojiHelper {
    private static List<String> unicodes = List.of("\uD83D\uDE0D", "\uD83D\uDE18", "\uD83E\uDD74", "\uD83D\uDE1E",
            "\uD83D\uDE22", "\uD83D\uDC78", "\uD83D\uDC7F", "\uD83D\uDE42", "\uD83D\uDC09", "\uD83D\uDE2D",
            "\uD83E\uDD2C", "\uD83C\uDF51", "\uD83D\uDE04", "\uD83D\uDCAA\uD83C\uDFFB", "\uD83E\uDD14");

    private static List<Emoji> loadEmojis() {
        List<Emoji> emojis = new ArrayList<>();
        emojis.add(new Emoji("Smiling Face With Heart-Shaped Eyes", unicodes.get(0), Disposition.HAPPY));
        emojis.add(new Emoji("Smiling Face With Heart-Shaped Eyes", unicodes.get(0), Disposition.LOVING));
        emojis.add(new Emoji("Face Throwing a Kiss", unicodes.get(1), Disposition.LOVING));
        emojis.add(new Emoji("Face With Uneven Eyes and Wavy Mouth", unicodes.get(2), Disposition.NONE));
        emojis.add(new Emoji("Disappointed Face", unicodes.get(3), Disposition.NONE));
        emojis.add(new Emoji("Crying Face", unicodes.get(4), Disposition.SAD));
        emojis.add(new Emoji("Princess", unicodes.get(5), Disposition.NONE));
        emojis.add(new Emoji("Angry Face With Horns", unicodes.get(6), Disposition.SAD));
        emojis.add(new Emoji("Slightly Smiling Face", unicodes.get(7), Disposition.HAPPY));
        emojis.add(new Emoji("Dragon", unicodes.get(8), Disposition.NONE));
        emojis.add(new Emoji("Loudly Crying Face", unicodes.get(9), Disposition.SAD));
        emojis.add(new Emoji("Face With Symbols on Mouth", unicodes.get(10), Disposition.NONE));
        emojis.add(new Emoji("Peach", unicodes.get(11), Disposition.NONE));
        emojis.add(new Emoji("Grinning Face With Smiling Eyes", unicodes.get(12), Disposition.HAPPY));
        emojis.add(new Emoji("Flexed Biceps", unicodes.get(13), Disposition.NONE));
        emojis.add(new Emoji("Thinking Face", unicodes.get(14), Disposition.NONE));
        return emojis;
    }

    public static List<Emoji> loadHappyEmojis() {
        return loadEmojis().stream().filter(emoji -> emoji.getDisposition().equals(Disposition.HAPPY)).collect(Collectors.toList());
    }
    public static List<Emoji> loadSadEmojis() {
        return loadEmojis().stream().filter(emoji -> emoji.getDisposition().equals(Disposition.SAD)).collect(Collectors.toList());
    }
    public static List<Emoji> loadLovingEmojis() {
        return loadEmojis().stream().filter(emoji -> emoji.getDisposition().equals(Disposition.LOVING)).collect(Collectors.toList());
    }
}
