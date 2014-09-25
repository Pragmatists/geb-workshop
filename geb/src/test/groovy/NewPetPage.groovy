import geb.Page
import org.openqa.selenium.Keys

class NewPetPage extends Page {
    static at = {
        heading.displayed
    }
    static content = {
        heading { $('.container > h2', text: containsWord('New Pet')) }
        name { $('form').name() }
        birthDate { $('form').birthDate() }
        type { $('form').type() }
        submit { $("button[type='submit']") }
    }

    void savePet(Map map) {
        name = map.get 'name'
        birthDate = map.get 'birthDate'
        birthDate << Keys.ENTER
        type = map.get 'type'
        submit.click()
    }
}
