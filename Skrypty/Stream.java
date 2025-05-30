// elementów np. dzień "30" może być więcej niż jeden
// dlatego należy wyszukać pełną listę i wybrać konkretny

firefox.findElements(By.xpath("//td[@class='day ' and text()='30']"))
                .stream()
                .filter(el -> el.isDisplayed()) // displayed to czy jest wyświetlony, enabled czy ogólnie jest dostęny
                .findFirst() // wybierz pierwszy
                .ifPresent(el -> el.click()); // jak jest wyświetlony to kliknij



// wyciągnięcie nazw hoteli
List<String> nazwyHoteli = firefox.findElements(By.xpath("//h4[@class='RTL go-text-right mt0 mb4 list_title']//b"))
                .stream()
                .map(el->el.getAttribute("textContent"))
                .collect(Collectors.toList());
        	nazwyHoteli.forEach(el-> System.out.println(el));

// sprawdzanie czy nazwy hoteli się zgadzają
Assert.assertEquals("Jumeirah Beach Hotel",nazwyHoteli.get(0)); // sprawdza czy nazwa jest taka sama jak z listy nazwyHoteli z 1 miejsca

// sprawdzenie ile hoteli znalazło
List<WebElement> iloscHoteli = firefox.findElements(By.xpath("//h4[@class='RTL go-text-right mt0 mb4 list_title']//b"));
System.out.println("Znalazło hoteli: "+iloscHoteli.size());


// odszukanie przycisku konta

firefox.findElements(By.xpath("//li[@id='li_myaccount']"))
                .stream()
                .filter(WebElement::isDisplayed) // sprawdzamy tylko wyświetlone (bo jeden jest niewyświetlony)
                .findFirst() // bierzemy pierwszy
                .ifPresent(WebElement::click); // w widoczny klikamy
