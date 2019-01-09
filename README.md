Fortune Droid
-------------

This is a tiny, li'l pet project to play with various tools.

### What does it do?

This is still a work in progress, but eventually, Fortune Droid will periodically or on-demand generate semi-amusing "fortunes" (similar to [the unix program](https://en.wikipedia.org/wiki/Fortune_(Unix))) and publish them to social media.

### What does it do?

### On MacOS (hopefully mildly helpful for anyone else):

#### Clone repo

1. Clone repo
```
git clone [repo] [desired folder]
```

#### Setup Java/Gradle/Fortune

1. Install JDK 11
See: https://docs.oracle.com/en/java/javase/11/install/installation-jdk-macos.html#GUID-2FE451B0-9572-4E38-A1A5-568B77B146DE

2. Install Gradle
```
brew install gradle
```

3. Install JEnv
```
brew install jenv
```
4. Add applicable versions to JEnv
See: http://www.jenv.be/
Something like this should work:
```
jenv add /Library/Java/JavaVirtualMachines/[INSERT JAVA VERSION HERE]/Contents/Home
```

5. CD to project folder

6. Set local directory to Java 11
```
jenv local [INSERT JAVA VERSION]
```

7. Set up Gradle wrapper
```
gradle wrapper
```

8. Install Fortune
```
brew install fortune
```

#### Build/run application

1. CD to folder

2. Build app
```
gradle build
```

2. Run app with Spring
```
gradle bootRun
```

### Additional Resources

More info on setting up/using gradle: https://guides.gradle.org/building-java-applications/ 

### Credits

Some fortunes may be retrieved from [an API](https://helloacm.com/fortune/).
