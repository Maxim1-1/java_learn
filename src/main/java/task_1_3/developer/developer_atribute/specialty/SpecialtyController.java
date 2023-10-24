
package task_1_3.developer.developer_atribute.specialty;

import task_1_3.developer.DeveloperView;
import task_1_3.developer.developer_atribute.skills.Skill;
import task_1_3.developer.developer_atribute.skills.SkillsView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SpecialtyController {

    public Specialty createSpecialty(int specialtyId) {

        SpecialtyView specialtyView = new SpecialtyView();
        specialtyView.create();

        HashMap<String, String> specialtyInputConsoleData = specialtyView.getOutputSkillData();

        Specialty specialty = new Specialty();
        specialty.setId(specialtyId);
        specialty.setSpecialty(specialtyInputConsoleData.get("specialty"));
        return specialty;
    }


    public static Specialty getSpecById (List<Specialty> spec, int expectedID) {
        for (Specialty specialty:spec) {
            if (specialty.getId()==expectedID) {
                return specialty;
            }
        }
        return null;
    }

    public void updateSpecialty() {
        SpecialtyView developerView = new SpecialtyView();
        developerView.update();

        HashMap<String, String> developerInputConsoleData = developerView.getOutputSkillData();

    }
}
