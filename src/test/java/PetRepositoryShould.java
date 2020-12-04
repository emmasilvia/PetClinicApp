import Repository.PetRepository;
import Tables.Pet;
import Tables.Race;
import Tables.Species;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PetRepositoryShould {

    @Test
    public void viewAllPets(){
        Pet pet = new Pet(Species.DOG, Race.LABRADOR, true, new Date(117,3,23), "George");
        List<Pet> petList = new ArrayList<Pet>();

        petList.add(pet);

        assertEquals(1, petList.size());
    }

    @Test
    public void addPet(){

        Pet pet1 = new Pet(Species.DOG, Race.LABRADOR, true, new Date(117,3,23), "George");
        Pet pet2 = new Pet(Species.CAT, Race.BIRMANEZA, true, new Date(117,5,12), "Emma");
        PetRepository petRepository = new PetRepository();

        petRepository.addPet(pet1);

        assertEquals(1, pet1.getPetId());
    }

    @Test
    public void deletePet(){
        Pet pet1 = new Pet(Species.DOG, Race.LABRADOR, true, new Date(117,3,23), "George");
        PetRepository petRepository = new PetRepository();

        petRepository.deletePet(pet1);


        assertEquals(0, pet1.getPetId());
    }

    @Test
    public void updatePet(){

        Pet pet2 = new Pet(Species.CAT, Race.BIRMANEZA, true, new Date(117,5,12), "Emma");
        PetRepository petRepository = new PetRepository();

        petRepository.updatePet(pet2);
        pet2.setDateOfBirth(new Date(120,4,15));

        assertEquals(new Date(120,4,15),pet2.getDateOfBirth());
    }

}
