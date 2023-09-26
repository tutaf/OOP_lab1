package lab1;

public class Member {
    private String name;
    private int age;
    private int handicap;
    private Category category;

    enum Category {OPEN, SENIOR}

    public Member(String name, int age, int handicap) {
        this.name = name;
        this.age = age;
        this.handicap = handicap;

        this.category = assignCategory(age, handicap);
    }

    private Category assignCategory(int age, int handicap) {
        if (age > 55 && handicap > 7) {
            return Category.SENIOR;
        } else {
            return Category.OPEN;
        }
    }

    public void printCategory() {
        System.out.println(this.category);
    }

}
