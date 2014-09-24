import geb.junit4.GebReportingTest
import org.junit.Test

class Test_01_Simple extends GebReportingTest {
    @Test
    void visit_pragmatists_blog_and_then_main_page() {
        go "http://pragmatists.pl/blog"

        // make sure we actually got to the page
        assert title == "Pragmatists Blog"

        report "blog-view"

        String mainPageUrl = "http://pragmatists.pl/"

        // extract the banner link
        def bannerLink = $("nav#nav-main a.logo", 0, href: mainPageUrl)

        // click the link
        bannerLink.click()

        // wait for a redirect to the main page
        assert currentUrl == mainPageUrl
    }
}
