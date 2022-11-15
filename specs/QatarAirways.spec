Specification Heading
=====================

This is an executable specification file. This file follows markdown syntax.
Every heading in this file denotes a scenario. Every bulleted point denotes a step.

To execute this specification, run
	gauge specs

Qatar Airways için Appium Mobil Otomasyon
-----------
* "2" saniye kadar bekle
* bildirimler aktif edilir
* Uygulamanın acildigi kontrol edilir.
* Alt menuden “Book” tabına gecis yapilir.
* Seyehat tipi olarak “one way” secilir.
* Kalkis havaalanı olarak Abha(Arabic) secilir.
* Varis havaalani olarak Bodrum(Turkiye) secilir.
* (Bugunun tarihi + 7 gun) olarak bir gidis tarihi secilir
* Arama butonuna tıklanir
* Ucus secim ekraninin geldigi kontrol edilir
* Rastgele bir ucus secilir.
* Ucus secim ekranındaki ucus saati ile ucus detaylari ekranindaki ucus saati degeri ayni mi kontrol edilir