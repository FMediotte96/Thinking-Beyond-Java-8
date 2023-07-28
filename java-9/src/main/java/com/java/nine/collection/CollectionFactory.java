package com.java.nine.collection;

import java.util.*;

public class CollectionFactory {

    public static void main(String[] args) {
        //list();
        //set();
        //map();
        //noNull();
        //noDuplicates();
        ofVsUnmodifiable();
    }

    public static void list() {
        System.out.println("List");
        unmodifiableListWithAdd();
        unmodifiableListArraysAsList();
        unmodifiableListOf();
    }

    public static void set() {
        System.out.println("Set");
        unmodifiableSetAdd();
        unmodifableSetArraysAsList();
        unmodifiableSetOf();
    }

    public static void map() {
        System.out.println("Map");
        unmodifiableMapUsingPut();
        unmodifiableMapUsingOf();
        unmodifiableMapWithTenElements();
    }

    /* LIST */
    //Using Java 8
    //Option 1
    public static void unmodifiableListWithAdd() {
        List<String> list = new ArrayList<>();
        list.add("Epl");
        list.add("LaLiga");
        list.add("Bundesliga");

        List<String> leagues = Collections.unmodifiableList(list);
        System.out.println(leagues);
    }

    //Option 2
    public static void unmodifiableListArraysAsList() {
        List<String> leagues = Collections.unmodifiableList(
            Arrays.asList("Epl", "LaLiga", "Bundesliga")
        );

        System.out.println(leagues);
    }

    //Using Java 9
    //Option 3
    public static void unmodifiableListOf() {
        List<String> leagues = List.of("Epl", "LaLiga", "Bundesliga");
        System.out.println(leagues);

        List<String> emptyList = List.of();
        List<String> one = List.of("Epl");
        List<String> two = List.of("Epl", "LaLiga");
        List<String> ten = List.of("a", "b", "c", "d", "e", "f", "g", "h", "i", "j");

        //UnsupportedOperationException
        //leagues.add("Ligue 1");
        //leagues.set(0, "SerieA");
        //leagues.remove("Epl");
    }

    /* SET */
    //Using java 8
    //Option 1
    private static void unmodifiableSetAdd() {
        Set<String> set = new HashSet<>();
        set.add("EPL");
        set.add("LALIGA");
        set.add("BUNDESLIGA");

        Set<String> leagues = Collections.unmodifiableSet(set);
        System.out.println(leagues);
    }

    //Option 2
    private static void unmodifableSetArraysAsList() {
        Set<String> leagues = Collections.unmodifiableSet(new HashSet<>(
            Arrays.asList("EPL", "LALIGA", "BUNDESLIGA")
        ));

        System.out.println(leagues);
    }

    //Using Java 9
    //Option 3
    public static void unmodifiableSetOf() {
        Set<String> leagues = Set.of("EPL", "LALIGA", "BUNDESLIGA");
        System.out.println(leagues);
    }


    /* MAP */
    //Using Java 8
    //Option 1
    public static void unmodifiableMapUsingPut() {
        Map<String, Integer> map = new HashMap<>();

        map.put("EPL", 200);
        map.put("LaLiga", 210);
        map.put("Bundesliga", 190);

        Map<String, Integer> leagueRanking = Collections.unmodifiableMap(map);
        System.out.println(leagueRanking);
    }

    //Using Java 9
    //Option 2
    public static void unmodifiableMapUsingOf() {
        Map<String, Integer> leagueRanking = Map.of(
            "Epl", 200,
            "LaLiga", 210,
            "Bundesliga", 190
        );
        System.out.println(leagueRanking);
    }

    public static void unmodifiableMapWithTenElements() {
        //If more than 10 entries...
        Map<String, Integer> leagueRanking = Map.ofEntries(
            Map.entry("Epl", 200),
            Map.entry("LaLiga", 210),
            Map.entry("Bundesliga", 190),
            Map.entry("League1", 250)
        );
        System.out.println(leagueRanking);
    }

    //NoNull: method of not allowed null elements
    public static void noNull() {
        List<String> leagues = List.of("Epl", "LaLiga", "Bundesliga");
        System.out.println(leagues);
    }

    public static void noDuplicates() {
        Set<String> set = new HashSet<>();
        set.add("EPL");
        set.add("LALIGA");
        set.add("BUNDESLIGA");
        set.add("EPL"); //this has no impact
        System.out.println(set);

        //If we add a duplicate element this method will throw IllegalArgumentException
        Set<String> leagues = Set.of("EPL", "LALIGA", "BUNDESLIGA");
        System.out.println(leagues);

        //Will throw IllegalArgumentException if there is any duplicate
        Map<String, Integer> leagueRanking = Map.of(
            "Epl", 200,
            "LaLiga", 210,
            "Bundesliga", 190
        );
        System.out.println(leagueRanking);
    }

    /*  Similarity: we cannot add, remove or replace the elements.
        Differences:
            - unmodifiable:
                - return an unmodified view collections, if we change the collection, the view will change
                - support null
            - of:
                - return an unmodified collections, we assured total immutability
                - don't support null throw a NullPointerException
    */
    public static void ofVsUnmodifiable() {
        List<String> list = Arrays.asList("Epl", "LaLiga", "Bundesliga");
        List<String> leagues = Collections.unmodifiableList(list);
        list.set(2, "Ligue1");

        System.out.println("Using Collections.unmodifiable: " + leagues);

        List<String> leaguesUsingOf = List.of("Epl", "LaLiga", "Bundesliga");
        System.out.println("Using List.of: " + leaguesUsingOf);
    }

}
