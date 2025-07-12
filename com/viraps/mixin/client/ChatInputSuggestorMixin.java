/*    */ package com.viraps.mixin.client;
/*    */ 
/*    */ import com.mojang.brigadier.ParseResults;
/*    */ import com.mojang.brigadier.suggestion.Suggestions;
/*    */ import com.mojang.brigadier.suggestion.SuggestionsBuilder;
/*    */ import com.viraps.command.Command;
/*    */ import com.viraps.command.CommandManager;
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ import java.util.concurrent.CompletableFuture;
/*    */ import net.fabricmc.api.EnvType;
/*    */ import net.fabricmc.api.Environment;
/*    */ import net.minecraft.class_2172;
/*    */ import net.minecraft.class_2561;
/*    */ import net.minecraft.class_342;
/*    */ import net.minecraft.class_4717;
/*    */ import net.minecraft.class_5481;
/*    */ import org.jetbrains.annotations.Nullable;
/*    */ import org.spongepowered.asm.mixin.Mixin;
/*    */ import org.spongepowered.asm.mixin.Shadow;
/*    */ import org.spongepowered.asm.mixin.injection.At;
/*    */ import org.spongepowered.asm.mixin.injection.Inject;
/*    */ import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
/*    */ 
/*    */ @Environment(EnvType.CLIENT)
/*    */ @Mixin({class_4717.class})
/*    */ public abstract class ChatInputSuggestorMixin
/*    */ {
/*    */   @Shadow
/*    */   private class_342 field_21599;
/*    */   @Shadow
/*    */   @Nullable
/*    */   private ParseResults<class_2172> field_21610;
/*    */   @Shadow
/*    */   private CompletableFuture<Suggestions> field_21611;
/*    */   @Shadow
/*    */   private List<class_5481> field_21607;
/*    */   
/*    */   @Shadow
/*    */   public abstract void method_23920(boolean paramBoolean);
/*    */   
/*    */   @Inject(at = {@At(value = "INVOKE", target = "Lnet/minecraft/client/gui/widget/TextFieldWidget;getCursor()I", ordinal = 0)}, method = {"refresh()V"}, cancellable = true)
/*    */   private void onRefresh(CallbackInfo ci) {
/* 44 */     String prefix = ".";
/* 45 */     String string = this.field_21599.method_1882();
/*    */     
/* 47 */     if (string.length() > 0) {
/* 48 */       int cursorPos = this.field_21599.method_1881();
/* 49 */       String string2 = string.substring(0, cursorPos);
/*    */       
/* 51 */       if (string2.startsWith(prefix)) {
/* 52 */         SuggestionsBuilder builder = new SuggestionsBuilder(string2, prefix.length());
/*    */         
/* 54 */         if (string2.equals(prefix)) {
/* 55 */           for (String str : CommandManager.commands.keySet()) {
/* 56 */             builder.suggest(str + " ");
/*    */           }
/*    */         } else {
/*    */           
/* 60 */           List<String> separated = Arrays.asList(string2.split(" "));
/* 61 */           int wordCount = separated.size();
/*    */           
/* 63 */           if (wordCount == 1) {
/* 64 */             for (String str : CommandManager.commands.keySet()) {
/* 65 */               if (str.startsWith(((String)separated.get(0)).substring(1))) {
/* 66 */                 builder.suggest(str + " ");
/*    */               }
/*    */             } 
/*    */           } else {
/* 70 */             String commandName = ((String)separated.get(0)).substring(1).toLowerCase();
/* 71 */             Command command = (Command)CommandManager.commands.get(commandName);
/*    */             
/* 73 */             if (command != null) {
/* 74 */               builder.suggest(command.getUsage());
/*    */             } else {
/* 76 */               this.field_21607.add(class_2561.method_30163("GemmaClient:§4 No commands found with name: " + commandName).method_30937());
/*    */             } 
/*    */           } 
/*    */         } 
/*    */ 
/*    */         
/* 82 */         this.field_21611 = builder.buildFuture();
/* 83 */         method_23920(false);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\SpigotRCE\Downloads\gemma-1.0.0 (5).jar!\com\viraps\mixin\client\ChatInputSuggestorMixin.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */