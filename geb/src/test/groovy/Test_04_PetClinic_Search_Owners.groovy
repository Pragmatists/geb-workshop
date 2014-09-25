import geb.junit4.GebTest
import org.junit.Test

class Test_04_PetClinic_Search_Owners extends GebTest {
    @Test
    void confirm_owners_search_is_case_sensitive() {
        to FindOwnersPage

        assert !errorFeedback.displayed
        search "davis"

        waitFor { errorFeedback.displayed }
    }
}