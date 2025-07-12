/*    */ package com.viraps.mixin.client;
/*    */ 
/*    */ import com.viraps.command.CommandManager;
/*    */ import com.viraps.utils.TpsUtil;
/*    */ import java.io.IOException;
/*    */ import net.fabricmc.api.EnvType;
/*    */ import net.fabricmc.api.Environment;
/*    */ import net.minecraft.class_2678;
/*    */ import net.minecraft.class_2761;
/*    */ import net.minecraft.class_634;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Environment(EnvType.CLIENT)
/*    */ @Mixin({class_634.class})
/*    */ public class ClientPlayNetworkHandlerMixin
/*    */ {
/*    */   @Inject(method = {"onGameJoin"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void onJoin(class_2678 packet, CallbackInfo ci) {
/* 30 */     TpsUtil.INSTANCE.onGameJoined();
/*    */   }
/*    */ 
/*    */   
/*    */   @Inject(method = {"onWorldTimeUpdate"}, at = {@At("HEAD")})
/*    */   private void onWorldTimeUpdate(class_2761 packet, CallbackInfo ci) {
/* 36 */     TpsUtil.INSTANCE.onReceivePacket(packet);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @Inject(method = {"sendChatMessage"}, at = {@At("HEAD")}, cancellable = true)
/*    */   private void handleMessage(String content, CallbackInfo ci) {
/* 45 */     if (content.startsWith(".")) {
/*    */       try {
/* 47 */         CommandManager.execute(content);
/* 48 */       } catch (IOException e) {
/* 49 */         throw new RuntimeException(e);
/*    */       } 
/* 51 */       ci.cancel();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\SpigotRCE\Downloads\gemma-1.0.0 (5).jar!\com\viraps\mixin\client\ClientPlayNetworkHandlerMixin.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */