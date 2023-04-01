package com.java.lab;

// В предложении из n слов первое слово поставить на место второго, второе – на место третьего, и т.д., (n-1)-е слово – на место n-го, n-е слово поставить на место первого. В исходном и преобразованном предложениях между словами должны быть или один пробел, или знак препинания и один пробел.
public class Main {
    public static void main(String[] args) {
        var sentence = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce luctus.";
        System.out.println(sentence);

        var words = sentence.split("\\s+");
        var offsetWords = new String[words.length];

        for (int i = 0; i < words.length; i++) {
            int newIndex = i == words.length - 1 ? 0 : i + 1;
            offsetWords[newIndex] = words[i];
        }

        var offsetSentence = new StringBuilder();
        for (String reversedWord : offsetWords) {
            offsetSentence.append(reversedWord).append(" ");
        }
        System.out.println(offsetSentence);
    }
}
