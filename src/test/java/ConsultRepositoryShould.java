import Repository.ConsultRepository;
import Tables.Consult;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class ConsultRepositoryShould {

    @Test
    public void viewAllConsults(){
        Consult consult = new Consult();
        ConsultRepository consultRepository = new ConsultRepository();

        List<Consult> consultList = consultRepository.viewAllConsults();

        assertEquals(3, consultList.size());
    }

    @Test
    public void addConsult(){

        Consult consult1 = new Consult();
        Consult consult2 = new Consult();
        Consult consult3 = new Consult();
        ConsultRepository consultRepository = new ConsultRepository();

        consultRepository.addConsult(consult1);
        consultRepository.addConsult(consult2);
        consultRepository.addConsult(consult3);

        assertEquals(3, consult3.getId());
    }

    @Test
    public void deleteConsult(){

        Consult consult = new Consult();
        ConsultRepository consultRepository = new ConsultRepository();


        consultRepository.deleteConsult(consult);
        assertEquals(0, consult.getId());

    }

    @Test
    public void updateConsult(){

        Consult consult = new Consult(new Date(120,4,2), "Probleme cu stomacul");
        ConsultRepository consultRepository = new ConsultRepository();

        consultRepository.updateConsult(consult);
        consult.setDescription("probleme cu stomacul + ficat");

        assertEquals("probleme cu stomacul + ficat", consult.getDescription());

    }
}
