import geb.Page

class ShowOwnerPage extends Page {
    static at = {
        heading.displayed
    }
    static content = {
        heading { $('.container > h2', text: containsWord('Owner Information')) }
    }
}
