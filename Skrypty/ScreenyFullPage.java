// wymagana dependencja ashot

Screenshot s=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(10)).takeScreenshot(browser); // czas w milisekundach w jaki przewija stronę
ImageIO.write(s.getImage(),"PNG",new File("src/test/resources/full.png")); // format pliku i ścieżka gdzie ma być zapisany wraz z nazwą i formatem
