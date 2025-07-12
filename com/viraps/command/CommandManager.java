/*    */ package com.viraps.command;
/*    */ 
/*    */ import com.viraps.GemmaClient;
/*    */ import java.io.IOException;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ import net.fabricmc.api.EnvType;
/*    */ import net.fabricmc.api.Environment;
/*    */ 
/*    */ @Environment(EnvType.CLIENT)
/*    */ public class CommandManager
/*    */ {
/* 13 */   public static Map<String, Command> commands = new HashMap<>();
/*    */ 
/*    */   
/*    */   public static void register(String name, Command command) {
/* 17 */     System.out.println("Registering command: " + name);
/* 18 */     commands.put(name.toLowerCase(), command);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void execute(String content) throws IOException {
/* 23 */     if (content.startsWith(".")) {
/* 24 */       String[] args = content.split(" ");
/* 25 */       String cmd = args[0].substring(1).toLowerCase();
/* 26 */       Command command = commands.get(cmd);
/* 27 */       if (command != null) {
/* 28 */         command.execute(args);
/*    */       } else {
/* 30 */         GemmaClient.sendMessage("Command " + cmd + " Not found");
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\SpigotRCE\Downloads\gemma-1.0.0 (5).jar!\com\viraps\command\CommandManager.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */