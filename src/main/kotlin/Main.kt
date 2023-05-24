import io.lexylynx.app.Application
import org.springframework.boot.SpringApplication

fun main(args: Array<String>) {

    SpringApplication.run(Application::class.java, *args)

    // val applicationContext: ConfigurableApplicationContext = SpringApplication.run(Application::class.java, *args)
    // val chatRepository = applicationContext.getBean(ChatRepository::class.java)
}