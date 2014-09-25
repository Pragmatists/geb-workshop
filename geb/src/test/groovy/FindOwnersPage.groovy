import geb.Page

class FindOwnersPage extends Page {
    static url = 'owners/find.html'
    static at = {
        driver.currentUrl?.endsWith(url)
    }
    static content = {
        searchField { $('form').lastName() }
        submit { $("button[type='submit']") }
        errorFeedback(required: false) { $('.help-inline') }
    }

    void search(String str) {
        searchField = str
        submit.click()
    }
}
