/*    */ package com.viraps.command.impl;
/*    */ import com.viraps.GemmaClient;
/*    */ import com.viraps.command.Command;
/*    */ import java.io.IOException;
/*    */ import net.fabricmc.api.EnvType;
/*    */ import net.fabricmc.api.Environment;
/*    */ import net.minecraft.class_1934;
/*    */ import net.minecraft.class_310;
/*    */ 
/*    */ @Environment(EnvType.CLIENT)
/*    */ public class FakeGmCommand implements Command {
/*    */   public void execute(String[] args) throws IOException {
/* 13 */     if (args.length < 1) {
/* 14 */       GemmaClient.sendMessage("Usage: .fakegm <survival/creative>");
/*    */       
/*    */       return;
/*    */     } 
/* 18 */     String mode = args[1].toLowerCase().trim();
/*    */     
/* 20 */     switch (mode) {
/*    */       case "survival":
/*    */       case "0":
/* 23 */         (class_310.method_1551()).field_1761.method_2907(class_1934.field_9215);
/* 24 */         GemmaClient.sendMessage("Game mode set to Survival.");
/*    */         return;
/*    */       case "creative":
/*    */       case "1":
/* 28 */         (class_310.method_1551()).field_1761.method_2907(class_1934.field_9220);
/* 29 */         GemmaClient.sendMessage("Game mode set to Creative.");
/*    */         return;
/*    */     } 
/* 32 */     GemmaClient.sendMessage("Usage: .fakegm <survival/creative>");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getUsage() {
/* 39 */     return ".fakegm <0 | 1>";
/*    */   }
/*    */ }


/* Location:              C:\Users\SpigotRCE\Downloads\gemma-1.0.0 (5).jar!\com\viraps\command\impl\FakeGmCommand.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */