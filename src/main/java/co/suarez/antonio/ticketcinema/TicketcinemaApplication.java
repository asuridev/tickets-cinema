package co.suarez.antonio.ticketcinema;

  import org.springframework.boot.SpringApplication;
  import org.springframework.boot.autoconfigure.SpringBootApplication;
  import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
  import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


  @EnableJpaAuditing
  @EnableJpaRepositories
  @SpringBootApplication
  public class TicketcinemaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketcinemaApplication.class, args);
	}

}
  