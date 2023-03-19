package com.java.lab;

import java.awt.geom.Line2D;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

// 6 На плоскости задано N точек. Вывести в файл описания всех прямых, которые проходят более чем через одну точку из заданных. Для каждой прямой указать, через сколько точек она проходит. Использовать класс HashMap.
public class Main {

    public static void main(String[] args) throws IOException {
        var plane = new Plane();

        plane.addPoint(new Point(1,2));
        plane.addPoint(new Point(2,5));
        plane.addPoint(new Point(3,6));
        plane.addPoint(new Point(4,8));
        plane.addPoint(new Point(5,9));
        plane.addPoint(new Point(6,1));
        plane.addPoint(new Point(7,3));
        plane.addPoint(new Point(8,4));
        plane.addPoint(new Point(9,6));
        plane.addPoint(new Point(10,4));
        plane.addPoint(new Point(11,3));
        plane.addPoint(new Point(5,13));

        plane.addLine(new Line(new Point(1,1), new Point(9,8)));
        plane.addLine(new Line(new Point(2,0), new Point(3,4)));
        plane.addLine(new Line(new Point(10,10), new Point(3,8)));
        plane.addLine(new Line(new Point(1,2), new Point(2,1)));
        plane.addLine(new Line(new Point(5,2), new Point(5,1)));

        Map<Line, Integer> map = new HashMap<>();

        for (var line : plane.getLineList()) {
            int count = 0;

            for (var point : plane.getPointList()) {
                if (line.contains(point)) {
                    count++;
                }
            }

            map.put(line, count);
        }

        Path path = Paths.get("out.txt");
        var k = 0;
        for (Map.Entry<Line, Integer> item : map.entrySet()) {
            if (item.getValue() == 0) continue;
            if (k == 1) {
                Files.write(path,  Collections.singleton(item.getKey() + ": " + item.getValue()),  StandardCharsets.UTF_8);
            } else {
                Files.write(path, Collections.singleton(item.getKey() + ": " + item.getValue()),  StandardCharsets.UTF_8, StandardOpenOption.APPEND);
            }
            k += 1;
        }


    }
}

 class Plane {

    private final Set<Point> pointList = new HashSet<>();
    private final Set<Line> lineList = new HashSet<>();

    Plane() { }

    void addPoint(Point point) {
        pointList.add(point);
    }

    void addLine(Line line) {
        lineList.add(line);
    }


    Set<Line> getLineList() {
        return lineList;
    }

    Set<Point> getPointList() {
        return pointList;
    }
}

 class Point {
    private final float x;
    private final float y;

    Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    float getX() {
        return x;
    }

    float getY() {
        return y;
    }

     @Override
     public String toString() {
         return "Point{" +
                 "x=" + x +
                 ", y=" + y +
                 '}';
     }
 }

class Line {

    private final Point startPoint;
    private final Point endPoint;

    Line(Point startPoint, Point endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    Point getStartPoint() {
        return startPoint;
    }

    Point getEndPoint() {
        return endPoint;
    }

    boolean contains(Point point) {
        var line = new Line2D.Double();
        line.setLine(getStartPoint().getX(), getStartPoint().getY(), getEndPoint().getX(), getEndPoint().getY());
        return line.ptLineDist(point.getX(), point.getY()) == 0;
    }

    @Override
    public String toString() {
        return "Line{" +
                "startPoint=" + startPoint +
                ", endPoint=" + endPoint +
                '}';
    }
}