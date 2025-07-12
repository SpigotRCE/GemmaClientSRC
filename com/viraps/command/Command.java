package com.viraps.command;

import java.io.IOException;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public interface Command {
  void execute(String[] paramArrayOfString) throws IOException;
  
  String getUsage();
}


/* Location:              C:\Users\SpigotRCE\Downloads\gemma-1.0.0 (5).jar!\com\viraps\command\Command.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */