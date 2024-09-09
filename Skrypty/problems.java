// kliknięcie w element, który jest zasłonięty przez inny, np. kliknięcie w przycisk szukania gdy zasłania go lista rozwijalna

        WebElement symphony = driver.findElement(By.xpath("//button[@class='hide-button']"));
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click()", symphony); 

// kliknięcie w pierwszy element z listy

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementsByClassName('hide-button')[0].click()");

// data wpisywana ręcznie

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('filters_orderDate_value').value='2022-02-28 23:59'");

// data wpisywana jako zmienna (string) + utrzymanie daty w polu (gdy aplikacja nie jest w stanie)

        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("document.getElementById('export_ordering_a_test_dateFrom').value='"+dataOd+"'");
        raportDataOd.click(); // aby utrzymać datę należy ponownie kliknąć w pole

// data wpisywana i wymuszenie eventu pokazującego zmianę daty (w niektórych aplikacjach może być potrzebne)

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('export_ordering_a_test_dateFrom').value='2022-12-12'");
        js.executeScript("$('#export_ordering_a_test_dateFrom').trigger('change')"); // wymuszą wywołanie eventu zmiany daty, jakby użytkownik ręcznie zmieniał

// odsłonięcie ekranu aby dany element był widoczony dla selenium

        JavascriptExecutor js0 = (JavascriptExecutor) driver;
        js0.executeScript("scrollBy(0,200)");

// pobranie wartości niewidocznego elementu z atrybutem

1. wyciągamy element-> driver.findElement(By.xpath("//input[@name='filters[voivodeship]']/following-sibling::div/div/div/span"));
2. można zapisać do zmiennej string "elo"
3. sprawdzić który atrybut przechowuje wartość:
-> F12/zbadaj na elemencie
-> w konsoli przez np. xpath wyszukać ten element
-> sprawdzić który atrybut ma wartość którą szukamy
4. elo.getAtrribute("nazwa atrybutu", np. "disabled" / "textContent")        


// pobranie atrybutu niewidocznego elementu z atrybutem np. disabled

        boolean walidator;

        String elementDisabled= filtr.getAttribute("disabled"); // zwraca string = "true"
        String wartoscElementu = wartosFiltra.getText();

        if (elementDisabled.equals("true") && wartoscElementu.equalsIgnoreCase("xxx")) {
            walidator=true;
        } else {
            walidator=false;
        }
        return walidator;
    }


// pobranie atrybutu niewidocznego elementu bez disabled, np. style=displayed: none


        boolean walidator;

        String elementDisabled= filtr.getAttribute("display"); // zwraca null
        String wartoscElementu = wartosFiltra.getText();

        if (elementDisabled==null && wartoscElementu.equalsIgnoreCase("xxx")) {
            walidator=true;
        } else {
            walidator=false;
        }
        return walidator;
    }
