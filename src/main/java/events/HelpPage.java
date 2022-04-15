package events;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.awt.*;

public class HelpPage extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {
        if(event.getAuthor().isBot() || event.getAuthor().isSystem()) return;
        if (!event.isFromGuild() && !event.isFromThread()) return;

        String messageSent = event.getMessage().getContentRaw();

        if(messageSent.equalsIgnoreCase("!help")) {
            EmbedBuilder help = new EmbedBuilder();

            help.setTitle("Info about Voc Viewer");
            help.setColor(Color.orange);
            help.setDescription("!showVocs");
            help.addField("What can this bot do?", "This Bot shows guild memebers joining voice channels.", false);
            help.setColor(Color.CYAN);
            event.getChannel().sendMessageEmbeds(help.build()).queue();
        }
    }

}