Fortune Droid
-------------

This is a tiny, li'l pet project to play with various tools.

### What does it do?

This is still a work in progress, but eventually, Fortune Droid will periodically or on-demand generate semi-amusing "fortunes" (similar to [the unix program](https://en.wikipedia.org/wiki/Fortune_(Unix))) and publish them to social media.

### How do I build and run it?

1. Clone it, and navigate into the project directory.
2. Build it, and containerize it: `$ ./gradlew build docker`
3. Run the docker container: `$ docker run -p 8080:8080 -t org.yourotherleft/fortune-droid`
4. Test it: `$ curl localhost:8080/fortune`
5. Profit.

### Credits

Some fortunes may be retrieved from [an API](https://helloacm.com/fortune/).
