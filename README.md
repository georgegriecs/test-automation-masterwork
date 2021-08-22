
# Green Fox - Test-Automation Vizsgaremek
<br />

### Követelmények:

1. Regisztráció: min. 2 teszteset, 1 sikeres 1 sikertelen
2. Bejelentkezés: min. 2 teszteset, 1 sikeres 1 sikertelen
3. Privacy statement használata: legalább 1 teszteset: PS megnyitása és checkbox kipipálás
4. Adat listázás: bármilyen adatból lista megjelenítése, min. 1 teszteset, az-e a sorrend mint amire számítok?
5. Pagination: egy adatlista után másik betöltése, min. 1 teszteset
6. Új adat bevitele: eddig nem létező adat bevitele a rendszerbe (komment, poszt, kérdés, stb.) min. 1 teszteset
7. Repetitív adatbevitel: eddig nem létező adat bevitele a rendszerbe (komment, poszt, kérdés, stb.) .csv fielból min.1
teszteset
8. Létező adat változtatás: már létező adat megváltoztatása a rendszerben (comment szerkesztése, felhasználói
adatok megváltoztatása, rendelés darabszám növelés) min 1. Teszteset
9. Adat törlése: min. 1 teszteset, létező adat törlése
10. Adat mentése az applikációból: létező, repetitív adat mentése az appikációból min.1 reszteset (összes termék,
összes poszt, felhasználó összes kommentje stb...) min. 1 teszteset
11. Kijelentkezés: min. 1 teszteset, sikeres kilépés


### Tesztelt weboldal elérhetősége: 

http://test-automation-shop2.greenfox.academy/ 
<br />

### Manuális tesztesetek:

https://docs.google.com/spreadsheets/d/1Lg9EH8voRupx4iNbNSBBjEG75eUIgl3t/edit?usp=sharing&ouid=100619899740904833217&rtpof=true&sd=true

### A távoli repository klónozása a lokális:
git clone https://github.com/georgegriecs/test-automation-masterwork.git

### Tesztek futtatása:

cd test-automation-masterwork
<br />
.\gradlew clean test

### Allure report generálása:

.\gradlew allureReport
<br />

### Allure Server indítása:

.\gradlew allureServe

