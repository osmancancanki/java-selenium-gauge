# Login Scenarios

To execute this specification, run
	gauge run specs

## Login as an authenticated user
tags: Smoke Tests

* Go to login page
* Enter username and password info
* Click login button

## Login with invalid credentials
tags: Negative Tests

* Go to login page
* Enter wrong username and password info
* Click login button
Check for login error


