package Sort;

/**
 * 自定义学生类
 */
public class Student implements Comparable<Student>{
    private String name;
    private Integer score;

    public Student(String name,Integer score){
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Student another){
        return this.score - another.score;
    }

    @Override
    public boolean equals(Object student){
        if(this == student) return true;
        if(student == null) return false;
        if(this.getClass() != student.getClass()) return false;
        Student another = (Student)student;
        return this.name.equals(another.name);
    }

    @Override
    public String toString(){
        return String.format("Sort.Student{name:%s,score:%d}",name,score);
    }
}
