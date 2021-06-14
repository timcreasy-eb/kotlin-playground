import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.eclipse.jetty.server.Request
import org.eclipse.jetty.server.handler.AbstractHandler
import org.eclipse.jetty.server.Server as JettyServer

private class EchoHandler: AbstractHandler() {
    override fun handle(
        target: String?,
        baseRequest: Request?,
        request: HttpServletRequest?,
        response: HttpServletResponse?
    ) {
        // https://kotlinlang.org/docs/java-interop.html#getters-and-setters
        // Java getters and setters are represented as properties in Kotlin
        val requestMessage = baseRequest?.reader?.readText()
        response?.contentType = "text/plain"
        response?.status = HttpServletResponse.SC_OK
        baseRequest?.isHandled = true
        response?.writer?.println(
            requestMessage
        )
    }
}

class EchoServer(private val port: Int) {
    private val server = JettyServer(port)

    fun start() {
        server.apply {
            handler = EchoHandler()
            start()
        }
        println("Server started on port ${port}!")
    }
}

fun main(args: Array<String>) {
    EchoServer(8080).start()
}