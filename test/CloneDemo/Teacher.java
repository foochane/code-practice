package CloneDemo;

public class Teacher implements Cloneable {
    String name;

    Teacher(String name){
        this.name = name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
