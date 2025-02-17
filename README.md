# Benefactor Solution

A solution for the problem provided by "Benefactor".
This is a Maven project, designed to run on a Mac. It uses Page Object Model ([POM](https://www.selenium.dev/documentation/test_practices/encouraged/page_object_models/)), [Google Chrome for Testing](https://developer.chrome.com/blog/chrome-for-testing/),

## Table of Contents

- [Installation](#installation)
- [Usage](#usage)
- [Scope](#scope)
- [Not-Tested](#not-tested)

## Installation

1. Install [Maven](https://maven.apache.org/install.html)

2. Install [Google Chrome for Testing](https://developer.chrome.com/blog/chrome-for-testing/), preferably in the Applications folder.

3. Clone the repository:

```
 git clone https://github.com/wlreed/benefactor.git
```

3. Install dependencies:

```
 mvn compile
 mvn test-compile
```

## Usage

To run the project, use the following command:

```
mvn test
```

## Scope

The scope of this test is covered under the .pdf handout.
The scope is limited to what is on that document.

## Not-tested

Too many things are out of scope for this testing to list, but here are a few:

1. Different versions of Chrome. As is, this testing is set to Chrome version 129, but that can be changed by the user. It is out of scope to download and install another version.
2. Other browsers. Selenium driver is limited to ChromeDriver only, and thus accomplished in TestNG @BeforeSuite. To improve this project, suggest looking into a Factory pattern that instantiates different drivers on demand, for example due to a settings change.
3. Other elements on Google Finance webpage.
