/*    */ package com.viraps.mixin.client;
/*    */ import com.viraps.module.Module;
/*    */ import net.fabricmc.api.EnvType;
/*    */ import net.fabricmc.api.Environment;
/*    */ import net.minecraft.class_638;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ 
/*    */ @Environment(EnvType.CLIENT)
/*    */ @Mixin({class_638.class})
/*    */ public class ClientWorldTickMixin {
/*    */   @Inject(method = {"tick"}, at = {@At("HEAD")})
/*    */   private void onTick(CallbackInfo info) {
/* 15 */     for (Module module : Module.modules) {
/* 16 */       if (module.enabled == true)
/* 17 */         module.onUpdate(); 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\SpigotRCE\Downloads\gemma-1.0.0 (5).jar!\com\viraps\mixin\client\ClientWorldTickMixin.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */