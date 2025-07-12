/*    */ package com.viraps.module;
/*    */ 
/*    */ import com.viraps.GemmaClient;
/*    */ import com.viraps.module.settings.Setting;
/*    */ import java.util.ArrayList;
/*    */ import net.fabricmc.api.EnvType;
/*    */ import net.fabricmc.api.Environment;
/*    */ import net.minecraft.class_2596;
/*    */ import net.minecraft.class_310;
/*    */ import net.minecraft.class_4587;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ @Environment(EnvType.CLIENT)
/*    */ public abstract class Module {
/*    */   private final String name;
/*    */   public boolean enabled;
/* 17 */   public static ArrayList<Module> modules = new ArrayList<>();
/* 18 */   private final ArrayList<Setting> settings = new ArrayList<>();
/* 19 */   private static class_310 client = class_310.method_1551();
/*    */   
/*    */   public Module(String name) {
/* 22 */     this.name = name;
/* 23 */     this.enabled = false;
/* 24 */     modules.add(this);
/*    */   }
/*    */   
/*    */   public String getName() {
/* 28 */     return this.name;
/*    */   }
/*    */ 
/*    */   
/*    */   public abstract void onEnable();
/*    */ 
/*    */   
/*    */   public boolean isEnabled() {
/* 36 */     return this.enabled;
/*    */   }
/*    */ 
/*    */   
/*    */   public abstract void onDisable();
/*    */   
/*    */   public abstract void onUpdate();
/*    */   
/*    */   public void onPacket(class_2596<?> packet, CallbackInfo ci) {}
/*    */   
/*    */   public void onRender(class_4587 matrixStack, CallbackInfo ci, float tickDelta) {}
/*    */   
/*    */   public void setEnabled(boolean enabled) {
/* 49 */     this.enabled = enabled;
/*    */   }
/*    */ 
/*    */   
/*    */   public void toggle() {
/* 54 */     if (this.enabled) {
/* 55 */       if (client.field_1724 != null) {
/* 56 */         GemmaClient.sendMessage("Disabled " + getName());
/*    */       }
/* 58 */       onDisable();
/* 59 */       this.enabled = false;
/*    */     } else {
/* 61 */       if (client.field_1724 != null) {
/* 62 */         GemmaClient.sendMessage("Enabled " + getName());
/*    */       }
/* 64 */       onEnable();
/* 65 */       this.enabled = true;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void addSetting(Setting setting) {
/* 71 */     this.settings.add(setting);
/*    */   }
/*    */   
/*    */   public ArrayList<Setting> getSettings() {
/* 75 */     return this.settings;
/*    */   }
/*    */ }


/* Location:              C:\Users\SpigotRCE\Downloads\gemma-1.0.0 (5).jar!\com\viraps\module\Module.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */