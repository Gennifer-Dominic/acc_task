package acc.acc_task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import acc.acc_task.App;

import acc.acc_task.payload.fileproperties;

@EnableAutoConfiguration
@SpringBootApplication
@EnableConfigurationProperties({
	fileproperties.class
})
public class App 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);
    }
}
