/*    */ package com.viraps.command.impl;
/*    */ import com.viraps.GemmaClient;
/*    */ import com.viraps.command.Command;
/*    */ import com.viraps.command.CommandManager;
/*    */ import java.io.IOException;
/*    */ import net.fabricmc.api.EnvType;
/*    */ import net.fabricmc.api.Environment;
/*    */ 
/*    */ @Environment(EnvType.CLIENT)
/*    */ public class HelpCommand implements Command {
/*    */   public void execute(String[] args) throws IOException {
/* 12 */     GemmaClient.sendMessage("------------");
/* 13 */     for (Command command : CommandManager.commands.values()) {
/* 14 */       GemmaClient.sendMessage(command.getUsage());
/*    */     }
/* 16 */     GemmaClient.sendMessage("------------");
/*    */   }
/*    */ 
/*    */   
/*    */   public String getUsage() {
/* 21 */     return ".help";
/*    */   }
/*    */ }


/* Location:              C:\Users\SpigotRCE\Downloads\gemma-1.0.0 (5).jar!\com\viraps\command\impl\HelpCommand.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */