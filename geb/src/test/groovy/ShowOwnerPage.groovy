import geb.Page

class ShowOwnerPage extends Page {
    static at = {
        heading.displayed
    }
    static content = {
        heading { $('.container > h2', text: containsWord('Owner Information')) }
        addPetButton { $('a.btn.btn-success') }
        pets { $('.container table')
                .not('.table-striped')
                .not('.footer')
                .not('.table-condensed')
                .size() }
    }
}
