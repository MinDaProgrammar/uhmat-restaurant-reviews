# Uhmat (어맛) — Restaurant Review & Food Community Web App (Java Servlets, JSP, MySQL)

A full-stack web platform for discovering restaurants in Busan, writing reviews and sharing food content, built as a team project during a Java full-stack development course in Busan, Korea (2022). The UI is in Korean.

## Features

- **Restaurants:** listing with category filter, detail pages with a **Kakao Maps** location, a map view of all restaurants, and admin create / edit / delete
- **Reviews:** write and edit reviews with images, likes, comments, and an infinite-scroll review feed; best and recent reviews on the home page (AJAX)
- **Search:** one search across restaurants and reviews by keyword, category, or both
- **Community boards:** recipes, dining-companion ("mate") posts and free talk, each with comments and nested replies
- **Members:** sign-up with email verification (SMTP), duplicate email / nickname checks, password reset by mail, and **Naver / Kakao / Google** social login
- **Service centre and admin:** notices, FAQ, events, member management and a moderation view across all boards

## Architecture

Front-controller MVC on the Servlet API, without a framework:

```
src/main/java/
├── controller/   # *FrontController servlets route each URL to an Action
├── action/       # one Action class per use case (restaurant, review, member, community, admin, ...)
├── svc/          # service layer: transactions around DAO calls
├── dao/          # JDBC data access via a Tomcat JNDI connection pool
├── vo/           # DTOs and pagination
├── db/  mail/  util/
src/main/webapp/  # JSP views, CSS, JS (jQuery / AJAX), images
```

## My role

- Built the restaurant pages (listing, category display, edit) and the Kakao Maps integration
- Implemented the combined category + keyword search and the infinite-scroll review list
- Wrote the review queries that join member data (profile icons) into reviews and community posts, and the AJAX restaurant section on the home page
- Integrated the team members' modules into one codebase and deployed it to a MariaDB / Tomcat server for the final demo

## Running locally

Requires Java 11+, Apache Tomcat 9 and MySQL / MariaDB. The libraries are in `src/main/webapp/WEB-INF/lib`.

1. Create a database named `uhmat` and set `YOUR_DB_USER` / `YOUR_DB_PASSWORD` in `src/main/webapp/META-INF/context.xml`
2. Replace `YOUR_KAKAO_JS_KEY` in the JSP files with a Kakao Maps JavaScript key
3. For email and Naver login, set the environment variables `SMTP_USER`, `SMTP_APP_PASSWORD`, `NAVER_CLIENT_ID` and `NAVER_CLIENT_SECRET`
4. Import the project into Eclipse or IntelliJ as a dynamic web project and run it on Tomcat

## Note

This is a cleaned copy of the original team repository: API keys and passwords were removed, and team members' photos on the "developers" page were left out for privacy.
