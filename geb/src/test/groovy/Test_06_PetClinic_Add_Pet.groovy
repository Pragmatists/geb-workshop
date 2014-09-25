import geb.junit4.GebTest
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.samples.petclinic.service.ClinicService
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

@ContextConfiguration(locations = ["classpath:spring/business-config.xml"])
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("jdbc")
class Test_06_PetClinic_Add_Pet extends GebTest {
    @Test
    void add_a_pet_for_peter_mctavish() {
        to FindOwnersPage

        def lastName = 'McTavish'
        search lastName

        at ShowOwnerPage
        def oldNrOfPets = pets

        addPetButton.click(NewPetPage)

        savePet(name: 'Rover', birthDate: '2014/06/16', type: 'dog')

        at ShowOwnerPage

        assert pets == oldNrOfPets + 1
    }
}
