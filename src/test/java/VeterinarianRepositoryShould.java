import Connection.HibernateUtils;
import Repository.VeterinarianRepository;
import Tables.Veterinarian;
import Tables.VeterinarianSpeciality;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class VeterinarianRepositoryShould {

    @Test
    public void seeAllVeterinarians(){

        Veterinarian veterinarian1 = new Veterinarian("Mihai", "Popa", "Bucuresti", VeterinarianSpeciality.DOGS);

        VeterinarianRepository veterinarianRepository = new VeterinarianRepository();

        List<Veterinarian> veterinarianList = veterinarianRepository.seeAllVeterinarians();
        veterinarianList.add(veterinarian1);

        assertEquals(2, veterinarianList.size());

    }

    @Test
    public void addVeteranian(){


        Veterinarian veterinarian1 = new Veterinarian("Alex", "Marinescu", "Constanta", VeterinarianSpeciality.CATS);
        Veterinarian veterinarian2 = new Veterinarian();

        VeterinarianRepository veterinarianRepository = new VeterinarianRepository();
        veterinarianRepository.addVeterinarian(veterinarian1);


        assertEquals(1, veterinarian1.getVeterinarianId());

    }

    @Test
    public void deleteVeterinarian(){

        Veterinarian veterinarian = new Veterinarian("Alex", "Marinescu", "Constanta", VeterinarianSpeciality.CATS);
        VeterinarianRepository veterinarianRepository = new VeterinarianRepository();

        veterinarianRepository.deleteVeterinarian(veterinarian);


        assertEquals(0,veterinarian.getVeterinarianId());
    }

    @Test
    public void updateVeterinarian(){

        Veterinarian veterinarian = new Veterinarian("Alex", "Marinescu", "Constanta", VeterinarianSpeciality.CATS);

        VeterinarianRepository veterinarianRepository = new VeterinarianRepository();
        veterinarianRepository.updateVeterinarian(veterinarian);
        veterinarian.setAddress("Bucuresti");

        assertEquals("Bucuresti", veterinarian.getAddress());
    }


}
