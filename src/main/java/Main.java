import dto.StudentDTO;
import service.Impl.ManageStudentServiceImpl;
import util.WhatsAppHttpClient;

public class Main {

    public static void main(String[] args) {

       //  List of recipients in E.164 format
//        String[] recipients = {
//                "94762510084",
//                "94707333778",
//                "94710407740",
//                "94705344426",
//                "94717623891",
//                "94713325350"
//        };
//
//        // Template name
//        String templateName = "appointment_reminder";
//
//
//        for (String recipient : recipients) {
//
//            WhatsAppHttpClient.sendTemplateMessage(recipient, templateName);
//
//            try {
//                Thread.sleep(1000); // 0.1 second
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
        ManageStudentServiceImpl manageStudentService = new ManageStudentServiceImpl();
        manageStudentService.saveStudent(new StudentDTO());
        Starter.main(args);
  }
}
