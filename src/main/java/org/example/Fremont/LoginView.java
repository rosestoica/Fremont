package org.example.Fremont;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("login")
public class LoginView extends VerticalLayout {

	@Autowired
	private AuthenticationService authenticationService;

	public LoginView() {
		TextField usernameField = new TextField("Username");
		PasswordField passwordField = new PasswordField("Password");
		Button loginButton = new Button("Login");

		loginButton.addClickListener(e -> {
			String username = usernameField.getValue();
			String password = passwordField.getValue();

			if (authenticationService.authenticate(username, password)) {
				Notification.show("Login successful");
			} else {
				Notification.show("Invalid username or password", 3000, Notification.Position.MIDDLE);
			}
		});

		add(usernameField, passwordField, loginButton);
	}
}
