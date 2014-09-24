import geb.junit4.GebTest
import org.junit.Test

class Test_02_Waiting extends GebTest {
    @Test
    void wait_for_services_section_animation_to_finish() {
        go "http://pragmatists.pl"

        js.exec("scroll(0, 150);");

        def servicesSectionSelector = "#services .animated.fadeInLeftBig p"
        assert $(servicesSectionSelector).displayed == false

        def servicesLink = null
        waitFor { (servicesLink = $('#skrollr-body .header-wrapper .nav-main .services a')).displayed }
        servicesLink.click()

        waitFor { $(servicesSectionSelector).text().contains('90%') }
    }

    @Test
    public void search_for_a_term_in_google() {
        go "http://google.com/ncr"

        // make sure we actually got to the page
        assert title == "Google"

       // enter wikipedia into the search field
        $("input", name: "q") << "wikipedia"

        // wait for the results to show
        waitFor(10, 0.2) { title.endsWith("Google Search") }
    }
}
