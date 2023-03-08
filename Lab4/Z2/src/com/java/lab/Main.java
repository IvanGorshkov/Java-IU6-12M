package com.java.lab;

import java.util.ArrayList;

// 7 Создать класс Cправочная Cлужба Oбщественного Tранспорта с внутренним классом, с помощью объектов которого можно хранить информацию о времени, линиях маршрутов и стоимости проезда.
public class Main {

    public static void main(String[] args) {
        var transportHelper = new TransportHelper();
        transportHelper.addRoute(new TransportHelper.Route("12:00", "redLine", 123));
        transportHelper.addRoute(new TransportHelper.Route("12:40", "greenLine", 12));
        transportHelper.addRoute(new TransportHelper.Route("13:10", "blueLine", 223));
        System.out.println(transportHelper.toString());
    }
}

class TransportHelper {
    ArrayList<Route> routes = new ArrayList<>();

    public void addRoute(Route route) {
        routes.add(route);
    }

    static class Route {
        String time;
        String lineDescription;
        int price;

        public Route(String time, String lineDescription, int price) {
            this.time = time;
            this.lineDescription = lineDescription;
            this.price = price;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getLineDescription() {
            return lineDescription;
        }

        public void setLineDescription(String lineDescription) {
            this.lineDescription = lineDescription;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "Route{" +
                    "time='" + time + '\'' +
                    ", lineDescription='" + lineDescription + '\'' +
                    ", price=" + price +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "TransportHelper{" +
                "routes=" + routes +
                '}';
    }
}
