/*    */ package com.viraps.module;
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import net.fabricmc.api.EnvType;
/*    */ import net.fabricmc.api.Environment;
/*    */ 
/*    */ @Environment(EnvType.CLIENT)
/*    */ public class Category {
/*  9 */   private final ArrayList<Module> modules = new ArrayList<>(); private final String name;
/* 10 */   private final List<Category> subCategories = new ArrayList<>();
/*    */   private boolean expanded;
/*    */   
/*    */   public Category(String name) {
/* 14 */     this.name = name;
/* 15 */     this.expanded = false;
/*    */   }
/*    */   public List<Category> getSubCategories() {
/* 18 */     return this.subCategories;
/*    */   }
/*    */   
/*    */   public void addSubCategory(Category subCategory) {
/* 22 */     this.subCategories.add(subCategory);
/*    */   }
/*    */   
/*    */   public void addModule(Module module) {
/* 26 */     this.modules.add(module);
/*    */   }
/*    */   
/*    */   public ArrayList<Module> getModules() {
/* 30 */     return this.modules;
/*    */   }
/*    */   
/*    */   public String getName() {
/* 34 */     return this.name;
/*    */   }
/*    */   
/*    */   public void toggleExpanded() {
/* 38 */     this.expanded = !this.expanded;
/*    */   }
/*    */   
/*    */   public boolean isExpanded() {
/* 42 */     return this.expanded;
/*    */   }
/*    */ }


/* Location:              C:\Users\SpigotRCE\Downloads\gemma-1.0.0 (5).jar!\com\viraps\module\Category.class
 * Java compiler version: 17 (61.0)
 * JD-Core Version:       1.1.3
 */