1. How long time did you end up spending on this coding test?

- Jag började på uppgiften 13/3 och har arbetat på den ca. 8h om dagen fram till idag (19/3).

2. Explain why you chose the code structure(s) you used in your solution.

Jag valde att dela upp koden i följande delar:
- Api
	- Controller
	- Modeller

Jag valde att dela upp Api:ets funktioner på såvis eftersom det underlättar vid utbyggnad att alla funktioner har individuella användningsområden. Controllern ska bara sköta inkommande HTTP-requests och felhanteringen där. Modellerna ska agera modeller för output och input. Det vore därmed väldigt enkelt att utöka Api:ets funktionalitet eftersom det endast krävs att göra en ny modell, lägga till en ny endpoint i api:et och hantera fel.

- Frontend
	- App
	- Input och output-panel

Jag valde att dela upp frontend av samma anledning. Appen håller olika funktioner. I detta fallet endast en funktion men om man vill utöka appens funktionalitet är det bara att lägga till en ny funktion i App. Mina tanker går i linje med att Input och output-panelen behöver inte känna till om det finns ytterligare funktioner i appen. Den ska bara sköta sina uppgifter. Det underlättar även debugging.

3. What would you add to your solution if you had more time? This question is especially important if you did not spend much time on the coding test - use this as an opportunity to explain what your solution is missing.

Jag hade nog kikat mer på säkerheten kring Api:et. Ex. hade jag velat undersöka hur ddos och andra attacker kan undvikas. Jag hade nog också kikat mer på utseendet av frontend och läst på om det finns några simpla designprinciper man kan följa för att göra utseendet mer tillfredställande.


4. What did you think of this recruitment test?

Jag tyckte det var roligt! Jag kan ärligt säga att jag lärt mig mycket bara av att sitta med det i några få dagar. Det är intressant hur mycket olika aspekter av programmering som kommer in i en sån här liten app. ex. analys av algoritmer (hur hittar jag det vanligaste ordet, och byter ut mot foo-bar utan att komplexiten urartar?), hur man kommunicerar enligt REST mellan de olika komponenterna? 

Verkligen skoj! :)
/Tom
