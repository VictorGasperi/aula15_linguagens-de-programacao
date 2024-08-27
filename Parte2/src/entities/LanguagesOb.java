package entities;

import java.util.ResourceBundle;
import java.util.Locale;

public class LanguagesOb {

    private int selectedLanguage;
    private ResourceBundle bn_login = null;
    private ResourceBundle bn_main = null;

    public LanguagesOb(int selectedLanguage) {
        this.selectedLanguage = selectedLanguage;
        selectBundleArchive(selectedLanguage);
    }

    private void selectBundleArchive(int selectedLanguage) {
        switch (selectedLanguage) {
            case 1:
                bn_login = ResourceBundle.getBundle("lang.login.login", new Locale("pt", "BR"));
                bn_main = ResourceBundle.getBundle("lang.main.main", new Locale("pt", "BR"));
                break;
            case 2:
                bn_login = ResourceBundle.getBundle("lang.login.login", Locale.US);
                bn_main = ResourceBundle.getBundle("lang.main.main", Locale.US);
                break;
        }
    }

    public int getSelectedLanguage() {
        return selectedLanguage;
    }

    public ResourceBundle getBn_login() {
        return bn_login;
    }

    public ResourceBundle getBn_main() {
        return bn_main;
    }


    

}
