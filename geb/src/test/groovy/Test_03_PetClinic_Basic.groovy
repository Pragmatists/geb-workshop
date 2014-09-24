import geb.junit4.GebTest
import org.junit.Test

class Test_03_PetClinic_Basic extends GebTest {
    @Test
    void visit_petclinic_main_page() {
        go ""

        assert title == "PetClinic :: a Spring Framework demonstration"
    }
}
