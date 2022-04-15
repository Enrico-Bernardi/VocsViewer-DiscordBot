import events.HelpPage;
import events.VocsViewer;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

public class Main {

    public static void main(String[] args) throws LoginException {
        JDABuilder jda = JDABuilder.createDefault("BOT_TOKEN_HERE");

        jda.addEventListeners(new VocsViewer());
        jda.addEventListeners(new HelpPage());
        jda.build();
    }

}
