// jak budować xpath -> https://www.cheat-sheets.org/saved-copy/Locators_table_1_0_2.pdf 
// https://www.youtube.com/watch?v=8-7XT8fwDIQ 

dla xpath -> $x("")
  - tag, np. input -> $x("//input/div/button[@id='xxx']")
  
dla css:
- cssId -> $$("#nazwa")
- class -> $$(".nazwa")
  
dla html:
- tag, np. input -> $$("input/div/button[id='xxx']")
- name/inne atrybuty -> $$("[name='nazwa']")
  
  
  // sprawdzenie czy element jest klikalny
  // #id
  // .class
  $("#divLargeId_1000").click()
  
  // name
  document.getElementsByName('btnI')[0].click()
