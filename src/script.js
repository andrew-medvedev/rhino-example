var student = databaseModule.getStudent(1);
var rating = databaseModule.getRating(student);

var pass = rating >= 40;

if(pass){
    notificationModule.notifyCurator("Student "+student+" is admitted to the exam.");
    notificationModule.notifyStudent(student, "You admitted to the exam.");
} else {
    var dif = 40 - rating;
    notificationModule.notifyCurator("Student "+student+" needs "+dif+" points to be admitted to the exam.");
    notificationModule.notifyStudent(student, "You need "+dif+" points to be admitted to the exam.");
}