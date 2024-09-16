/*
* screen przechowywać najlepiej w tym samym folderze co raporty tylko w podfolderze, bo raport może ich nie wczytać
* zrobić ścieżkę absolutną do zapisu screena
* zrobić ścieżkę relatywną do wczytywania screena do raportu
* obie ścieżki bo dobrze wyjaśnia to chatgpt -> extent reports save screen correctly but image is broken in report
*/

Common Causes:

    Incorrect or relative paths: The path to the screenshot may not be correctly resolved, especially if the report is opened in a browser from a different directory.
    Browser security: If the file path uses a different protocol (like file:// or uses backslashes on Windows), the browser may fail to load the image.
    Relative paths: If the screenshot is saved using a relative path but the report is opened from a different location, the link will break.
