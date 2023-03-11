package com.java.lab;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

// При выполнении следующих заданий для вывода результатов создавать новую директорию и файл средствами класса File
// 7. Прочитать текст Java-программы и удалить из него все “лишние” пробелы и табуляции, оставив только необходимые для разделения операторов.
public class Main {
 public static void main(String[] args) throws IOException {
 File file_in = new File("/Users/ivangorshkov/Documents/BMSTU/BigDataJava/Java-IU6-12M/Lab5/Z8/in.java");
 Path path = Paths.get("/Users/ivangorshkov/Documents/BMSTU/BigDataJava/Java-IU6-12M/Lab5/Z8/directory/out.txt");
 File theDir = new File("/Users/ivangorshkov/Documents/BMSTU/BigDataJava/Java-IU6-12M/Lab5/Z8/directory");
 if (!theDir.exists()){
 theDir.mkdir();
 }

 Scanner in = new Scanner(file_in);
 int k = 1;

 while(in.hasNextLine()) {
 String line = in.nextLine();
 StringBuilder stringBuilder = new StringBuilder();

 if ( line.length() > 0) {
 stringBuilder.append(modifyLine(line)).append("\n");
 }

 if (k == 1) {
 Files.write(path, Collections.singleton(stringBuilder.toString()), StandardCharsets.UTF_8);
 } else {
 Files.write(path, Collections.singleton(stringBuilder.toString()), StandardCharsets.UTF_8, StandardOpenOption.APPEND);
 }
 k += 1;
 }
 }

 private static String modifyLine(String line) {
 return line
 .replaceAll("\\s+", " ")
 .replaceAll("\\t+", "\t")
 .replaceAll("\\n+", "\n")
 .replaceAll("\\r+", "\r");
 }
}
