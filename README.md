Hello All,

The application integrated with the REST API of the GitHub service. After local launch of the application, sending requests to the address is available:

http://localhost:8080/

The application allows downloading all public repositories of a given user. The request to return the data can be sent to:

http://localhost:8080/get-all-repo/{userName}

The request defaults to a header that returns data in json form. Data in xml form is not accepted. Also, an invalid username will return an error.

Enjoy testing.