# Product Review API

REST API za upravljanje proizvodima i njihovim recenzijama, napravljen koristeći Spring Boot.

## Tehnologije
- Java 11
- Spring Boot
- H2 baza podataka
- Maven
- Git

## Funkcionalnosti
- Unos i dohvat proizvoda
- Filtriranje produkata po šifri i imenu
- Dohvat najpopularnijih proizvoda po ocjeni
- Automatsko računanje cene u USD pozivom HNB API-ja

## Struktura projekta
- Model: Product i Review entiteti
- Repository: JPA repozitorij za pristup podacima
- Service: Biznis logika
- Controller: REST endpointi

## API Endpointi
- `POST /api/products` - Unos novog proizvoda
- `GET /api/products` - Dohvat proizvoda sa filterima
- `GET /api/products/popular` - Dohvat top 3 najpopularnija proizvoda

## Pokretanje aplikacije
1. Klonirajte repozitorij
2. Otvorite projekt u svom IDE-u
3. Pokrenite kao Spring Boot aplikaciju
4. API je dostupan na `http://localhost:8080`