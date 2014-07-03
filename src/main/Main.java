package main;

import org.mozilla.javascript.*;

import java.io.File;
import java.io.FileReader;

/**
 * @author uc
 */
public class Main {

    public static void main(String[] args) throws Exception {

        // Создаем контекст
        Context c = Context.enter();

        // Отключаем LiveConnect
        c.setClassShutter(new ClassShutter() {

            @Override
            public boolean visibleToScripts(String fullClassName) {
                // Определяет, виден ли класс с именем fullClassName скрипту
                return true;
            }
        });

        // Создаем скоуп
        Scriptable scope = c.initStandardObjects();

        // Маппим консольный вывод в js
        Object wrappedOut = Context.javaToJS(System.out, scope);
        ScriptableObject.putConstProperty(scope, "console", wrappedOut);

        // Маппим DatabaseModule в js
        DatabaseModule database = new DatabaseModule();
        Object wrappedDatabaseModule = Context.javaToJS(database, scope);
        ScriptableObject.putConstProperty(scope, "databaseModule", wrappedDatabaseModule);

        // Маппим NotificationModule в js
        NotificationModule notification = new NotificationModule();
        Object wrappedNotificationModule = Context.javaToJS(notification, scope);
        ScriptableObject.putConstProperty(scope, "notificationModule", wrappedNotificationModule);


        // Подгружаем js-скрипт из внешнего источника
        String script = doStuff();

        // Запускаем интерпретирование скрипта в данном скоупе
        c.evaluateString(scope, script, null, 1, null);

        // Покидаем контекст
        Context.exit();
    }
    private static String doStuff() throws Exception{
        File f = new File("script.js");
        FileReader fr = new FileReader(f);

        char[] chars = new char[(int)f.length()];
        fr.read(chars);

        return new String(chars);
    }
}
