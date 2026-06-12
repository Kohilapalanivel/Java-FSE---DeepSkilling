public class MVCTest 
{
    public static void main(String[] args)
    {
        Student model = new Student("Anu",101,"A");
        StudentView view = new StudentView();
        StudentController controller = new StudentController(model,view);
        controller.updateView();
        System.out.println();
        controller.setStudentName("Kohila");
        controller.setStudentGrade("A+");
        controller.updateView();
    }
}