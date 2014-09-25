import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.samples.petclinic.model.Owner
import org.springframework.samples.petclinic.service.ClinicService
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

import static org.junit.Assert.assertTrue

@ContextConfiguration(locations = ["classpath:spring/business-config.xml"])
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("jdbc")
class JdbcClinicServiceTest {
    @Autowired
    ClinicService clinicService

    @Test
    void find_owners() {
        Collection<Owner> owners = clinicService.findOwnerByLastName("Davis")
        assertTrue(owners.size() > 0)
    }
}
