package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class YtSpringFxHibernateH2Application extends Application {

	public static ConfigurableApplicationContext springContext;
	private FXMLLoader fxmlLoader;

	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		fxmlLoader.setLocation(getClass().getResource("/sample.fxml"));

		Parent root = fxmlLoader.load();

		stage.setTitle("Sample App");
		Scene scene = new Scene(root,800,600);
		stage.setScene(scene);
		stage.show();
	}

	@Override
	public void init() throws Exception {
		springContext = SpringApplication.run(YtSpringFxHibernateH2Application.class);
		fxmlLoader = new FXMLLoader();
		fxmlLoader.setControllerFactory(springContext::getBean);
	}

	@Override
	public void stop() throws Exception {
		springContext.stop();
	}
}
