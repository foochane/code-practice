package CloneDemo;

public class Student implements Cloneable{
    int id;
    String name;
    Teacher teacher;
    Student(int id, String name, Teacher teacher){
        this.id = id;
        this.name = name;
        this.teacher = teacher;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {

        //return super.clone();

        // 修改为深拷贝
        Student student = (Student)super.clone();
        student.setTeacher((Teacher) student.getTeacher().clone());
        return student;
    }
}
