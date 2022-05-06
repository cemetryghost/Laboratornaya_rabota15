package com.company;

enum Size{
    XXS(32){
        @Override
        public String getDescription(){
            return "Детский размер";
        }
    }, XS(34), S(36), M(38), L(40);
    int euroSize;

    Size(int euroSize) {
        this.euroSize = euroSize;
    }

    public String getDescription(){
        return "Взрослый размер";
    }
    public String toString(){
        return name() + " (" + euroSize + ") " + getDescription();
    }
}

abstract class Clothes{
    Size size;
    String color;
    double price;

    Clothes(Size size, String color, double price){
        this.size = size;
        this.price = price;
        this.color = color;
    }

    public void setPrice(double x){
        this.price = x;
    }
    public Size getSize(){
        return size;
    }
    public double getPrice(){
        return price;
    }
    public String getColor(){
        return color;
    }
}

class Atelier{
    void dressAMan(Clothes[] clothes){
        System.out.println("===== Мужская одежда =====\n");
        for(Clothes cloth : clothes){
            if(cloth instanceof MensClothing){
                System.out.println(cloth);
            }
        }
    }
    void dressAWoman(Clothes[] clothes){
        System.out.println("===== Женская одежда =====\n");
        for(Clothes cloth : clothes){
            if(cloth instanceof WomenClothing){
                System.out.println(cloth);
            }
        }
    }

    interface MensClothing{
        default void dressAmen(){
            System.out.println("Одеть мужчину");
        }
    }

    interface WomenClothing{
        default void dressAwomen(){
            System.out.println("Одеть женщину");
        }
    }

    public static class TShirt extends Clothes implements MensClothing, WomenClothing{
        TShirt(Size size, String color, double price){
            super(size, color, price);
        }

        public String toString() {
            return "❈ ═══════❖═══════ ❈" + "\n" + "Размер футболки " + getSize() + "\n" + "Цена: " + getPrice() + "₽" + "\n" + "Цвет: " + getColor();
        }
    }

    public static class Pants extends Clothes implements MensClothing, WomenClothing{
        Pants(Size size, String color, double price){
            super(size, color, price);
        }

        public String toString() {
            return "❈ ═══════❖═══════ ❈" + "\n" + getSize() + "\n" + "Цена: " + getPrice() + "₽" + "\n" + "Цвет: " + getColor();
        }
    }

    public static class Skirt extends Clothes implements WomenClothing{
        Skirt(Size size, String color, double price){
            super(size, color, price);
        }

        public String toString() {
            return "❈ ═══════❖═══════ ❈" + "\n" + "Размер юбки " + getSize() + "\n" + "Цена: " + getPrice() + "₽" + "\n" + "Цвет: " + getColor();
        }
    }

    public static class Necktie extends Clothes implements MensClothing{
        Necktie(Size size, String color, double price){
            super(size, color, price);
        }

        public String toString() {
            return "❈ ═══════❖═══════ ❈" + "\n" + "Размер галстука " + getSize() + "\n" + "Цена: " + getPrice() + "₽" + "\n" + "Цвет: " + getColor();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Clothes[] clothes = {
                new Atelier.Pants(Size.XXS, "Cиние", 700),
                new Atelier.Pants(Size.M, "Черные", 1800),
                new Atelier.Skirt(Size.XS, "Фиолетовая", 1350),
                new Atelier.Skirt(Size.L, "Черная", 1700),
                new Atelier.Necktie(Size.XS, "Cерый", 3250),
                new Atelier.Necktie(Size.XXS, "Красный", 2750),
                new Atelier.TShirt(Size.M, "Белая", 2000),
                new Atelier.TShirt(Size.S, "Черная", 2000),
        };

        Atelier atelier = new Atelier();
        atelier.dressAMan(clothes);
        System.out.println();
        atelier.dressAWoman(clothes);
    }
}