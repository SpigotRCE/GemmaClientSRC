/*    */ package com.viraps.mixin.client;
/*    */ import com.viraps.gui.GemmaMainMenuScreen;
/*    */ import net.fabricmc.api.EnvType;
/*    */ import net.fabricmc.api.Environment;
/*    */ import net.minecraft.class_437;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ @Environment(EnvType.CLIENT)
/*    */ @Mixin({class_442.class})
/*    */ public class TitleScreenMixin {
/*    */   @Inject(method = {"init"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void onInit(CallbackInfo ci) {
/* 15 */     class_310.method_1551().method_1507((class_437)new GemmaMainMenuScreen());
/* 16 */     ci.cancel();
/*    */   }
/*    */ }


/* Location:              C:\Users\SpigotRCE\Downloads\gemma-1.0.0 (5).jar!\com\viraps\mixin\client\TitleScreenMixin.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */