        firefox.get("https://testeroprogramowania.github.io/selenium/basics.html");

        // odszukanie elementu przez id
        firefox.findElement(By.xpath("//*[@id]"));  // znajdzie wszystkie co mają atrybut id
        firefox.findElement(By.xpath("//*[@id='clickOnMe']"));
        firefox.findElement(By.xpath("//button[@id='clickOnMe']"));
        firefox.findElement(By.xpath("/html/body/button[@id='clickOnMe']"));

        // odszukanie elementu przez name
        firefox.findElement(By.xpath("//*[@name]")); // znajdzie wszystkie co mają atrybut name
        firefox.findElement(By.xpath("//*[@name='fname']"));
        firefox.findElement(By.xpath("//input[@name='fname']"));
        firefox.findElement(By.xpath("/html/body/input[@name='fname']"));

        // odszukanie wg numeru indeksu
        firefox.findElement(By.xpath("(//input)[2]"));
        firefox.findElement(By.xpath("(//input)[last()]"));
        firefox.findElement(By.xpath("(//button[@id])[2]")); // znajdzie wszystkie buttony co mają id i wyciągnie drugi z nich
        firefox.findElement(By.xpath("(//*[@name])[2]")); // znajdzie wszystkie elementy z atrybutem name i wyciągnie drugi

        // odszukanie linku
        firefox.findElement(By.xpath("//a[@href='/app/zmiana-kontekstu/58206']")); // po linku www
        firefox.findElement(By.xpath("//a[contains(@href,'/app/zmiana-kontekstu/58206')]")); // po linku www
        firefox.findElement(By.xpath("//a[text()='IamWeirdLink']")); // po Anchor tekście linku
        firefox.findElement(By.xpath("//a[contains(text(),'Weird')]")); // po fragmencie anchor linku

        // odszukanie elementu który nie zawiera
        firefox.findElement(By.xpath("//*[@id!='clickOnMe']")); // wszystkie których id jest różne od clickOnMe
        firefox.findElement(By.xpath("//button[@id!='clickOnMe']")); // wszystkie buttony których id jest różne od clickOnMe

        // odszukanie elementów które zawierają
        firefox.findElement(By.xpath("//*[contains(@name,'ame')]")); // wszystkie które w atrybucie name zawierają 'ame'
        firefox.findElement(By.xpath("//*[starts-with(@name,'fn')]")); // wszystkie które w atrybucie name zaczynają się od 'fn'
        firefox.findElement(By.xpath("//*[substring(@name, string-length(@name)-string-length('ame')+1)='ame']")); // wszystkie które w atrybucie name kończą się na 'ame'

        // odszukanie dzieci
        firefox.findElement(By.xpath("//div/child::ul")); // odszuka ul, które jest dzieckiem div
        firefox.findElement(By.xpath("//div/descendant::ul")); // odszuka wszystkie ul, które są dziećmi div
        firefox.findElement(By.xpath("//div/descendant::*")); // odszuka wszystkie dzieci dla div

        // odszukanie rodziców
        firefox.findElement(By.xpath("//div/ancestor::*")); // odszuka wszystkich rodziców dla div
        firefox.findElement(By.xpath("//div/ancestor::body")); // odszuka rodziców (body/html) dla div
        firefox.findElement(By.xpath("//div/..")); // odszuka bezpośredniego rodzica dla div (body)

        // odszukanie elementów występujących po elementach
        firefox.findElement(By.xpath("//img/following::*")); // wszystkie występujące po imp z zagnieżdżonymi
        firefox.findElement(By.xpath("//img/following-sibling::*")); // bez zagnieżdżonych
        firegox.findElememnt(By.xpath("//input[@id='search_for_person_phone']/following-sibling::div/span[contains(text(),'Jedno z pól [ Nazwisko, Nr telefonu ] jest wymagane')]")); //odnajduje input, potem div który jest za nim na tym samym poziomie, a w div wyciąga span z textem

        // odszukanie elementów występujących przed elementem img
        firefox.findElement(By.xpath("//img/preceding::*")); // z zagnieżdżonymi
        firefox.findElement(By.xpath("//img/preceding-sibling::*")); // bez zagnieżdżonych

        // odszukanie dwóch różnych elementów
        firefox.findElement(By.xpath("//img | //a"));

        // odszukanie elementu przy pomocy dwóch atrybutów
        firefox.findElement(By.xpath("//input[@name='fname' and @id='fname']")); // oba atrybuty spełnione
        firefox.findElement(By.xpath("//input[@name='fname' or @id='fname']")); // jeden atrybut spełniony
        
        // odszukanie elementu przy pomocy indeksu (przykład wyszukiwania przycisku szukaj w google)
        firefox.findelement(By.xpath("(//input[@name='btnK'])[1]")));
        
        // odszukanie elementu po atrybucie, który ma jakąś,a wartość, np. placeholder, value, name, class itp.
        firefox.findelement(By.xpath("//input[@placeholder='Sortuj']");
        
        // odszukanie elementu td który ma clasę day oraz wartość textową 30
        firefox.findElement(By.xpath("//td[@class='day' and text()='30']"));
        firefox.findElement(By.xpath("//p[@class='title' and contains(text(),'Zlecenie eksportu...')]"));              
            
        // odszukanie elementu ze zbioru elementów o name=s0 i który zawiera widoczny tekst Pink Kong ale jest ona poza tagiem <input>
        firefox.findElement(By.xpath("//input[@name='s0'][contains(following-sibling::text(), 'Pink Kong')]")
            
        // odszukanie elementu ze zbioru elementów o name=s0 i który zawiera widoczny tekst (text1 to zmienna która przechowuje wylosowaną wartość) i jest poza tagiem <input>
        firefox.findElement(By.xpath("//input[@name='s0'][contains(following-sibling::text(), '"+text1+"')]")
                            
        // odszukanie elementu przez zagnieżdżenie w innym elemencie (szukany button w div)
        firefox.findElement(By.xpath("//div[@id='collapseLocalizationCards']//button"")
                                     
        // odszukanie elementu, który występuje po jakimś elemencie i jest zagnieżdżony w innym:
        // element span ma text poza span, za nim występuje button, który zawiera element i ->                              
        firefox.findElement(By.xpath("//span[contains(following-sibling::text(), 'CITO')]/following-sibling::button/i[@class='fa fa-arrow-left']"))
                                     
        // z otwartej listy class, która nie jest selectem wybieramy określoną pozycję li
        findElement(By.xpath("//*[@class='vs__dropdown-menu']/li[contains(text(),'"+value+"')]")); // dla string zawierającego fragment textu
        findElement(By.xpath("//*[@class='vs__dropdown-menu']/li[normalize-space(text())='"+value+"']")); //dla konkretnego string, usuwa white spaces                            
        findElement(By.xpath("//*[@class='vs__dropdown-menu']/li["+value+"]")); // dla int
                    
