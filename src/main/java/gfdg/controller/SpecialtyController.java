//
//package gfdg.controller;
//
//import com.maksim.crudapp.view.SpecialtyView;
//import com.maksim.crudapp.model.Specialty;
//
//import java.util.HashMap;
//import java.util.List;
//
//public class SpecialtyController {
//
//    public Specialty createSpecialty(int specialtyId) {
//
//        SpecialtyView specialtyView = new SpecialtyView();
//        specialtyView.create();
//
//        HashMap<String, String> specialtyInputConsoleData = specialtyView.getOutputSkillData();
//
//        Specialty specialty = new Specialty();
//        specialty.setId(specialtyId);
//        specialty.setName(specialtyInputConsoleData.get("specialty"));
//        return specialty;
//    }
//
//
//    public static Specialty getSpecById (List<Specialty> spec, int expectedID) {
//        for (Specialty specialty:spec) {
//            if (specialty.getId()==expectedID) {
//                return specialty;
//            }
//        }
//        return null;
//    }
//
//    public void updateSpecialty() {
//        SpecialtyView developerView = new SpecialtyView();
//        developerView.update();
//
//        HashMap<String, String> developerInputConsoleData = developerView.getOutputSkillData();
//
//    }
//}
