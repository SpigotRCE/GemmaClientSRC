/*    */ package com.viraps.utils;
/*    */ import java.util.Arrays;
/*    */ import net.fabricmc.api.EnvType;
/*    */ import net.fabricmc.api.Environment;
/*    */ import net.minecraft.class_2761;
/*    */ import net.minecraft.class_3532;
/*    */ 
/*    */ @Environment(EnvType.CLIENT)
/*    */ public class TpsUtil {
/* 10 */   public static TpsUtil INSTANCE = new TpsUtil();
/*    */   
/* 12 */   private final float[] tickRates = new float[20];
/* 13 */   private int nextIndex = 0;
/* 14 */   private long timeLastTimeUpdate = -1L;
/*    */   private long timeGameJoined;
/*    */   
/*    */   public void onReceivePacket(class_2761 packet) {
/* 18 */     long now = System.currentTimeMillis();
/* 19 */     float timeElapsed = (float)(now - this.timeLastTimeUpdate) / 1000.0F;
/* 20 */     this.tickRates[this.nextIndex] = class_3532.method_15363(20.0F / timeElapsed, 0.0F, 20.0F);
/* 21 */     this.nextIndex = (this.nextIndex + 1) % this.tickRates.length;
/* 22 */     this.timeLastTimeUpdate = now;
/*    */   }
/*    */   
/*    */   public void onGameJoined() {
/* 26 */     Arrays.fill(this.tickRates, 0.0F);
/* 27 */     this.nextIndex = 0;
/* 28 */     this.timeGameJoined = this.timeLastTimeUpdate = System.currentTimeMillis();
/*    */   }
/*    */   
/*    */   public String getTickRate() {
/* 32 */     long now = System.currentTimeMillis();
/*    */     
/* 34 */     if (now - this.timeGameJoined < 4000L) return "20";
/*    */     
/* 36 */     int numTicks = 0;
/* 37 */     float sumTickRates = 0.0F;
/* 38 */     for (float tickRate : this.tickRates) {
/* 39 */       if (tickRate > 0.0F) {
/* 40 */         sumTickRates += tickRate;
/* 41 */         numTicks++;
/*    */       } 
/*    */     } 
/*    */     
/* 45 */     int averageTickRate = (numTicks > 0) ? Math.round(sumTickRates / numTicks) : 20;
/*    */     
/* 47 */     int timeSinceLastTick = getTimeSinceLastTick();
/* 48 */     if (timeSinceLastTick > 4) {
/* 49 */       int penalty = timeSinceLastTick - 4;
/* 50 */       averageTickRate = Math.max(0, averageTickRate - penalty);
/*    */     } 
/*    */     
/* 53 */     return (averageTickRate == 0) ? "CRASHED" : String.valueOf(averageTickRate);
/*    */   }
/*    */   
/*    */   public int getTimeSinceLastTick() {
/* 57 */     long now = System.currentTimeMillis();
/* 58 */     if (now - this.timeGameJoined < 4000L) return 0; 
/* 59 */     return (int)((now - this.timeLastTimeUpdate) / 1000L);
/*    */   }
/*    */ }


/* Location:              C:\Users\SpigotRCE\Downloads\gemma-1.0.0 (5).jar!\com\virap\\utils\TpsUtil.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */