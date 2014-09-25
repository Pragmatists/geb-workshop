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
class Test_05_PetClinic_Add_Owner extends GebTest {
    @Autowired
    ClinicService clinicService

    @Test
    void add_another_davis_owner() {
        int davises = searchForDavises()

        to NewOwnerPage

        saveOwner(lastName: 'Davis')

        at ShowOwnerPage
        Assert.assertEquals(davises + 1, searchForDavises())
    }

    private int searchForDavises() {
        clinicService.findOwnerByLastName('Davis').size()
    }
}
