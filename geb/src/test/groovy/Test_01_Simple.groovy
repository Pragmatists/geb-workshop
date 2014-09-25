import geb.Browser
import org.junit.Test

class Test_01_Simple {
    @Test
    void visit_pragmatists_blog_and_then_main_page() {
        Browser.drive {
            go "http://pragmatists.pl/blog"

            // make sure we actually got to the page
            assert title == "Pragmatists Blog"

            // extract the banner link
            def bannerLink = $(text: "Pragmatists")

            // click the link
            bannerLink.click()

            // wait for a redirect to the main page
            assert currentUrl == "http://pragmatists.pl/"
        }
    }
}