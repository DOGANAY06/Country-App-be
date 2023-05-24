# Country-App-be
Country Projesi Backend Kısmı
Projemizde Rest API, Criteria API  kullanarak getMapping işlemleri yapılmıştır.
Countries.json üzerinde tutulan veriler MySql veritabanına yazılmış olup. Veritabanı tabloları oluşturulurken Jpa Hibernate ORM teknolojisi kullanılmıştır. Daha sonra bu eklenen veriler docker üzerinde bulunan MySql compose edilerek oraya da eklenmiştir. 

![ulkeeklememysql](https://user-images.githubusercontent.com/46906505/229234732-801559cf-cd56-4dda-85c6-466b9731e787.PNG)

Tüm ülkeleri ekleme işlemi şu şekilde uygulanmıştır. 
http://localhost:8080/countries/one-time-insert

Bazı uygulanan işlemler

1- Tüm ülkeleri getirme işlemi
![sıralama4](https://user-images.githubusercontent.com/46906505/229234273-57e59af1-76d9-40dd-ae34-fad404138f25.PNG)

2- Sadece belli bir ülke koduna sahip ülke
![sıralama2](https://user-images.githubusercontent.com/46906505/229234308-bcce274c-8198-4498-b085-a6332331ae30.PNG)

3- Ülke telefon kodlarına göre azalan veya artan şekilde tüm ülkeler.
![sıralama2](https://user-images.githubusercontent.com/46906505/229234429-2b04a9a3-ead0-4b0e-8267-f1a8809e9edc.PNG)

4- Ülkenin currency, phoneCode ve continent özelliklerine göre filtrelenmiş ülkeler.
![sıralama3](https://user-images.githubusercontent.com/46906505/229234464-29f9a131-fefe-4d3d-b6c0-686ea3524543.PNG)

5- Veritabanına yeni ülke eklemek için PostMapping işlemi yazıldı CountryJpaController da yer alıyor.
![countryadd](https://github.com/DOGANAY06/Country-App-be/assets/46906505/5724c2f7-de31-4255-9412-bf5536678db9)

6- Projeye CrossOrigin eklenerek projenin Frontent uygulaması ile haberleşmesi sağlandı.
@CrossOrigin(origins = "http://localhost:3000") //bizde uygulama 3000 portunda çalışıyordu Frontent hali
7- DeleteMapping işlemi yazıldı, bu işlem ile arayüzde silme işlemi tetiklenip veritabanında silme işlemi yapıldı
![ulkesilme](https://github.com/DOGANAY06/Country-App-be/assets/46906505/894803fd-64c0-454e-bbdc-167897cae2b4)

8- Projeye docker compose dosyaları eklendi, MySql ve spring boot uygulaması docker üzerinde çalışır hale getirildi.
8-a) Docker file ile proje jar dosyası hazırlandı. 
8-b) application-dev.yml ile  Geliştirme ortamı için konfigürasyonları yapıldı.
8-c) application-prod.yml ile Üretim ortamı için konfigürasyonları yapıldı.
8-d) Docker-compose.yml ile bağlantı aayarları ve MySql spring boot arasında ağ kuruldu.
8-e) Projede bulunan init.sh öncelikle MySql veritabanın çalışmasını daha sonra spring boot uygulaması ayağa kalkacak şekilde çalıştırmayı sağlıyor. 
./init.sh
Proje docker compose üzerinde ayağa kalkarken terminalde bu kodu yazmanız gerekiyor. 





