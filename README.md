#TODOApp - Week 1

Tämä projekti on Android-sovellus, joka on toteutettu Kotlinilla ja Jetpack Composella.
Sovelluksessa on yksinkertainen tehtävälista, jossa käyttäjä voi tarkastella, järjestää
ja merkitä tehtäviä tehdyksi tai tekemättömiksi.

## Datamalli

Sovelluksessa käytetään Task - data classia, joka sijaitsee 'domain' - paketissa.

Task sisältää seuraavat kentät:
- id: yksilöllinen tunnite
- title: tehtävän otsikko
- description: tehtävän kuvaus
- priority: tehtävän tärkeys
- dueDate: eräpäivä (String-muodossa)
- done: tieto siitä, onko tehtävä tehty

Mock-data on määritelty omassa tiedostossaan (MockData.kt). listana Task-olioita.

## Kotlin-funktiot

Sovelluksessa on toteutettu seuraavat Kotlin-funktiot:

- addTask(list, task): Lisää uuden tehtävän listan loppuun ja palauttaa uuden listan.
- toggleDone(list, id): Kääntää annetun id:n omaavan tehtävän 'done'-tilan (true/false).
- filterByDone(list, done): Palauttaa vain ne tehtävät, joiden 'done'-tila vastaa annettua arvoa.
- sortByDueDate(list): Järjestää tehtävälistan eräpäivän mukaan.

## Käyttöliittymä

Käyttöliittymä on toteutettu Jetpack Composella ilman XML-layoutteja.
HomeScreen näyttää:
- otsikon
- tehtävälistan tekstimuodossa
- painikkeet tehtävien järjestämiseen ja suodattamiseen

UI-koodi sijaitsee omassa tiedostossaan (HomeScreen.kt) erillään domain-paketista.

## Ajaminen

Projekti voidaan ajaa Android Studiossa emulaattorilla tai fyysisellä Android-laitteella.
APK on tuotettu depug-versiosta. APK löytyy repositorion apk-kansiosta.