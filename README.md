# GraphQL Spring
* Bu uygulamanın amacı Player eklemek, silmek ve listelemek.

## Kullandığım Teknolojiler
* Java Spring
* H2 Database
* GraphQL
* JPA
* JDK 17
* Maven
* IntelliJ IDE

## Projeye Nasıl Çalıştırılır ?
* Projeyi bu adresten indirmeniz gerekiyor :[proje linki](https://github.com/Furkan-Ahmet-Ozdemir/basketball_managment)
* Projeyi zipten çıkarın.

### IDE Gerekmeden Çalıştırmak İçin:
* Bilgisayarınızda maven kurulu olmalı. Kurulu değil ise buradan kurabilirsiniz: [https://maven.apache.org/download.cgi]
* Pathe tanımlı olmalı. Tanı*mlı değil ise buradan bakabilirsiniz: [https://mkyong.com/maven/how-to-install-maven-in-windows/]
* Cmd ye ```mvn --version``` yazdığınzda ``` Apache Maven 3.8.4 ``` benzeri bir cevap almalısınız.
* Daha sonra CMD yi açıp **pom.xml**  in olduğu dizine gelin.
* ```mvn spring-boot:run``` komutunu çalıştırın.

```
Tomcat started on port(s): 8080 (http) with context path ''  
Started BasketballManagmentApplication in 7.574 seconds (JVM running for 3.991)
```

### IntelliJ IDE İle Çalıştırmak İçin:
* Projeyi IntelliJ IDE ile açın.
* ```Run BasketballManagmentApplication```
* Run kısmında aşağıdaki yazıya benzer yazılar geliyorsa proje çalışmıştır :
```
Tomcat started on port(s): 8080 (http) with context path ''  
Started BasketballManagmentApplication in 7.574 seconds (JVM running for 3.991)
```
* Ben Postman kullandım siz başka bir araç kullanabilirsiniz http://localhost:8080/graphql adresine POST isteği gönderebilirsiniz.

* Testleri çalıştırmak için ```mvn test```
###  Postman İle İstek Atma:
* Player eklemek için:
```
mutation{
  addPlayer(playerDto:{name:"Furkan",surname:"A",position:PF}){
  id, name, surname, position
  }
}
```
*İsteğine şöyle bir yanıt almalısınız:
```
{
    "data": {
        "addPlayer": {
            "id": "1",
            "name": "Furkan",
            "surname": "A",
            "position": "PF"
        }
    }
}
```
* Player listelemek için:
```
mutation{
  deletePlayer(id:1){
    id,name,surname,position
  }
}
```
*Eğer veritabanında Id=1 olan kayıt var ise şöyle bir yanıt almalısınız:
```
{
    "data": {
        "deletePlayer": {
            "id": "1",
            "name": "Furkan",
            "surname": "A",
            "position": "PF"
        }
    }
}
```
* Bütün Playerları listelemek için:
```
query{
  getAllPlayers{
    id,name,surname,position
  }
}
```
*Eğer veritabanında kayıt ya da kayıtlar var ise buna benzer yanıt almalısınız:
```
{
    "data": {
        "getAllPlayers": [
            {
                "id": "2",
                "name": "Furkan",
                "surname": "A",
                "position": "PF"
            }
        ]
    }
}
```
