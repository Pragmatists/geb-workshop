import geb.junit4.GebTest
import org.junit.Test

class Test_05_PetClinic_Add_Owner extends GebTest {
    @Test
    void add_owner() {
        to NewOwnerPage

        saveOwner(lastName: 'Davis')

        at ShowOwnerPage
    }
}
