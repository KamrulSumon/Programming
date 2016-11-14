import java.util.*;
import java.util.stream.Collectors;

public class StreamImpl {

    static void test() {
    }

    static boolean isOdd(Map.Entry x) {
        return (Integer) x.getValue() % 2 != 0;
    }

    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);
        numbers.add(50);
        numbers.add(60);


        Set<String> someSet = new HashSet<>();
        someSet.add("mary");
        someSet.add("has");
        someSet.add("a");
        someSet.add("crappy");
        someSet.add("lamb");
        someSet.add("collection");

        /*
            Stream interface offers 2 types of methods
            1. Terminal methods
            2. Intermediate methods
         */

        numbers.stream()
                .map(x -> x * 2)
                .filter(x -> x > 20)
                .forEach(x -> System.out.println(x));

        //store the result from stream
        List<Integer> output = numbers.stream()
                .map(x -> x * 2)
                .filter(x -> x > 20)
                .collect(Collectors.toList());
        System.out.println(output);


        //store the result from stream
        numbers.stream()
                .map(x -> x * 2)
                .filter(x -> x > 20)
                .map(x -> x * x)
                .map(x -> {
                    System.out.println("Within Map --> " + x);
                    return x;
                })
                .forEach(x -> StreamImpl.test()); //.collect(Collectors.toList());


        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        map.put("D", 4);
        map.put("E", 5);

        //You can directly stream on Map but you can stream on List, Set
        //In order to stream on Map, you can get values(map.values().stream()) or keys(map.keySet().stream())
        List<Integer> filteredValues = map.values()
                .stream()
                .map(x -> x * 3)
                .filter(x -> (x % 2) != 0)
                .map(x -> x * 2)
                .collect(Collectors.toList());

        //print tuple
        Map<String, Integer> mapOutput = map.entrySet()
                .stream()
                .peek(System.out::println)
                .filter(StreamImpl::isOdd)  //.filter(x -> (x.getValue() % 2) != 0 ) //Map.Entry
                .peek(System.out::println)
                .collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue()));  //.forEach(System.out::println);

        // System.out.println(mapOutput);

        //print sorted map
        Map<String, Integer> mapOutputSorted = map.entrySet()
                .stream()
                .filter(StreamImpl::isOdd)  //.filter(x -> (x.getValue() % 2) != 0 ) //Map.Entry
                .peek(x -> {
                    System.out.println("Stage 02 - " + x);
                    System.out.println();
                })
                .sorted(Comparator.comparingInt(x -> -1 * x.getValue()))
                .peek(System.out::println)
                .collect(Collectors.toMap(entry -> entry.getKey() + entry.getValue(), entry -> entry.getValue()));  //.forEach(System.out::println);

        System.out.println(mapOutputSorted);


        Map<String, Integer> sorted = new LinkedHashMap<>();

        //print sorted map
        map.entrySet()
                .stream()
                .filter(StreamImpl::isOdd)  //.filter(x -> (x.getValue() % 2) != 0 ) //Map.Entry
                .peek(x -> {
                    System.out.println("Stage 02 - " + x);
                    System.out.println();
                })
                .sorted(Comparator.comparingInt(x -> x.getValue()))
                .peek(x -> {
                    sorted.put(x.getKey(), x.getValue());
                })
                .forEach(x -> {
                });

        System.out.println(sorted);

        /// FlatMap implementations
        List<String> list01 = new ArrayList<>();
        List<String> list02 = new ArrayList<>();

        list01.add("Hello");
        list01.add("World");

        list01.add("Hi");
        list01.add("There");

        List<List<String>> finalList = new ArrayList<>();
        finalList.add(list01);
        finalList.add(list02);

        List<String> test = finalList.stream()
                .peek(System.out::println)
                .flatMap(x -> x.stream())
                .collect(Collectors.toList());


        Map<String, Integer> coordinatesAsia = new HashMap<>();
        coordinatesAsia.put("Saudi", 2);
        coordinatesAsia.put("Thailan", 3);

        Map<String, Integer> coordinatesNA = new HashMap<>();
        coordinatesAsia.put("US", 20);
        coordinatesAsia.put("Puerto Rico", -32);

        Map<String, Map<String, Integer>> combineResult = new HashMap<>();
        combineResult.put("1", coordinatesAsia);
        combineResult.put("2", coordinatesNA);

        Map<String, Integer> temp = combineResult.values()
                .stream()
                .flatMap(entry -> entry.entrySet().stream())
                .collect(Collectors.toMap(entry -> entry.getKey(), entry -> entry.getValue()));

        System.out.println();

    }
}