package com.linhcn.generaldeputy.abstractFactory;

import android.util.Log;

/**
 * Created by linhcn on 9/28/16.
 */
public class PC extends Army {
    private int general;
    private int deputy;
    private int solider;
    private String name;
    private String color;
    private int[] prisoner;

    private PC(PCBuilder pcBuilder) {
        this.general = pcBuilder.general;
        this.deputy = pcBuilder.deputy;
        this.solider = pcBuilder.solider;
        this.name = pcBuilder.name;
        this.prisoner = pcBuilder.prisoner;
    }

    @Override
    public int getGeneral() {
        return general;
    }

    @Override
    public int getDeputy() {
        return deputy;
    }

    @Override
    public int getSolider() {
        return solider;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public void setGeneral(int general) {
        this.general = general;
    }

    @Override
    public void setDeputy(int deputy) {
        this.deputy = deputy;
    }

    @Override
    public void setSolider(int solider) {
        this.solider = solider;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public int getPrisoner(int typePrisoner) {
        if (typePrisoner < 2 && typePrisoner >= 0) {
            System.out.println("getPrisoner: " + prisoner[typePrisoner]);
            return prisoner[typePrisoner];
        } else {
            Log.e("PC", "getPrisoner: value not accept");
            return 0;
        }
    }

    @Override
    public void setPrisoner(int prisoner) {
        this.prisoner[prisoner] = getPrisoner(prisoner) + 1;
    }

    public static class PCBuilder {
        private int general;
        private int deputy;
        private int solider;
        private String name;
        private String color;
        private int[] prisoner;

//        public PCPlayBuilder(int general,int deputy,int solider){
//            this.general = general;
//            this.deputy = deputy;
//            this.solider = solider;
//        }

        public PCBuilder() {

        }

        public PCBuilder setGeneral(int general) {
            this.general = general;
            return this;
        }

        public PCBuilder setDeputy(int deputy) {
            this.deputy = deputy;
            return this;
        }

        public PCBuilder setSolider(int solider) {
            this.solider = solider;
            return this;
        }

        public PCBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public PCBuilder setColor(String color) {
            this.color = color;
            return this;
        }

        public PCBuilder setPrisoner(int[] prisoner) {
            this.prisoner = prisoner;
            return this;
        }

        public PC build() {
            return new PC(this);
        }

    }

}
