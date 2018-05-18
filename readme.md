# jLuhn
### A java implementation of the Luhn algorithm

## Add jLuhn to your project
### Maven
Add the following repository:

    
	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>

And the following dependency:

    
	<dependency>
	    <groupId>com.github.Olverine</groupId>
	    <artifactId>jLuhn</artifactId>
	    <version>-SNAPSHOT</version>
	</dependency>
### Gradle
Add the following repository:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
And the following dependency:

	dependencies {
	        implementation 'com.github.Olverine:jLuhn:-SNAPSHOT'
	}


## How to use jLuhn
### Generating check digit

    Luhn.calculateCheckDigit("448501020083410");
This code snippet will return the numerical value of the check digit as an integer (1 in this case).

If the number sequence contain any non numerical characters, they have to be ignored. The following code demonstrates how to ignore characters.

    Luhn.calculateCheckDigit("811218-987", "-");
The second parameter of this method takes a regex pattern and the algorithm will ignore everything that matches it.

### Verifying number sequnces
The following code demonstrates how a to check a number sequence using jLuhn:

    boolean valid = Luhn.verify("4485010200834101");
Just like when generating a check digit, all non numerical characters need to be ignored by passing a regex string as a second parameter:

    boolean valid = Luhn.verify("811218-9876", "-");
