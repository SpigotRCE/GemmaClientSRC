/*    */ package com.viraps.module.settings;
/*    */ import net.fabricmc.api.EnvType;
/*    */ 
/*    */ @Environment(EnvType.CLIENT)
/*    */ public class SliderSetting extends Setting {
/*    */   public SliderSetting(String name, float defaultValue, float min, float max) {
/*  7 */     super(name);
/*  8 */     this.value = defaultValue;
/*  9 */     this.min = min;
/* 10 */     this.max = max;
/*    */   }
/*    */   private float value; private float min;
/*    */   private float max;
/*    */   
/*    */   public float getValue() {
/* 16 */     return this.value;
/*    */   }
/*    */   
/*    */   public void setValue(float value) {
/* 20 */     this.value = Math.max(this.min, Math.min(this.max, value));
/*    */   }
/*    */   
/*    */   public float getMin() {
/* 24 */     return this.min;
/*    */   }
/*    */   
/*    */   public float getMax() {
/* 28 */     return this.max;
/*    */   }
/*    */ 
/*    */   
/*    */   public SettingType getType() {
/* 33 */     return SettingType.SLIDER;
/*    */   }
/*    */ }


/* Location:              C:\Users\SpigotRCE\Downloads\gemma-1.0.0 (5).jar!\com\viraps\module\settings\SliderSetting.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */