/*     */ package com.viraps.module.settings;
/*     */ import com.viraps.module.Module;
/*     */ import java.awt.Color;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Objects;
/*     */ import net.fabricmc.api.EnvType;
/*     */ import net.fabricmc.api.Environment;
/*     */ import net.minecraft.class_2561;
/*     */ import net.minecraft.class_310;
/*     */ import net.minecraft.class_332;
/*     */ import net.minecraft.class_437;
/*     */ 
/*     */ @Environment(EnvType.CLIENT)
/*     */ public class ModuleSettingsScreen extends class_437 {
/*  15 */   private final class_310 client = class_310.method_1551(); private final Module module;
/*     */   private final ArrayList<Setting> settings;
/*     */   private boolean expanded = true;
/*     */   private boolean dragging = false;
/*     */   private boolean sliderDragging = false;
/*     */   private int dragX;
/*     */   private int dragY;
/*  22 */   private int x = 50; private int y = 50;
/*  23 */   private final int width = 180, height = 25;
/*  24 */   private final int settingHeight = 20;
/*  25 */   private SliderSetting currentDraggedSlider = null;
/*  26 */   private int sliderDragOffset = 0;
/*     */   
/*     */   public ModuleSettingsScreen(Module module) {
/*  29 */     super(class_2561.method_30163(module.getName() + " settings"));
/*  30 */     this.module = module;
/*  31 */     this.settings = module.getSettings();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void method_25394(class_332 context, int mouseX, int mouseY, float delta) {
/*  40 */     context.method_25294(this.x, this.y, this.x + 180, this.y + 25, (new Color(30, 30, 35)).getRGB());
/*  41 */     context.method_49601(this.x, this.y, 180, 25, (new Color(60, 60, 70)).getRGB());
/*  42 */     context.method_25303(this.client.field_1772, this.module.getName() + " settings", this.x + 5, this.y + 7, Color.WHITE.getRGB());
/*  43 */     context.method_25303(this.client.field_1772, this.expanded ? "▲" : "▼", this.x + 180 - 15, this.y + 7, Color.GRAY.getRGB());
/*     */     
/*  45 */     if (this.expanded) {
/*  46 */       int settingY = this.y + 25;
/*  47 */       for (Setting setting : this.settings) {
/*     */         
/*  49 */         context.method_25294(this.x, settingY, this.x + 180, settingY + 20, (new Color(40, 40, 45)).getRGB());
/*  50 */         context.method_49601(this.x, settingY, 180, 20, (new Color(60, 60, 70)).getRGB());
/*     */ 
/*     */         
/*  53 */         context.method_25303(this.client.field_1772, setting.getName(), this.x + 5, settingY + 6, Color.WHITE.getRGB());
/*     */         
/*  55 */         if (setting instanceof BooleanSetting) { BooleanSetting booleanSetting = (BooleanSetting)setting;
/*  56 */           renderBoolean(context, booleanSetting, this.x, settingY, mouseX, mouseY); }
/*  57 */         else if (setting instanceof SliderSetting) { SliderSetting sliderSetting = (SliderSetting)setting;
/*  58 */           renderSlider(context, sliderSetting, this.x, settingY, mouseX, mouseY); }
/*  59 */         else if (setting instanceof ChoiceSetting) { ChoiceSetting choiceSetting = (ChoiceSetting)setting;
/*  60 */           renderChoice(context, choiceSetting, this.x, settingY, mouseX, mouseY); }
/*     */ 
/*     */         
/*  63 */         settingY += 20;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void renderBoolean(class_332 context, BooleanSetting setting, int x, int y, int mouseX, int mouseY) {
/*  69 */     boolean hovered = isHovered(mouseX, mouseY, x, y, 180, 20);
/*  70 */     Color bgColor = setting.getValue() ? new Color(80, 200, 120) : new Color(80, 80, 80);
/*  71 */     if (hovered) bgColor = bgColor.brighter();
/*     */     
/*  73 */     int toggleWidth = 30;
/*  74 */     int toggleX = x + 180 - toggleWidth - 5;
/*  75 */     int toggleY = y + 4;
/*     */ 
/*     */     
/*  78 */     context.method_25294(toggleX, toggleY, toggleX + toggleWidth, toggleY + 12, bgColor.getRGB());
/*  79 */     context.method_49601(toggleX, toggleY, toggleWidth, 12, (new Color(0, 0, 0, 150)).getRGB());
/*     */ 
/*     */     
/*  82 */     context.method_25303(this.client.field_1772, setting.getValue() ? "ON" : "OFF", toggleX + toggleWidth / 2 - this.client.field_1772
/*  83 */         .method_1727(setting.getValue() ? "ON" : "OFF") / 2, toggleY + 2, Color.WHITE
/*  84 */         .getRGB());
/*     */   }
/*     */   
/*     */   private void renderSlider(class_332 context, SliderSetting setting, int x, int y, int mouseX, int mouseY) {
/*  88 */     int sliderWidth = 80;
/*  89 */     int sliderX = x + 180 - sliderWidth - 5;
/*  90 */     int sliderY = y + 4;
/*     */     
/*  92 */     float percent = (setting.getValue() - setting.getMin()) / (setting.getMax() - setting.getMin());
/*  93 */     int filledWidth = (int)(percent * sliderWidth);
/*     */     
/*  95 */     boolean hovered = isHovered(mouseX, mouseY, sliderX, sliderY, sliderWidth, 12);
/*     */ 
/*     */     
/*  98 */     context.method_25294(sliderX, sliderY, sliderX + sliderWidth, sliderY + 12, (new Color(60, 60, 70)).getRGB());
/*     */     
/* 100 */     context.method_25294(sliderX, sliderY, sliderX + filledWidth, sliderY + 12, hovered ? -16733441 : -16738596);
/*     */ 
/*     */     
/* 103 */     context.method_49601(sliderX, sliderY, sliderWidth, 12, (new Color(0, 0, 0, 150)).getRGB());
/*     */ 
/*     */     
/* 106 */     String valueText = String.format("%.2f", new Object[] { Float.valueOf(setting.getValue()) });
/* 107 */     context.method_25303(this.client.field_1772, valueText, sliderX + sliderWidth / 2 - this.client.field_1772
/* 108 */         .method_1727(valueText) / 2, sliderY + 2, Color.WHITE
/* 109 */         .getRGB());
/*     */   }
/*     */   
/*     */   private void renderChoice(class_332 context, ChoiceSetting setting, int x, int y, int mouseX, int mouseY) {
/* 113 */     boolean hovered = isHovered(mouseX, mouseY, x, y, 180, 20);
/* 114 */     Color bgColor = hovered ? new Color(70, 70, 80) : new Color(60, 60, 70);
/*     */     
/* 116 */     int choiceWidth = 80;
/* 117 */     int choiceX = x + 180 - choiceWidth - 5;
/* 118 */     int choiceY = y + 4;
/*     */ 
/*     */     
/* 121 */     context.method_25294(choiceX, choiceY, choiceX + choiceWidth, choiceY + 12, bgColor.getRGB());
/* 122 */     context.method_49601(choiceX, choiceY, choiceWidth, 12, (new Color(0, 0, 0, 150)).getRGB());
/*     */ 
/*     */     
/* 125 */     String selected = setting.getSelectedOption();
/* 126 */     context.method_25303(this.client.field_1772, selected, choiceX + choiceWidth / 2 - this.client.field_1772
/* 127 */         .method_1727(selected) / 2, choiceY + 2, Color.WHITE
/* 128 */         .getRGB());
/*     */ 
/*     */     
/* 131 */     context.method_25303(this.client.field_1772, "▼", choiceX + choiceWidth - 10, choiceY + 2, Color.LIGHT_GRAY.getRGB());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean method_25402(double mouseX, double mouseY, int button) {
/* 136 */     if (isHovered((int)mouseX, (int)mouseY, this.x, this.y, 180, 25)) {
/* 137 */       if (button == 0) {
/* 138 */         this.dragging = true;
/* 139 */         this.dragX = (int)mouseX - this.x;
/* 140 */         this.dragY = (int)mouseY - this.y;
/* 141 */         return true;
/* 142 */       }  if (button == 1) {
/* 143 */         this.expanded = !this.expanded;
/* 144 */         return true;
/*     */       } 
/*     */     } 
/*     */     
/* 148 */     if (this.expanded) {
/* 149 */       int settingY = this.y + 25;
/* 150 */       for (Setting setting : this.settings) {
/* 151 */         if (isHovered((int)mouseX, (int)mouseY, this.x, settingY, 180, 20)) {
/* 152 */           if (setting instanceof BooleanSetting) { BooleanSetting booleanSetting = (BooleanSetting)setting; if (button == 0)
/* 153 */             { booleanSetting.toggle();
/* 154 */               return true; }  }
/* 155 */            if (setting instanceof SliderSetting) { SliderSetting sliderSetting = (SliderSetting)setting; if (button == 0)
/* 156 */             { int sliderWidth = 80;
/* 157 */               int sliderX = this.x + 180 - sliderWidth - 5;
/* 158 */               this.sliderDragging = true;
/* 159 */               this.currentDraggedSlider = sliderSetting;
/*     */               
/* 161 */               this.sliderDragOffset = (int)mouseX - sliderX;
/* 162 */               updateSliderValue(sliderSetting, (int)mouseX, sliderX);
/* 163 */               return true; }  }
/* 164 */            if (setting instanceof ChoiceSetting) { ChoiceSetting choiceSetting = (ChoiceSetting)setting; if (button == 0) {
/* 165 */               choiceSetting.cycle();
/* 166 */               return true;
/*     */             }  }
/*     */         
/* 169 */         }  settingY += 20;
/*     */       } 
/*     */     } 
/*     */     
/* 173 */     return super.method_25402(mouseX, mouseY, button);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean method_25403(double mouseX, double mouseY, int button, double deltaX, double deltaY) {
/* 178 */     if (this.dragging && button == 0) {
/* 179 */       this.x = (int)mouseX - this.dragX;
/* 180 */       this.y = (int)mouseY - this.dragY;
/* 181 */       return true;
/*     */     } 
/*     */     
/* 184 */     if (this.sliderDragging && this.currentDraggedSlider != null && button == 0) {
/* 185 */       int sliderWidth = 80;
/* 186 */       int sliderX = this.x + 180 - sliderWidth - 5;
/* 187 */       updateSliderValue(this.currentDraggedSlider, (int)mouseX, sliderX);
/* 188 */       return true;
/*     */     } 
/*     */     
/* 191 */     return super.method_25403(mouseX, mouseY, button, deltaX, deltaY);
/*     */   }
/*     */   
/*     */   private void updateSliderValue(SliderSetting setting, int mouseX, int sliderX) {
/* 195 */     int sliderWidth = 80;
/*     */     
/* 197 */     int mouseXAdjusted = mouseX - sliderX;
/* 198 */     mouseXAdjusted = Math.max(0, Math.min(sliderWidth, mouseXAdjusted));
/* 199 */     float percentDrag = mouseXAdjusted / sliderWidth;
/* 200 */     float value = setting.getMin() + percentDrag * (setting.getMax() - setting.getMin());
/* 201 */     setting.setValue((float)(Math.round(value * 100.0D) / 100.0D));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean method_25406(double mouseX, double mouseY, int button) {
/* 206 */     if (button == 0) {
/* 207 */       this.sliderDragging = false;
/* 208 */       this.currentDraggedSlider = null;
/* 209 */       this.dragging = false;
/*     */     } 
/* 211 */     return super.method_25406(mouseX, mouseY, button);
/*     */   }
/*     */   
/*     */   private boolean isHovered(int mouseX, int mouseY, int x, int y, int width, int height) {
/* 215 */     return (mouseX > x && mouseX < x + width && mouseY > y && mouseY < y + height);
/*     */   }
/*     */ 
/*     */   
/*     */   public void method_25419() {
/* 220 */     this.client.method_1507((class_437)new ClickGuiScreen());
/* 221 */     super.method_25419();
/*     */   }
/*     */ 
/*     */   
/*     */   private void renderBackground(class_332 context) {
/* 226 */     Objects.requireNonNull(this); Objects.requireNonNull(this); context.method_25294(0, 0, 180, 25, (new Color(0, 0, 0, 150)).getRGB());
/*     */   }
/*     */ }


/* Location:              C:\Users\SpigotRCE\Downloads\gemma-1.0.0 (5).jar!\com\viraps\module\settings\ModuleSettingsScreen.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */