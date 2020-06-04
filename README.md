# Cinema Web App: QA Cinemas
This project set out to create a new website for QA Cinemas, a well known cinema chain. The aim of this project was to be achieved in a team of 5 by satifying all the "essential" requirements alogn with the "desirable" requirements. These requirements include presenting information about the movies, listings, upcoming releases, screen rooms, about us, movie comments amongst various other functions of a cinema site. This task was to be completed in the course of tow 4-day Sprints before it is scheduled to 'go live'.  


## Table of Contents

1. [About the Project](#about-the-project)
1. [Project Status](#project-status)
1. [Getting Started](#getting-started)
    1. [Dependencies](#dependencies)
    1. [Building](#building)
    1. [Usage](#usage)
1. [Release Process](#release-process)
    1. [Versioning](#versioning)
1. [Further Reading](#further-reading)
1. [License](#license)
1. [Authors](#authors)
1. [Acknowledgements](#acknowledgements)

## About the Project

##### The overall objective of the project:

To create a full-stack Web application suitable for a given client specification, with utilisation of supporting tools, methodologies and technologies that encapsulate all modules covered during training.



##### The MVP was to be achieved with the following requirements:

* Full commitment to an Agile approach throughout the project, including daily stand-up meetings and utilisation of Sprints, user stories, acceptance criteria, story points, and effective communication within the team.

* A Kanban board with full expansion on user stories and tasks needed to complete the project. Providing a record of any issues or risks that were faced during the course of the project.

* Code fully integrated from every team member into a central repository on a Version Control System, with utilisation of issues, pull requests, merge requests, and any other aspects.

* Fully designed backend test suites for the application. Striving to achieve industry-standard (80%) test coverage through both unit and integration testing.

* Fully-designed frontend test suites for the application, which cover a wide range of user journeys.


<details>
<summary>Technologies Used</summary>
    
* Version Control System: Git
* Source Code Management: GitHub
* Kanban Board: Jira
* Back-End Programming Language: Java
* API Development Platform: Spring
* Front-End Web Technologies: HTML, CSS, JavaScript (no frameworks)
* Build Tool: Maven
* Unit Testing: JUnit / TestNG, Mockito
* Integration Testing: Selenium
* Test Reporting: Surefire / ExtentReports
* CI Server: Jenkins
* Static Analysis: SonarQube

</details>

Kanban Board for Project: [Jira](https://hobby-site.atlassian.net/secure/RapidBoard.jspa?rapidView=2&projectKey=QCP&selectedIssue=QCP-60&atlOrigin=eyJpIjoiOTA4NmMxYzJlNzVkNGQ1NDg2MDc4YmYxODViNGQ2NzkiLCJwIjoiaiJ9)

Presentation on the project: [on google slides](???)


**[Back to top](#table-of-contents)**

## Test Coverage 

#### Unit & Integration Tests
* For src/main/java: ??% 
* Sonarqube: ??%

#### Automated Web Tests: 
* Selenium: ??


**[Back to top](#table-of-contents)**

## Getting Started

### Dependencies
What things you need to install the software and where to find them.

**To Run**

In the event of Google Cloud Platform App Engine not being live.
```
Java SE 8 (or later) to run the jar file.
Maven to create the jar-file and run.

In regards to veiwing from the front-end, most desktop and mobile browsers are suitable.
```
**To Develop**

All dependencie libraries are to be downloaded automatically, as instructed by the 'pom.xml'. 

```
IntelliJ & Eclipse IDEs were used for this project.
Postman was used to test API calls from the H2, The Movie Database and Seats.io database before implementing them within the project.
For the CI pipeline, Jenkins was used for this project.
```

<details>
<summary>Links for Dependencies</summary>
<p>Below are a list of dependencies used within the project.</p>
* [Java SE 14](https://www.oracle.com/java/technologies/javase-downloads.html#JDK14),
* [Apache Maven](https://maven.apache.org),
* [Git](https://git-scm.com/downloads),
* [IntelliJ Ultimate](https://www.jetbrains.com/idea/download/#section=windows),
* [Eclipse IDE](https://www.eclipse.org/downloads)
* [Jenkins](https://jenkins.io/download).
* [Postman](https://www.postman.com/downloads).
* [Google Chrome](https://www.google.com/chrome).
</details>

### Getting the Source

This project is hosted on [GitHub](https://github.com/Ashillqa/QACinema). You can clone this project directly using this command in the Command Prompt:

```
git clone https://github.com/Ashillqa/QACinema
```
**[Back to top](#table-of-contents)**
## Building

How to build the project: 

### Built With

[Maven](https://maven.apache.org/) - Dependency Management

* Clone the repo to your machine.
* Open the cmd line / git bash inside the repo file directory.
* Run the following commands:

``` mvn clean package ```

``` mvn spring-boot:run ```

Note: When you run the second command the program will run, launching the Spring boot application. You can then navigate to `localhost:8181` via a browser or my shortcut provided in this repo, to reach the home page of the web interface. The app will run until you trigger the `/shutdownAppContext` API call.

### API Reference

[The Movie Database](https://developers.themoviedb.org/4/getting-started/authorization) - this database was used to make API(s) calls for all the movie information, throught the movie listing pages.
[Seats.io](https://www.seats.io/) - this database was used to make API(s) calls for the seats GUI on the "screens.html" page.


### Running Tests

The easiest way to run all my existing tests is to right click on `src/test/java/com/qa/test` in your IDE and select `Run tests in 'src/test/java/com/qa/test'` or `Run tests in 'src/test/java/com/qa/test' with Coverage`



**[Back to top](#table-of-contents)**
#### Unit Tests 
JUnit is used for unit tests. A unit test will test individual methods within a class for functionality. Below is a simple Unit Test for my UserDTO class:

```
@Before
    public void init() {
        this.bookingList = new ArrayList<>();
        this.testBooking = new Booking(1L, "Shrek 3", "27/05/2020 15:30", BigDecimal.valueOf(13.99),"email@email.com","0044 771234123","Jeff Tester",1,1,0);
        this.bookingList.add(testBooking);
        this.testBookingWithID = new Booking(testBooking.getMovieName(),testBooking.getDateTime(),testBooking.getTotalPrice(),testBooking.getEmailAddress(),testBooking.getPhoneNumber(),testBooking.getCustomerName(),testBooking.getAdultNr(),testBooking.getChildNr(),testBooking.getStudentNr());
        this.testBookingWithID.setId(id);
        this.bookingDTO = this.mapToDTO(testBookingWithID);
    }

    @Test
    public void createBookingTest() {
        when(this.service.createBooking(testBooking)).thenReturn(this.bookingDTO);

        assertEquals(new ResponseEntity<BookingDTO>(this.bookingDTO, HttpStatus.CREATED), this.controller.createBooking(testBooking));

        verify(this.service, times(1)).createBooking(this.testBooking);
    }

```

In IntelliJ, when you click the @Test annotation, it gives you the option to run tests in a class, or individual Tests. Indicated by the green arrows in the margins.


**[Back to top](#table-of-contents)**
#### Integration Tests 
Mockito is used for intergration testing, to test how different classes interact with each other. Using 'mocking', methods & classes can be tested for inegration by assuming the methods & classes it relies on are fully functional.

```
 @Before
    public void init() {
        this.repo.deleteAll();
        this.testBooking = new Booking(1L, "Shrek 3", "27/05/2020 15:30", BigDecimal.valueOf(13.99),"email@email.com","0044 771234123","Jeff Tester",1,1,0);
        this.testBookingWithID = this.repo.save(this.testBooking);
        this.id = this.testBookingWithID.getId();
        this.bookingDTO = this.mapToDTO(testBookingWithID);
    }

    @Test
    public void testCreateBooking() throws Exception {
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.request(HttpMethod.POST, "/booking/createBooking");
        mockRequest.contentType(MediaType.APPLICATION_JSON);
        mockRequest.content(this.mapper.writeValueAsString(testBooking));
        mockRequest.accept(MediaType.APPLICATION_JSON);

        ResultMatcher matchStatus = MockMvcResultMatchers.status().isCreated();
        ResultMatcher matchContent = MockMvcResultMatchers.content().json(this.mapper.writeValueAsString(bookingDTO));
        this.mock.perform(mockRequest)
                .andExpect(matchStatus).andExpect(matchContent);

    }
```
In IntelliJ, when you click the @Test annotation, it gives you the option to run tests in a class, or individual Tests. Indicated by the green arrows in the margins.


**[Back to top](#table-of-contents)**

#### User acceptance Tests (with Selenium)
Selenium uses the `chromedriver.exe` included in this repository to run automated tests mocking use of the front-end. The `extent-report.xml` and dependencies required to get easy to read test reports in the form of html files are included in project folder.


The selenium tests can be found in `src/test/java/com/qa/test/selenium` within the project repository.

#### Static analysis
Sonarqube is used for static analysis. This is a good indication of adherence to the industry's standard, test coverage, highlighting bugs and security warnings within the code.

```
mvn clean package
sonar:sonar -Dsonar.host.url=http://YourVMForSonarQubeIP:PORT/ -Dsonar.login.admin=admin -Dsonar.password=admin
```

**[Back to top](#table-of-contents)**

## Usage

This project is a demonstration of Spring libraries, Databases, API calls, Front-End Delvelopment & Testing.

**[Back to top](#table-of-contents)**

## Release Process

This project is in development, only for demo purposes and not yet at the'release' stage.

### Versioning

We use [SemVer](http://semver.org/) for versioning.

**[Back to top](#table-of-contents)**

## Further Reading

Spring:
- [Spring Boot Reference Documentation](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#boot-documentation)


Front-end:
- [Get started with Bootstrap](https://getbootstrap.com/docs/4.5/getting-started/introduction/)


**[Back to top](#table-of-contents)**
## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

**[Back to top](#table-of-contents)**
## Authors

* **[Ashill Pathak](https://github.com/Ashillqa)**
* **[David Williams](https://github.com/DavidWilliamsQA)**
* **[Korbinian Ring](https://github.com/KMRRingQA)**
* **[Matthew Burt](https://github.com/MatthewBurtQA)**
* **[Tawanda Siyamachira](https://github.com/TSiyamachiraQA)**


## Acknowledgements

* Jordan [[JHarry444](https://github.com/JHarry444)]
for his help and guidance during the project.
* Nick [[nickstewarttds](https://github.com/nickrstewarttds)]
for his help and guidance during the project.

**[Back to top](#table-of-contents)**
