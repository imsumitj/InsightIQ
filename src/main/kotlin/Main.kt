import io.lexylynx.app.Application
import io.lexylynx.utils.KeyManager
import org.springframework.boot.SpringApplication
import org.springframework.context.ConfigurableApplicationContext


fun main(args: Array<String>) {
    //SpringApplication.run(Application::class.java, *args)

    // Open AI recommends using env variable to store API key
    // https://help.openai.com/en/articles/5112595-best-practices-for-api-key-safety
    val apiKey = System.getenv("OPENAI_API_KEY")

    val applicationContext: ConfigurableApplicationContext = SpringApplication.run(Application::class.java, *args)
    val keyManager = applicationContext.getBean(KeyManager::class.java)
    keyManager.addKey("test", KeyManager.SecureKey(apiKey))
}