# Tim's Kotlin Playground

My hands-on-learnings with Kotlin, each directory is some mini-project for me to track random things I try out.

### echo-server

A small project to create a Jetty server, to see what Java interop was like with Kotlin.
`MainKt` is the main class which starts a server on `8080 ` that just echos back whatever data you include.

Interesting thing I learned with this one was that Java getters/setters are exposed as properties in Kotlin:
https://kotlinlang.org/docs/java-interop.html#getters-and-setters

```bash
$ curl localhost:8080 -d "Hey Tim"
$ Hey Tim
```