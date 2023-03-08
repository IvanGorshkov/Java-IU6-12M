package com.java.lab;

import java.util.ArrayList;

// 6 Создать класс Shop (магазин) с внутренним классом, с помощью объектов которого можно хранить информацию об отделах, товарах и услуг.
public class Main {

    public static void main(String[] args) {
        var shop = new Shop("Federation");
        shop.getStorage().addDepartment(new StorageDepartment("Sellers"));
        shop.getStorage().addProduct(new StorageProduct("Nike"));;
        shop.getStorage().addService(new StorageServivice("Cleaning"));

        System.out.println(shop.toString());
    }
}


class Shop {
    private String name;


    private final Storage storage;

    Shop(String name) {
        this.name = name;
        this.storage = new Storage();
    }


    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    public Storage getStorage() {
        return storage;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "name='" + name + '\'' +
                ", storage=" + storage +
                '}';
    }

    static class Storage {
        private ArrayList<StorageItemI> storage;

        public Storage() {
            this.storage = new ArrayList<>();
        }

        public void addDepartment(StorageDepartment department){
            this.storage.add(department);
        }

        public void addProduct(StorageProduct product){
            this.storage.add(product);
        }

        public void addService(StorageServivice servivice){
            this.storage.add(servivice);
        }

        @Override
        public String toString() {
            return "Storage{" +
                    "storage=" + storage +
                    '}';
        }
    }
}


interface StorageItemI {
    String getName();
    void setName(String name);
}

class StorageDepartment implements StorageItemI {
    private String name;

    StorageDepartment(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return "Department: " + name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "StorageDepartment {" +
                "name='" + name + '\'' +
                '}';
    }
}

class StorageProduct implements StorageItemI {
    private String name;

    StorageProduct(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return "Product: " + name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "StorageProduct {" +
                "name='" + name + '\'' +
                '}';
    }
}

class StorageServivice implements StorageItemI {
    private String name;

    StorageServivice(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return "Servivice: " + name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "StorageServivice {" +
                "name='" + name + '\'' +
                '}';
    }
}
