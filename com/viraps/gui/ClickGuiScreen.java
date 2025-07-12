/*     */ package com.viraps.gui;
/*     */ import com.viraps.module.Category;
/*     */ import com.viraps.module.Module;
/*     */ import com.viraps.module.settings.ModuleSettingsScreen;
/*     */ import java.awt.Color;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Objects;
/*     */ import net.fabricmc.api.EnvType;
/*     */ import net.minecraft.class_310;
/*     */ import net.minecraft.class_332;
/*     */ import net.minecraft.class_437;
/*     */ 
/*     */ @Environment(EnvType.CLIENT)
/*     */ public class ClickGuiScreen extends class_437 {
/*  16 */   private final class_310 client = class_310.method_1551();
/*  17 */   public static ArrayList<Category> categories = new ArrayList<>();
/*  18 */   private final HashMap<Category, int[]> positions = (HashMap)new HashMap<>();
/*  19 */   private final HashMap<Category, Boolean> expandedStates = new HashMap<>();
/*  20 */   private final HashMap<Category, Float> expansionProgress = new HashMap<>();
/*  21 */   private final int width = 100;
/*  22 */   private final int height = 20;
/*     */   
/*  24 */   private Category draggingCategory = null; private int dragX;
/*     */   private int dragY;
/*     */   
/*     */   public ClickGuiScreen() {
/*  28 */     super(class_2561.method_30163("Click gui"));
/*     */   }
/*     */ 
/*     */   
/*     */   public void method_25394(class_332 context, int mouseX, int mouseY, float delta) {
/*  33 */     for (Category category : categories) {
/*  34 */       int[] pos = this.positions.getOrDefault(category, new int[] { 5, 10 });
/*  35 */       renderCategory(context, category, pos[0], pos[1], mouseX, mouseY, delta);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void renderCategory(class_332 context, Category category, int x, int y, int mouseX, int mouseY, float delta) {
/*  40 */     int textWidth = this.client.field_1772.method_1727(category.getName());
/*  41 */     Objects.requireNonNull(this.client.field_1772); int textHeight = 9;
/*     */     
/*  43 */     context.method_25294(x, y, x + 100, y + 20, (new Color(128, 109, 158, 220)).getRGB());
/*     */     
/*  45 */     context.method_25303(this.client.field_1772, category.getName(), x + (100 - textWidth) / 2, y + (20 - textHeight) / 2, Color.WHITE
/*  46 */         .getRGB());
/*     */     
/*  48 */     if (((Boolean)this.expandedStates.getOrDefault(category, Boolean.valueOf(false))).booleanValue()) {
/*  49 */       float expansion = ((Float)this.expansionProgress.getOrDefault(category, Float.valueOf(0.0F))).floatValue();
/*  50 */       expansion = Math.min(expansion + delta * 0.05F * 6.0F, 1.0F);
/*     */       
/*  52 */       this.expansionProgress.put(category, Float.valueOf(expansion));
/*  53 */       renderModules(context, category, x, y + 20, mouseX, mouseY, expansion);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void renderModules(class_332 context, Category category, int x, int y, int mouseX, int mouseY, float expansion) {
/*  58 */     int moduleY = y;
/*  59 */     int expandedHeight = (int)((category.getModules().size() * 20) * expansion);
/*  60 */     for (Module module : category.getModules()) {
/*  61 */       String moduleName = module.getName();
/*  62 */       int textWidth = this.client.field_1772.method_1727(moduleName);
/*  63 */       Objects.requireNonNull(this.client.field_1772); int textHeight = 9;
/*     */       
/*  65 */       boolean isHovered = isHovered(mouseX, mouseY, x, moduleY, 100, 20);
/*  66 */       boolean enabled = module.isEnabled();
/*  67 */       Color moduleColor = enabled ? new Color(100, 100, 100) : new Color(150, 150, 150, 100);
/*     */       
/*  69 */       if (isHovered) {
/*  70 */         moduleColor = moduleColor.darker();
/*     */       }
/*     */       
/*  73 */       context.method_25294(x, moduleY, x + 100, moduleY + 20, moduleColor.getRGB());
/*  74 */       context.method_25303(this.client.field_1772, moduleName, x + (100 - textWidth) / 2, moduleY + (20 - textHeight) / 2, Color.WHITE
/*  75 */           .getRGB());
/*  76 */       moduleY += 20;
/*  77 */       if (moduleY > y + expandedHeight) {
/*     */         break;
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean method_25402(double mouseX, double mouseY, int button) {
/*  85 */     for (Category category : categories) {
/*  86 */       int[] pos = this.positions.getOrDefault(category, new int[] { 10, 10 });
/*     */       
/*  88 */       if (isHovered((int)mouseX, (int)mouseY, pos[0], pos[1], 100, 20)) {
/*  89 */         if (button == 0) {
/*  90 */           this.draggingCategory = category;
/*  91 */           this.dragX = (int)mouseX - pos[0];
/*  92 */           this.dragY = (int)mouseY - pos[1];
/*  93 */           return true;
/*  94 */         }  if (button == 1) {
/*  95 */           boolean expanded = ((Boolean)this.expandedStates.getOrDefault(category, Boolean.valueOf(false))).booleanValue();
/*  96 */           this.expandedStates.put(category, Boolean.valueOf(!expanded));
/*  97 */           if (!expanded) {
/*  98 */             this.expansionProgress.put(category, Float.valueOf(0.0F));
/*     */           }
/* 100 */           return true;
/*     */         } 
/*     */       } 
/*     */       
/* 104 */       if (((Boolean)this.expandedStates.getOrDefault(category, Boolean.valueOf(false))).booleanValue()) {
/* 105 */         int moduleY = pos[1] + 20;
/*     */         
/* 107 */         for (Module module : category.getModules()) {
/* 108 */           if (isHovered((int)mouseX, (int)mouseY, pos[0], moduleY, 100, 20)) {
/* 109 */             if (button == 0) {
/* 110 */               module.toggle();
/* 111 */             } else if (button == 1) {
/* 112 */               this.client.execute(() -> this.client.method_1507((class_437)new ModuleSettingsScreen(module)));
/*     */             } 
/* 114 */             return true;
/*     */           } 
/* 116 */           moduleY += 20;
/*     */         } 
/*     */       } 
/*     */     } 
/* 120 */     return super.method_25402(mouseX, mouseY, button);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean method_25406(double mouseX, double mouseY, int button) {
/* 125 */     if (button == 0) {
/* 126 */       this.draggingCategory = null;
/*     */     }
/* 128 */     return super.method_25406(mouseX, mouseY, button);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean method_25403(double mouseX, double mouseY, int button, double deltaX, double deltaY) {
/* 133 */     if (this.draggingCategory != null && button == 0) {
/* 134 */       this.positions.put(this.draggingCategory, new int[] { (int)mouseX - this.dragX, (int)mouseY - this.dragY });
/*     */     }
/* 136 */     return super.method_25403(mouseX, mouseY, button, deltaX, deltaY);
/*     */   }
/*     */   
/*     */   private boolean isHovered(int mouseX, int mouseY, int x, int y, int width, int height) {
/* 140 */     return (mouseX > x && mouseX < x + width && mouseY > y && mouseY < y + height);
/*     */   }
/*     */   
/*     */   public void addCategory(Category category) {
/* 144 */     categories.add(category);
/* 145 */     this.positions.putIfAbsent(category, new int[] { -30 + categories.size() * 110, 10 });
/* 146 */     this.expandedStates.putIfAbsent(category, Boolean.valueOf(false));
/* 147 */     this.expansionProgress.putIfAbsent(category, Float.valueOf(0.0F));
/*     */   }
/*     */ 
/*     */   
/*     */   public void method_25419() {
/* 152 */     super.method_25419();
/*     */   }
/*     */ }


/* Location:              C:\Users\SpigotRCE\Downloads\gemma-1.0.0 (5).jar!\com\viraps\gui\ClickGuiScreen.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */