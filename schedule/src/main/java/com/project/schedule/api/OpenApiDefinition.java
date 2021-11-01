package com.project.schedule.api;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "Scheduler app",
                description = "" +
                        "Created by 3 young students",
                contact = @Contact(
                        name = "Author",
                        url = "https://github.com/mahdychnazar/Schedule",
                        email = "nazar.mahdych@ukma.edu.ua"
                ),
                license = @License(
                        name = "MIT Licence",
                        url = "https://github.com/thombergs/code-examples/blob/master/LICENSE")),
        servers = @Server(url = "http://localhost:8080")
)
public class OpenApiDefinition {
}
