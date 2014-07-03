package main;

/**
 * @author uc
 */
public class DatabaseModule {

    public DatabaseModule(){

    }

    /* Метод возвращает ФИО студента, принимая его идентификатор в качестве аргумента */
    public String getStudent(int id){

        return (id > 0) ? "Шевченко Константин Викторович" : null;
    }

    /* Метод возвращает оценку студента, принимая его ФИО в качестве аргумента */
    public int getRating(String student){

        return student.equals("Шевченко Константин Викторович") ? 5 : -1;
    }

    /* Метод указывает новую оценку студента, принимая его ФИО и новую оценку в качестве аргументов */
    public void setRating(String student, int newRating){
        System.out.println("setRating() student = "+student+", newRating = "+newRating);
        // Do something
    }
}