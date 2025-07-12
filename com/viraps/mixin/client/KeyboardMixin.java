/*    */ package com.viraps.mixin.client;
/*    */ import com.viraps.GemmaClient;
/*    */ import net.fabricmc.api.EnvType;
/*    */ import net.fabricmc.api.Environment;
/*    */ import net.minecraft.class_304;
/*    */ import net.minecraft.class_310;
/*    */ import net.minecraft.class_3675;
/*    */ import net.minecraft.class_437;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ @Environment(EnvType.CLIENT)
/*    */ @Mixin({class_304.class})
/*    */ public class KeyboardMixin {
/*    */   @Inject(method = {"onKeyPressed"}, at = {@At("HEAD")})
/*    */   private static void onKey(class_3675.class_306 key, CallbackInfo ci) {
/* 19 */     int keyCode = key.method_1444();
/*    */ 
/*    */     
/* 22 */     if (keyCode == 344)
/* 23 */       class_310.method_1551().method_1507((class_437)GemmaClient.clickGuiScreen); 
/*    */   }
/*    */ }


/* Location:              C:\Users\SpigotRCE\Downloads\gemma-1.0.0 (5).jar!\com\viraps\mixin\client\KeyboardMixin.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */