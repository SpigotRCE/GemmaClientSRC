/*    */ package com.viraps.mixin.client;
/*    */ 
/*    */ import com.viraps.utils.FontUtil;
/*    */ import com.viraps.utils.TpsUtil;
/*    */ import java.awt.Color;
/*    */ import net.fabricmc.api.EnvType;
/*    */ import net.fabricmc.api.Environment;
/*    */ import net.minecraft.class_310;
/*    */ import net.minecraft.class_329;
/*    */ import net.minecraft.class_332;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Shadow;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ @Environment(EnvType.CLIENT)
/*    */ @Mixin({class_329.class})
/*    */ public class IngamehudMixin
/*    */ {
/*    */   @Shadow
/*    */   private int field_2023;
/* 23 */   Color purple = new Color(102, 0, 153);
/*    */   
/*    */   @Inject(at = {@At("HEAD")}, method = {"render"})
/*    */   public void onRender(class_332 context, float tickDelta, CallbackInfo ci) {
/* 27 */     int x = 10;
/* 28 */     int y = 10;
/* 29 */     int width = 90;
/* 30 */     int height = 100;
/* 31 */     int backroundColor = Integer.MIN_VALUE;
/*    */     
/* 33 */     context.method_25294(x, y, x + width, y + height, backroundColor);
/* 34 */     context.method_49601(x, y, width, height, -1);
/*    */ 
/*    */     
/* 37 */     FontUtil.drawTextWithFont(context, "Gemma", x + 22, y + 4, this.purple, true);
/* 38 */     FontUtil.drawTextWithFont(context, "FPS: " + class_310.method_1551().method_47599(), x + 8, y + 20, Color.WHITE, true);
/* 39 */     FontUtil.drawTextWithFont(context, "Brand: " + class_310.method_1551().method_1562().method_52790(), x + 8, y + 35, Color.WHITE, true);
/* 40 */     FontUtil.drawTextWithFont(context, "Tps: " + TpsUtil.INSTANCE.getTickRate(), x + 8, y + 50, Color.WHITE, true);
/* 41 */     FontUtil.drawTextWithFont(context, "Last packet: " + TpsUtil.INSTANCE.getTimeSinceLastTick(), x + 8, y + 65, Color.WHITE, true);
/*    */   }
/*    */ }


/* Location:              C:\Users\SpigotRCE\Downloads\gemma-1.0.0 (5).jar!\com\viraps\mixin\client\IngamehudMixin.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */