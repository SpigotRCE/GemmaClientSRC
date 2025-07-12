/*    */ package com.viraps.module.settings;
/*    */ import java.util.List;
/*    */ import net.fabricmc.api.EnvType;
/*    */ 
/*    */ @Environment(EnvType.CLIENT)
/*    */ public class ChoiceSetting extends Setting {
/*    */   private final List<String> options;
/*    */   
/*    */   public ChoiceSetting(String name, List<String> options, int defaultIndex) {
/* 10 */     super(name);
/* 11 */     this.options = options;
/* 12 */     this.selectedIndex = defaultIndex;
/*    */   }
/*    */   private int selectedIndex;
/*    */   public List<String> getOptions() {
/* 16 */     return this.options;
/*    */   }
/*    */   
/*    */   public String getSelectedOption() {
/* 20 */     return this.options.get(this.selectedIndex);
/*    */   }
/*    */   
/*    */   public void cycle() {
/* 24 */     this.selectedIndex = (this.selectedIndex + 1) % this.options.size();
/*    */   }
/*    */   
/*    */   public int getSelectedIndex() {
/* 28 */     return this.selectedIndex;
/*    */   }
/*    */ 
/*    */   
/*    */   public SettingType getType() {
/* 33 */     return SettingType.MULTIPLE_CHOICE;
/*    */   }
/*    */ }


/* Location:              C:\Users\SpigotRCE\Downloads\gemma-1.0.0 (5).jar!\com\viraps\module\settings\ChoiceSetting.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */