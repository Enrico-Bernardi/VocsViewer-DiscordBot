package events;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.VoiceChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.List;

public class VocsViewer extends ListenerAdapter {

    public void onMessageReceived(MessageReceivedEvent event) {
        if(event.getAuthor().isBot() || event.getAuthor().isSystem()) return;
        if (!event.isFromGuild() && !event.isFromThread()) return;

        String messageSent = event.getMessage().getContentRaw();

        if(messageSent.equalsIgnoreCase("!showVocs")) {
            List<VoiceChannel> channels = event.getGuild().getVoiceChannels();
            String users = "";
            for (VoiceChannel channel : channels) {
                if(channel.getMembers().size() > 0) {
                    users += "In channel ";
                    users += channel.getAsMention() + " ";
                    if(channel.getMembers().size() == 1){
                        users += "there is: ";
                    } else {
                        users += "there are: ";
                    }
                    for (int i=0; i<channel.getMembers().size(); i++) {
                        Member member = channel.getMembers().get(i);
                        users += member.getUser().getAsMention();
                        if(channel.getMembers().size() != 1 && i != channel.getMembers().size()-2 && i != channel.getMembers().size()-1){
                            users += ", ";
                        } else if(channel.getMembers().size() != 1 && i != channel.getMembers().size()-1) {
                            users += " and ";
                        }
                    }
                    users += '\n';
                }
            }

            String usersInChannels = "";
            if (users.equalsIgnoreCase("")) {
                usersInChannels = "All voice channels are empty!";
            } else {
                usersInChannels = users;
            }
            event.getMessage().reply("**Voice Channels Viewer:**\n\n" + usersInChannels).queue();
        }
    }
}