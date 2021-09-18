# SprawdzeniePodatnika
Program do sprawdzenia podatnika w pliku płaskim udostępnianym przez MF

Jak uruchomić:
1. sklonuj repozytorium:
  <pre>git clone https://github.com/mirekgab/SprawdzeniePodatnika.git</pre>
  
2. wejdź do katalogu SprawdzeniePodatnika
3. wykonaj polecenie:
  <pre>mvn compile
mvn exec:java -Dexec.mainClass=pl.mirekgab.sprawdzeniepodatnika.Main -Dexec.args="dane_testowe.txt 2 20191121.json"</pre>

Dane testowe pobrane ze strony
https://www.gov.pl/web/kas/plik-plaski
