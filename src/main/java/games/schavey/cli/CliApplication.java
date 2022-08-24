package games.schavey.cli;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.shell.command.CommandRegistration;

import java.time.Instant;

@SpringBootApplication
public class CliApplication {
	private int number = 0;
	private int increment = 1;
	private boolean idle = false;
	private Instant idle_start;

	public static void main(String[] args) {
		SpringApplication.run(CliApplication.class, args);
	}

	@Bean
	CommandRegistration incrementRegistration() {
		return CommandRegistration.builder()
				.command("increment")
				.withTarget()
				.function(ctx -> number += increment)
				.and()
				.build();
	}

	@Bean
	CommandRegistration upgradeRegistration() {
		return CommandRegistration.builder()
				.command("upgrade")
				.withTarget()
				.function(ctx -> {
					if (number > 4) {
						number -= 4;
						return increment += 1;
					}
					return "lolubroke";
				})
				.and()
				.build();
	}

//	@Bean
//	CommandRegistration idleRegistration() {
//		return CommandRegistration.builder()
//				.command("idle")
//				.withTarget()
//				.function(ctx -> {
//					if (!idle) {
//						idle = true;
//					}
//				})
//	}

}