package com.java.lab;
import java.util.*;

// 7. На плоскости задано N отрезков. Найти точку пересечения двх отрезков, имеющую минимальную абсциссу. Использовать класс TreeMap.
    public class Main {

        public static void main(String[] args) {
            LineSegment[] lineSegments = {
                    new LineSegment(new Point(1, 8), new Point(9, 1)),
                    new LineSegment(new Point(2, 7), new Point(8, 2)),
                    new LineSegment(new Point(3, 6), new Point(7, 3)),
                    new LineSegment(new Point(4, 5), new Point(6, 4)),
                    new LineSegment(new Point(5, 4), new Point(5, 5)),
                    new LineSegment(new Point(6, 3), new Point(4, 3)),
                    new LineSegment(new Point(7, 2), new Point(3, 2)),
            };

            TreeMap<Double, Point> intersectionPoints = new TreeMap<>();

            for (int i = 0; i < lineSegments.length; i++) { for (int j = i + 1; j < lineSegments.length; j++) {
                    if (lineSegments[i].intersects(lineSegments[j])) {
                        Point intersectionPoint = lineSegments[i].getIntersectionPoint(lineSegments[j]);
                        intersectionPoints.put(intersectionPoint.getX(), intersectionPoint);
                    }
            }}

            Point minIntersectionPoint = intersectionPoints.firstEntry().getValue();
            System.out.println("Min Point: " + minIntersectionPoint);

        }

    }

    class LineSegment {
        Point startPoint;
        Point endPoint;

        LineSegment(Point startPoint, Point endPoint) {
            this.startPoint = startPoint;
            this.endPoint = endPoint;
        }

        double getSlope() {
            return (endPoint.getY() - startPoint.getY()) / (endPoint.getX() - startPoint.getX());
        }

        double getYIntercept() {
            return startPoint.getY() - getSlope() * startPoint.getX();
        }

        boolean intersects(LineSegment other) {
            double common = (endPoint.getX() - startPoint.getX())*(other.endPoint.getY() - other.startPoint.getY()) - (endPoint.getY() - startPoint.getY())*(other.endPoint.getX() - other.startPoint.getX());

            if (common == 0) return false;

            double rH = (startPoint.getY() - other.startPoint.getY())*(other.endPoint.getX() - other.startPoint.getX()) - (startPoint.getX() - other.startPoint.getX())*(other.endPoint.getY() - other.startPoint.getY());
            double sH = (startPoint.getY() - other.startPoint.getY())*(endPoint.getX() - startPoint.getX()) - (startPoint.getX() - other.startPoint.getX())*(endPoint.getY() - startPoint.getY());

            double r = rH / common;
            double s = sH / common;

            return r >= 0 && r <= 1 && s >= 0 && s <= 1;
        }

        Point getIntersectionPoint(LineSegment other) {
            var x = (other.getYIntercept() - getYIntercept()) / (getSlope() - other.getSlope());
            double y = getSlope() * x + getYIntercept();
            return new Point(x, y);
        }
    }

    class Point {
    private final double x;
    private final double y;

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    double getX() {
        return x;
    }

    double getY() {
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