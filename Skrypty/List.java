public List<String> listOfStatusReport(WebDriver driver) {

        List<String> listaStatusRaporty = driver.findElements(By.xpath("//p[@class='list-cell-header' and text()='Status']/following-sibling::p"))
                .stream()
                .map(WebElement::getText)
		.toList();

        return listaStatusRaporty;
}


List<String> nazwa = driver.findElements(By.xpath())
			.stream()
			.map(WebElement::getText) // mapuje elementy i wyciąga tekst
			.collect(Collectors.toList()); // zbiera je w listę

Assert.assertTrue(nazwa.contains("cos tam")); // sprawdzenie czy lista zawiera string

lub

List<String> nazwa = driver.findElements(By.xpath());

i w metodzie to wywołać

public List <String> pobierzNazwy() {
return // bo musi zwrócić wartość
	nazwa.stream()
		    .map(WebElement::getText) // mapuje elementy i wyciąga tekst
		    .collect(Collectors.toList()); // zbiera je w listę
}


// sprawdzanie listy

        String a = "string2";
        String b = "string0";
        String c = "string3";

        List<String> list = Stream.of(a, b, c).toList();

        System.out.println(list);

        // czy lista zawiera minimum raz string1
        Assert.assertTrue(list.contains("string1"));

        // czy lista nie zawiera w ogóle string1
        Assert.assertFalse(list.contains("string1"));

        // czy lista zawiera inne elementy niż string1
        boolean result = list.stream().noneMatch(i -> i.equals("string1"));
        System.out.println("Lista nie zawiera: " + result);


        // czy lista składa się tylko z string1
        boolean result2 = list.stream().allMatch(i -> i.equals("string1"));
        System.out.println("Wszystkie elementy listy są takie same: " + result2);
