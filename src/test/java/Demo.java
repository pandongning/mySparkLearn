import demotwo.Student;


public class Demo extends Student {

    public static void main(String[] args) {
        String s = "aa,bb,cc";
        String[] split = s.split(",", 1);
        for (String s1 : split) {
            System.out.println(s1);
        }
    }

}
