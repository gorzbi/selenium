// rozwiązanie problemu z uruchamianiem na chrome

W @BeforeSuite / @Before

    public void start() {

        System.setProperty("webdriver.http.factory", "jdk-http-client");
      }

// ---------------------------------------------------klucz ssh z github--------------------------------------------------

odpalić git bash w folderze gdzie jest projekt i plik git
wykonać komendy

generowanie:
ssh-keygen -t ed25519 -C "your_email@example.com"

install: 
cat ~/.ssh/id_ed25519.pub | clip -> kopiuje zawartość do schowka

wkleić w github >> settings >> ssh and gpg keys (new ssh key)
https://github.com/settings/keys
