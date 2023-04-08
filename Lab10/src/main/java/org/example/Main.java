package org.example;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class Main {

    public static void main(String[] args) {
        SparkSession spark = SparkSession.builder()
                .appName("Lab10")
                .master("local")
                .getOrCreate();

        Dataset<Row> flights = spark.read()
                .option("header", true)
                .option("inferSchema", true)
                .csv("/Users/ivangorshkov/Documents/BMSTU/BigDataJava/Java-IU6-12M/Lab10/russian_air_service_CARGO_AND_PARCELS.csv");
        flights.createOrReplaceTempView("flights");

        spark.sql("SELECT * FROM flights").show();
        spark.sql("select * from flights where Year = '2020'").show();
        spark.sql("select * from flights where Year = '2010'").show();
        spark.sql("select * from flights where May < September").show();
        spark.sql("select * from flights where AirportName = 'Trip'").show();
        spark.sql("select AirportName, Year from flights order by February desc").show();
        spark.sql("select AirportName, Year, March from flights where January > 150.0 order by November desc").show();
        spark.sql("select AirportName, Year, April from flights order by May desc").show();
        spark.sql("select AirportName, Year, May, June from flights where Year = '2014' and AirportName = 'Trip' order by May desc").show();
        spark.sql("select avg(January) from flights").show();
        spark.stop();
    }
}
