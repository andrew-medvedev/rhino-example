package main;

/**
 * @author uc
 */
public class NotificationModule {

    public NotificationModule(){

    }

    /* Метод оповещает студента сообщением */
    public void notifyStudent(String student, String message){
        System.out.println("notifyStudent() student = "+student+", message = "+message);
    }

    /* Метод оповещает куратора */
    public void notifyCurator(String message){
        System.out.println("notifyCurator() message = "+message);
    }
}

