SpringMVC_MessageBoard
======================

A very simple Spring MVC 3 Message Board app (to be used as a starter Spring MVC 3 app).

* It is a maven project.
* It allows access via JSP pages and a RESTful API.

TODO: Document how to use it :)


Code layout:

.
|-- README.md
|-- pom.xml
`-- src
    `-- main
        |-- java
        |   `-- com
        |       `-- spiderlogic
        |           |-- controller
        |           |   `-- MessageBoardController.java
        |           `-- model
        |               `-- Message.java
        |-- resources
        `-- webapp
            `-- WEB-INF
                |-- mvc-dispatcher-servlet.xml
                |-- pages
                |   |-- list.jsp
                |   |-- messageform.jsp
                |   `-- singlemessage.jsp
                `-- web.xml

11 directories, 10 files
