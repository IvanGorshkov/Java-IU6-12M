package com.java.lab;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.stream.Collectors;

// В следующих заданиях требуется ввести последовательность строк из текстового потока и выполнить указанные действия. При этом могут рассматриваться два варианта:
// • каждая строка состоит из одного слова;
// • каждая строка состоит из нескольких слов.
//Имена входного и выходного файлов, а также абсолютный путь к ним могут быть введены как параметры командной строки или храниться в файле.
// В каждой строке стихотворения Анны Ахматовой подсчитать частоту повторяемости каждого слова из заданного списка и вывести эти слова в порядке возрастания частоты повторяемости.
public class Main {

    public static void main(String[] args) throws IOException {

        File file_in = new File("/Users/ivangorshkov/Documents/BMSTU/BigDataJava/Java-IU6-12M/Lab5/Z5/in.txt");
        Path path = Paths.get("/Users/ivangorshkov/Documents/BMSTU/BigDataJava/Java-IU6-12M/Lab5/Z5/out.txt");
        Scanner in = new Scanner(file_in);
        int k = 1;
        while(in.hasNextLine()) {
            var wordsKeys = new String[] {"ним", "спокойно", "я"};
            String line = in.nextLine();
            String[] words = line.split(" ");
            var lineCountWords = filling(words);
            Map<String, Integer> linkedHashMap = new LinkedHashMap<>();

            for (Map.Entry<String, Integer> employee : lineCountWords.entrySet()) {
                if (Arrays.stream(wordsKeys).anyMatch(v -> v.toLowerCase().contains(employee.getKey().toLowerCase())) &&  employee.getKey().length() != 0){
                    linkedHashMap.put(employee.getKey(), employee.getValue());
                }
            }
            Map<String, Integer> sortedMap = linkedHashMap.entrySet().
                    stream().
                    sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).
                    collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

            if (k == 1) {
                Files.write(path, Collections.singleton(sortedMap.toString()), StandardCharsets.UTF_8);
            } else {
                Files.write(path, Collections.singleton(sortedMap.toString()), StandardCharsets.UTF_8, StandardOpenOption.APPEND);
            }
            k += 1;
        }
    }

    public static Map<String, Integer> filling(String[] words) {
        Map<String, Integer> m = new HashMap<>();
        for (String word : words) {
            m.put(word, m.get(word) == null ? 1 : m.get(word) + 1);
        }
        return m;
    }
}