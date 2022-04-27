package demo.generics.bounds;

import demo.generics.bounds.entries.Animal;
import demo.generics.bounds.entries.Cat;
import demo.generics.bounds.entries.HomeCat;
import demo.generics.bounds.entries.WildCat;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.*;

public class Wildcard_1 {

    public static void main(String[] args) {

        List<Animal> animalList = new ArrayList<>();
        animalList.add(new Animal());

        //        print(animalList);
        //        printWild(animalList);

        List<Cat> catList = new ArrayList<>();
        catList.add(new Cat());
        catList.add(new HomeCat("Барсик"));
        catList.add(new WildCat("Багира"));

        //print(animalList);
        //printWild(animalList);

        //       List<HomeCat> homeCatList = new ArrayList<>(  );
        //
        //        printWild( homeCatList );

        //print(catList); //Ошибка
        printWild(catList);

    }

    private static void print(List<Animal> animalList) {
        animalList.forEach(out::println);
    }

    private static void printWild(List<? extends Animal> animalList) {
        //animalList.forEach(Animal::getMilk);
        animalList.forEach(System.out::println);
    }



}
