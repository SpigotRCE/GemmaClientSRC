/*    */ package com.viraps.module.settings;
/*    */ import net.fabricmc.api.EnvType;
/*    */ 
/*    */ @Environment(EnvType.CLIENT)
/*    */ public abstract class Setting {
/*    */   public Setting(String name) {
/*  7 */     this.name = name;
/*    */   }
/*    */   private final String name;
/*    */   public String getName() {
/* 11 */     return this.name;
/*    */   }
/*    */   
/*    */   public abstract SettingType getType();
/*    */ }


/* Location:              C:\Users\SpigotRCE\Downloads\gemma-1.0.0 (5).jar!\com\viraps\module\settings\Setting.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */