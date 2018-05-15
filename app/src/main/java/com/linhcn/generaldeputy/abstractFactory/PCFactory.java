package com.linhcn.generaldeputy.abstractFactory;

/**
 * Created by linhcn on 9/28/16.
 */
public class PCFactory extends ArmyAbstractFactory {

    private int general;
    private int deputy;
    private int solider;
    private String name;
    private String color;
    private int[] prisoner;

    private PCFactory(PCFactoryBuilder pcFactoryBuilder) {
        this.general = pcFactoryBuilder.general;
        this.deputy = pcFactoryBuilder.deputy;
        this.solider = pcFactoryBuilder.solider;
        this.name = pcFactoryBuilder.name;
        this.prisoner = pcFactoryBuilder.prisoner;
    }

    @Override
    public Army createArmy() {
        return new PC.PCBuilder().setGeneral(general).setDeputy(deputy).setSolider(solider).setName(name).setColor(color).setPrisoner(prisoner).build();
    }

    public static class PCFactoryBuilder {
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

        public PCFactoryBuilder() {

        }

        public PCFactoryBuilder setGeneral(int general) {
            this.general = general;
            return this;
        }

        public PCFactoryBuilder setDeputy(int deputy) {
            this.deputy = deputy;
            return this;
        }

        public PCFactoryBuilder setSolider(int solider) {
            this.solider = solider;
            return this;
        }

        public PCFactoryBuilder setName(String name) {
            this.name = name;
            return this;
        }
        public PCFactoryBuilder setColor(String color) {
            this.color = color;
            return this;
        }
        public PCFactoryBuilder setPrisoner(int[] prisoner) {
            this.prisoner = prisoner;
            return this;
        }

        public PCFactory build() {
            return new PCFactory(this);
        }

    }
}
