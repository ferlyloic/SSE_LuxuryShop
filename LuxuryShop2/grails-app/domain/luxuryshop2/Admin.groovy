package luxuryshop2

import javafx.scene.control.PasswordField
import sun.security.util.Password

class Admin {
    String name
    String passwort

    static constraints = {
        name nullable: false, blank: false
        passwort nullable: false, passwort:true
    }

}
