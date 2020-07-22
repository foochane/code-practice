package CloneDemo;


/**
 * 深拷贝和浅拷贝
 * https://foochane.cn/article/2020072001.html
 */
public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {

        // 浅拷贝
        Student t1 = new Student(1,"小红",new Teacher("老师a"));
        Student t2 = (Student)t1.clone();

        System.out.println(t1);  // Student@1b6d3586
        System.out.println(t2);  //Student@1b6d3586

        t2.setId(2);
        t2.setName("小张");
        t2.getTeacher().setName("老师b"); // 会修改t1的值

        System.out.println(t1.getId() + "," + t1.getName() + "," + t1.getTeacher().getName());  // 1,小红,老师b
        System.out.println(t2.getId() + "," + t2.getName() + "," + t2.getTeacher().getName());  // 2,小张,老师b

    }
}
