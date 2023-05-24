# Country-App-be
Country Projesi Backend Kısmı
Spring Boot Rest Api Countries
Projemizde Rest API kullanarak getMapping işlemleri yapılmıştır. Countries.json üzerinde tutulan verilerde bu işlemler uygulanmıştır. Veriler json dosyasından MySql veritabanına eklenmiştir. Ekleme işlemleri DatabaseManager.java üzerinden yapılmıştır. Bu işlemler mainde run edilmiştir. Program çalıştığında her seferinde çalıştırılmamıştır.
Ekleme işlemleri yapılırken herhangi bir orm aracı kullanılmamıştır.

![ulkeeklememysql](https://user-images.githubusercontent.com/46906505/229234732-801559cf-cd56-4dda-85c6-466b9731e787.PNG)

Bazı uygulanan işlemler

1- Tüm ülkeleri getirme işlemi
![sıralama4](https://user-images.githubusercontent.com/46906505/229234273-57e59af1-76d9-40dd-ae34-fad404138f25.PNG)

2- Sadece belli bir ülke koduna sahip ülke
![sıralama2](https://user-images.githubusercontent.com/46906505/229234308-bcce274c-8198-4498-b085-a6332331ae30.PNG)

3- Ülke telefon kodlarına göre azalan veya artan şekilde tüm ülkeler.
![sıralama2](https://user-images.githubusercontent.com/46906505/229234429-2b04a9a3-ead0-4b0e-8267-f1a8809e9edc.PNG)

4- Ülkenin currency, phoneCode ve continent özelliklerine göre filtrelenmiş ülkeler.
![sıralama3](https://user-images.githubusercontent.com/46906505/229234464-29f9a131-fefe-4d3d-b6c0-686ea3524543.PNG)

