/*    */ package com.viraps.utils;
/*    */ import java.awt.Color;
/*    */ import net.minecraft.class_2561;
/*    */ import net.minecraft.class_2583;
/*    */ import net.minecraft.class_2960;
/*    */ import net.minecraft.class_310;
/*    */ import net.minecraft.class_332;
/*    */ import net.minecraft.class_5250;
/*    */ 
/*    */ @Environment(EnvType.CLIENT)
/*    */ public class FontUtil {
/* 12 */   private static final class_310 minecraftClient = class_310.method_1551();
/* 13 */   private static final class_2960 customFont = class_2960.method_43902("gemma", "font");
/*    */   
/*    */   public static void drawTextWithFont(class_332 context, String text, int x, int y, Color color, boolean shadow) {
/* 16 */     class_5250 class_5250 = class_2561.method_43470(text).method_10862(class_2583.field_24360.method_27704(customFont));
/* 17 */     context.method_51439(minecraftClient.field_1772, (class_2561)class_5250, x, y, color.getRGB(), shadow);
/*    */   }
/*    */   
/*    */   public static int getStringWidth(String text) {
/* 21 */     return minecraftClient.field_1772.method_27525((class_5348)class_2561.method_43470(text).method_10862(class_2583.field_24360.method_27704(customFont)));
/*    */   }
/*    */ }


/* Location:              C:\Users\SpigotRCE\Downloads\gemma-1.0.0 (5).jar!\com\virap\\utils\FontUtil.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */