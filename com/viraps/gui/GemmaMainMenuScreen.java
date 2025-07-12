/*    */ package com.viraps.gui;
/*    */ import com.viraps.utils.FontUtil;
/*    */ import java.awt.Color;
/*    */ import net.fabricmc.api.EnvType;
/*    */ import net.fabricmc.api.Environment;
/*    */ import net.minecraft.class_2561;
/*    */ import net.minecraft.class_2960;
/*    */ import net.minecraft.class_310;
/*    */ import net.minecraft.class_332;
/*    */ import net.minecraft.class_364;
/*    */ import net.minecraft.class_4185;
/*    */ import net.minecraft.class_426;
/*    */ import net.minecraft.class_437;
/*    */ import net.minecraft.class_500;
/*    */ import net.minecraft.class_526;
/*    */ 
/*    */ @Environment(EnvType.CLIENT)
/*    */ public class GemmaMainMenuScreen extends class_437 {
/* 19 */   private static final class_2960 BACKGROUND_TEXTURE = new class_2960("gemma", "7.png");
/*    */ 
/*    */   
/*    */   public GemmaMainMenuScreen() {
/* 23 */     super((class_2561)class_2561.method_43470("Gemma Main Menu"));
/*    */   }
/*    */ 
/*    */   
/*    */   protected void method_25426() {
/* 28 */     int yStart = this.field_22790 / 4;
/* 29 */     int buttonHeight = 20;
/* 30 */     int spacing = 5;
/*    */     
/* 32 */     int fullSpacing = buttonHeight + spacing;
/*    */     
/* 34 */     method_37063((class_364)class_4185.method_46430((class_2561)class_2561.method_43470("Singleplayer"), b -> openSingleplayer())
/* 35 */         .method_46433(20, yStart)
/* 36 */         .method_46437(120, buttonHeight)
/* 37 */         .method_46431());
/*    */     
/* 39 */     method_37063((class_364)class_4185.method_46430((class_2561)class_2561.method_43470("Multiplayer"), b -> openMultiplayer())
/* 40 */         .method_46433(20, yStart + fullSpacing)
/* 41 */         .method_46437(120, buttonHeight)
/* 42 */         .method_46431());
/*    */     
/* 44 */     method_37063((class_364)class_4185.method_46430((class_2561)class_2561.method_43470("Options"), b -> openOptions())
/* 45 */         .method_46433(20, yStart + fullSpacing * 2)
/* 46 */         .method_46437(120, buttonHeight)
/* 47 */         .method_46431());
/*    */     
/* 49 */     method_37063((class_364)class_4185.method_46430((class_2561)class_2561.method_43470("Language"), b -> openLanguage())
/* 50 */         .method_46433(20, yStart + fullSpacing * 3)
/* 51 */         .method_46437(120, buttonHeight)
/* 52 */         .method_46431());
/*    */     
/* 54 */     method_37063((class_364)class_4185.method_46430((class_2561)class_2561.method_43470("Quit"), b -> class_310.method_1551().method_1592())
/* 55 */         .method_46433(20, yStart + fullSpacing * 4)
/* 56 */         .method_46437(120, buttonHeight)
/* 57 */         .method_46431());
/*    */   }
/*    */ 
/*    */   
/*    */   public void method_25394(class_332 context, int mouseX, int mouseY, float delta) {
/* 62 */     super.method_25394(context, mouseX, mouseY, delta);
/* 63 */     context.method_25290(BACKGROUND_TEXTURE, 0, 0, 0.0F, 0.0F, this.field_22789, this.field_22790, this.field_22789, this.field_22790);
/* 64 */     context.method_25296(10, 0, 15, this.field_22790, -10724097, -13816454);
/* 65 */     String title = "GEMMA";
/*    */     
/* 67 */     float scale = 3.0F;
/*    */     
/* 69 */     context.method_51448().method_22903();
/* 70 */     context.method_51448().method_22905(scale, scale, 1.0F);
/*    */     
/* 72 */     int x = (int)((this.field_22789 / 2.0F - FontUtil.getStringWidth(title) / 2.0F) / scale);
/* 73 */     int y = (int)((this.field_22790 / 2.0F - 120.0F) / scale);
/*    */     
/* 75 */     FontUtil.drawTextWithFont(context, title, x, y, Color.WHITE, false);
/* 76 */     context.method_51448().method_22909();
/*    */   }
/*    */   
/*    */   private void openSingleplayer() {
/* 80 */     class_310.method_1551().method_1507((class_437)new class_526(this));
/*    */   }
/*    */   
/*    */   private void openMultiplayer() {
/* 84 */     class_310.method_1551().method_1507((class_437)new class_500(this));
/*    */   }
/*    */ 
/*    */   
/*    */   private void openOptions() {
/* 89 */     class_310 client = class_310.method_1551();
/* 90 */     client.method_1507((class_437)new class_429(this, client.field_1690));
/*    */   }
/*    */   
/*    */   private void openLanguage() {
/* 94 */     class_310 client = class_310.method_1551();
/* 95 */     client.method_1507((class_437)new class_426(this, client.field_1690, client.method_1526()));
/*    */   }
/*    */ }


/* Location:              C:\Users\SpigotRCE\Downloads\gemma-1.0.0 (5).jar!\com\viraps\gui\GemmaMainMenuScreen.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */