#TODOApp - Week 2

Android-sovellus, toteutettu Kotlinilla ja Jetpack Composella,
päivitetty käyttämään ViewModelia tehtävälistan hallintaan.

## Ominaisuudet

- Näyttää tehtävälistan LazyColumnissa
- Lisää uusi tehtävä otsikolla ja kuvauksella
- Merkitse tehtävä valmiiksi/avoimeksi (Checkbox)
- Poista tehtävä painikkeella
- Suodata tehtävät: Kaikki / Avoimet / Valmiit
- Järjestä tehtävät eräpäivän mukaan

## Datamalli

Task-data class (domain-paketti):
id: yksilöllinen tunniste
title: otsikko
description: kuvaus
priority: tärkeys
dueDate: eräpäivä (String)
done: valmiustila (true/false)
Mock-data löytyy tiedostosta MockData.kt.

## Viewmodel

- TaskViewModel hallitsee tilaa:
- tasks: MutableState<List<Task>>
- Funktiot: addTask, toggleDone, removeTask, filterByDone, sortByDueDate
- UI päivittyy automaattisesti tilan muuttuessa

## Ajaminen

Projekti voidaan ajaa Android Studiossa emulaattorilla tai fyysisellä Android-laitteella.
APK on tuotettu depug-versiosta. APK löytyy repositorion apk-kansiosta.