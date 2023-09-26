package lab1;// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

public class Main {
    public static void main(String[] args) {

        Member member = new Member("Don", 34, 9);
        member.printCategory();

        Member member1 = new Member("Don", 64, 3);
        member1.printCategory();

        Member member2 = new Member("Don",56, 9);
        member2.printCategory();
    }
}