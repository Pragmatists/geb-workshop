import geb.Page

class NewOwnerPage extends Page {
    static url = 'owners/new'
    static at = {
        heading
    }
    static content = {
        heading { $('.container > h2', text: containsWord('New Owner')) }
        firstName { $('form').firstName() }
        lastName { $('form').lastName() }
        address { $('form').address() }
        city { $('form').city() }
        telephone { $('form').telephone() }
        submit { $("button[type='submit']") }
    }

    void saveOwner(Map map) {
        firstName = map.get 'firstName', 'John'
        lastName = map.get 'lastName', 'Doe'
        address = map.get 'address', '1st Street 101'
        city = map.get 'city', 'Nowhere'
        telephone = map.get 'telephone', '555555'
        submit.click()
    }
}
