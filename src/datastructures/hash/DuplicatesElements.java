package datastructures.hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Created by peo_rboliveira on 08/02/16.
 */
public class DuplicatesElements {
    public static void main(String[] args) {
        Person p1 = new Person(1, "Rafael", "4212");
        Person p2 = new Person(1, "Rafael", "4212");
        Person p3 = new Person(3, "Rafael", "4212");
        Person p4 = new Person(3, "Luiza", "4212");

        System.out.println(findDuplicates(Arrays.asList(p1, p2, p3, p4)));
    }

    private static HashSet<Person> findDuplicates(List<Person> persons) {
        HashSet<Person> uniques = new HashSet<>();
        HashSet<Person> duplicates = new HashSet<>();

        for (Person person : persons) {
            if (!uniques.add(person)) {
                duplicates.add(person);
            }
        }

        return duplicates;
    }

    static class Person {
        private Integer id;
        private String name;
        private String document;

        public Person(Integer id, String name, String document) {
            this.id = id;
            this.name = name;
            this.document = document;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Person person = (Person) o;

            if (!id.equals(person.id)) return false;
            if (!name.equals(person.name)) return false;
            return document.equals(person.document);

        }

        @Override
        public int hashCode() {
            int result = id.hashCode();
            result = 31 * result + name.hashCode();
            result = 31 * result + document.hashCode();
            return result;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", document='" + document + '\'' +
                    '}';
        }
    }
}
