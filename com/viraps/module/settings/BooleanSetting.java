/*    */ package com.viraps.module.settings;
/*    */ import net.fabricmc.api.EnvType;
/*    */ 
/*    */ @Environment(EnvType.CLIENT)
/*    */ public class BooleanSetting extends Setting {
/*    */   public BooleanSetting(String name, boolean defaultValue) {
/*  7 */     super(name);
/*  8 */     this.value = defaultValue;
/*    */   }
/*    */   private boolean value;
/*    */   public boolean getValue() {
/* 12 */     return this.value;
/*    */   }
/*    */   
/*    */   public void setValue(boolean value) {
/* 16 */     this.value = value;
/*    */   }
/*    */   
/*    */   public void toggle() {
/* 20 */     this.value = !this.value;
/*    */   }
/*    */ 
/*    */   
/*    */   public SettingType getType() {
/* 25 */     return SettingType.BOOLEAN;
/*    */   }
/*    */ }


/* Location:              C:\Users\SpigotRCE\Downloads\gemma-1.0.0 (5).jar!\com\viraps\module\settings\BooleanSetting.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */