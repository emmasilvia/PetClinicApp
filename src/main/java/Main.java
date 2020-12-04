import Connection.HibernateUtils;
import Repository.ConsultRepository;
import Repository.PetRepository;
import Repository.VeterinarianRepository;
import Tables.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        session.beginTransaction();

        Veterinarian veterinarian1 = new Veterinarian("Alex", "Popa", "Bucuresti", VeterinarianSpeciality.DOGS);
        Veterinarian veterinarian2 = new Veterinarian("Emma", "Ionescu", "Constanta",VeterinarianSpeciality.CATS);
        Veterinarian veterinarian3 = new Veterinarian("Roxana", "Popescu", "Cluj", VeterinarianSpeciality.DOGS);

        VeterinarianRepository veterinarianRepository = new VeterinarianRepository();
        veterinarianRepository.addVeterinarian(veterinarian1);
        veterinarianRepository.addVeterinarian(veterinarian2);
        veterinarianRepository.addVeterinarian(veterinarian3);

        Pet pet1 = new Pet(Species.CAT, Race.BIRMANEZA,true, new Date(120,3,12), "Mihai");
        Pet pet2 = new Pet(Species.DOG, Race.LABRADOR, true, new Date(109,5,4),"Izabela");
        Pet pet3 = new Pet(Species.DOG, Race.GOLDEN_RETREIVER, false, new Date(115,8,21), "Marcel");

        PetRepository petRepository = new PetRepository();
        petRepository.addPet(pet1);
        petRepository.addPet(pet2);
        petRepository.addPet(pet3);

        Consult consult1 = new Consult(new Date(120,4,16), "gastrita");
        Consult consult2 = new Consult(new Date(120,10,21), "cataracta");

        ConsultRepository consultRepository = new ConsultRepository();

        consult1.setVeterinarian(veterinarian2);
        consult1.setPet(pet1);
        consultRepository.addConsult(consult1);

        consult2.setVeterinarian(veterinarian1);
        consult2.setPet(pet2);
        consultRepository.addConsult(consult2);

    }

}
