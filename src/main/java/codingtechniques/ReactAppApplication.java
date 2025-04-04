package codingtechniques;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.stream.Collectors;

@SpringBootApplication
public class ReactAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactAppApplication.class, args);
	}
    @GetMapping("/")
    public String getClientInfo(HttpServletRequest request) {
        String xForwardedFor = request.getHeader("X-Forwarded-For");
        String remoteAddr = request.getRemoteAddr();
        
        return String.format(
            "<h1>Client Information</h1>" +
            "<p><b>X-Forwarded-For:</b> %s</p>" +
            "<p><b>Remote Address:</b> %s</p>" +
            "<p><b>All Headers:</b> %s</p>",
            xForwardedFor,
            remoteAddr,
            Collections.list(request.getHeaderNames())
                .stream()
                .map(name -> name + ": " + request.getHeader(name))
                .collect(Collectors.joining("<br>"))
        );
    }

}
