package com.linhcn.generaldeputy.abstractFactory;

/**
 * Created by linhcn on 9/28/16.
 */
public class PlayerFactory extends ArmyAbstractFactory {

    private int general;
    private int deputy;
    private int solider;
    private String name;
    private String color;
    private int[] prisoner;

//    public PlayerFactory(int general,int deputy,int solider){
//        this.general = general;
//        this.deputy = deputy;
//        this.solider = solider;
//    }
    private PlayerFactory(PlayerFactoryBuilder playerFactoryBuilder){
        this.general = playerFactoryBuilder.general;
        this.deputy = playerFactoryBuilder.deputy;
        this.solider = playerFactoryBuilder.solider;
        this.name= playerFactoryBuilder.name;
        this.color = playerFactoryBuilder.color;
        this.prisoner = playerFactoryBuilder.prisoner;
    }

    @Override
    public Army createArmy() {
        return new Player.PlayerBuilder().setName(name).setGeneral(general).setSolider(solider).setDeputy(deputy).setColor(color).setPrisoner(prisoner).build();
    }

    public static class PlayerFactoryBuilder{

        private int general;
        private int deputy;
        private int solider;
        private String name;
        private String color;
        public int[] prisoner;

        public PlayerFactoryBuilder(){

        }

        public PlayerFactoryBuilder setGeneral(int general){
            this.general = general;
            return this;
        }
        public PlayerFactoryBuilder setDeputy(int deputy){
            this.deputy = deputy;
            return this;
        }
        public PlayerFactoryBuilder setSolider(int solider){
            this.solider = solider;
            return this;
        }

        public PlayerFactoryBuilder setName(String name){
            this.name = name;
            return this;
        }
        public PlayerFactoryBuilder setColor(String color){
            this.color = color;
            return this;
        }
        public PlayerFactoryBuilder setPrisoner(int[] prisoner){
            this.prisoner = prisoner;
            return this;
        }

        public PlayerFactory build(){
            return new PlayerFactory(this);
        }

    }

}
