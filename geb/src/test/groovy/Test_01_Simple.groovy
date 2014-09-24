import geb.junit4.GebTest
import org.junit.Test

class Test_01_Simple extends GebTest {
    @Test
    void visit_pragmatists_blog_and_then_main_page() {
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

    @Test
    public void visit_pragmatists_blog_article() {
        go "http://pragmatists.pl/blog"
        def articleLink = $(text: 'read more')
        articleLink.click()
        assert currentUrl.startsWith("http://pragmatists.pl/blog/2014/")
    }
}
