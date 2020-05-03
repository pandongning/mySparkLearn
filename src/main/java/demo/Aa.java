package demo;

import demotwo.Student;

/**
 * @author pdn
 */
public class Aa extends Student {
    public static void main(String[] args) {
        Student student = new Student();
        student.height = 186;
        System.out.println(student.height);

        Aa aa = new Aa();
        int height = aa.height;
    }
}
