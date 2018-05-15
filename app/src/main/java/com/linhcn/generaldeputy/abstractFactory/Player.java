package com.linhcn.generaldeputy.abstractFactory;

/**
 * Created by linhcn on 9/28/16.
 */
public class Player extends Army {

    private int general;
    private int deputy;
    private int solider;
    private String name;
    private String color;
    private int[] prisoner;

    public Player(PlayerBuilder playerBuilder) {
        this.general = playerBuilder.general;
        this.deputy = playerBuilder.deputy;
        this.solider = playerBuilder.solider;
        this.name = playerBuilder.name;
        this.color = playerBuilder.color;
        this.prisoner = playerBuilder.prisoner;
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
    public int getPrisoner(int typePrisoner) {
        if (typePrisoner<2 && typePrisoner >=0){
            System.out.println("getPrisoner: "+prisoner[typePrisoner]);
            return prisoner[typePrisoner];
        }else{
            return 0;
        }
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
    public void setPrisoner(int prisoner) {
        this.prisoner[prisoner] = getPrisoner(prisoner) + 1;
    }


    public static class PlayerBuilder {

        private int general;
        private int deputy;
        private int solider;
        private String name;
        private String color;
        private int[] prisoner;

        public PlayerBuilder() {
        }

        public PlayerBuilder setGeneral(int general) {
            this.general = general;
            return this;
        }

        public PlayerBuilder setDeputy(int deputy) {
            this.deputy = deputy;
            return this;
        }

        public PlayerBuilder setSolider(int solider) {
            this.solider = solider;
            return this;
        }

        public PlayerBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public PlayerBuilder setColor(String color) {
            this.color = color;
            return this;
        }

        public PlayerBuilder setPrisoner(int[] prisoner) {
            this.prisoner = prisoner;
            return this;
        }

        public Player build() {
            return new Player(this);
        }

    }
}
