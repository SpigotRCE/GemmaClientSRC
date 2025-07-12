/*    */ package com.viraps.utils;
/*    */ import net.fabricmc.api.EnvType;
/*    */ import net.minecraft.class_2960;
/*    */ import net.minecraft.class_310;
/*    */ import net.minecraft.class_332;
/*    */ 
/*    */ @Environment(EnvType.CLIENT)
/*    */ public class BackroundRenderer {
/*  9 */   private static final class_2960 BACKGROUND_TEXTURE = class_2960.method_43902("gemma", "bg.png");
/*    */   
/*    */   public static void render(class_332 context, int width, int height) {
/* 12 */     class_310 client = class_310.method_1551();
/* 13 */     context.method_25290(BACKGROUND_TEXTURE, 0, 0, 0.0F, 0.0F, width, height, width, height);
/*    */   }
/*    */ }


/* Location:              C:\Users\SpigotRCE\Downloads\gemma-1.0.0 (5).jar!\com\virap\\utils\BackroundRenderer.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */