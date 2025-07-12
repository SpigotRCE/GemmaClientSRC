/*    */ package com.viraps;
/*    */ import com.viraps.command.Command;
/*    */ import com.viraps.command.CommandManager;
/*    */ import com.viraps.gui.ClickGuiScreen;
/*    */ import com.viraps.module.Category;
/*    */ import com.viraps.module.Module;
/*    */ import com.viraps.module.exploit.LokyCrasher;
/*    */ import net.fabricmc.api.ClientModInitializer;
/*    */ import net.fabricmc.api.EnvType;
/*    */ import net.minecraft.class_2561;
/*    */ import net.minecraft.class_310;
/*    */ 
/*    */ @Environment(EnvType.CLIENT)
/*    */ public class GemmaClient implements ClientModInitializer {
/* 15 */   public static ClickGuiScreen clickGuiScreen = new ClickGuiScreen();
/* 16 */   private static String prefix = "&0[&dGemmaClient&0]&8: &f";
/*    */ 
/*    */   
/*    */   public void onInitializeClient() {
/* 20 */     registerModules();
/* 21 */     regCommands();
/*    */   }
/*    */ 
/*    */   
/*    */   private void registerModules() {
/* 26 */     Category exploit = new Category("Exploit");
/* 27 */     Category combat = new Category("Combat");
/* 28 */     Category misc = new Category("Misc");
/* 29 */     Category movement = new Category("Movement");
/*    */ 
/*    */     
/* 32 */     exploit.addModule((Module)new SahurCrasher());
/* 33 */     exploit.addModule((Module)new MagicCrasher());
/* 34 */     exploit.addModule((Module)new UniverseCrasher());
/* 35 */     exploit.addModule((Module)new LokyCrasher());
/*    */ 
/*    */ 
/*    */     
/* 39 */     clickGuiScreen.addCategory(exploit);
/* 40 */     clickGuiScreen.addCategory(combat);
/* 41 */     clickGuiScreen.addCategory(movement);
/* 42 */     clickGuiScreen.addCategory(misc);
/*    */   }
/*    */   
/*    */   private void regCommands() {
/* 46 */     CommandManager.register("help", (Command)new HelpCommand());
/* 47 */     CommandManager.register("fakegm", (Command)new FakeGmCommand());
/*    */   }
/*    */ 
/*    */   
/*    */   public static void sendMessage(String string) {
/* 52 */     string = prefix + prefix;
/* 53 */     (class_310.method_1551()).field_1724.method_43496((class_2561)class_2561.method_43470(string.replace("&", "§")));
/*    */   }
/*    */ }


/* Location:              C:\Users\SpigotRCE\Downloads\gemma-1.0.0 (5).jar!\com\viraps\GemmaClient.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */