package com.techlabs.strcutural.decorator.test;

import com.techlabs.strcutural.decorator.model.*;

public class HatDecoratorTest {
    public static void main(String[] args) {
        StandardHat standardHat = new StandardHat("Gucci",100, "Its a Standard Hat");
        System.out.println(standardHat.getHatName());
        System.out.println(standardHat.getHatPrice());
        System.out.println(standardHat.getHatDescription());

        System.out.println("-----------------------------------------------");

        GoldenHat goldenStandardHat = new GoldenHat(standardHat);
        System.out.println(goldenStandardHat.getHatName());
        System.out.println(goldenStandardHat.getHatPrice());
        System.out.println(goldenStandardHat.getHatDescription());

        System.out.println("------------------------------------------------");

        RibbonHat ribbonGoldenStandardHat = new RibbonHat(goldenStandardHat);
        System.out.println(ribbonGoldenStandardHat.getHatName());
        System.out.println(ribbonGoldenStandardHat.getHatPrice());
        System.out.println(ribbonGoldenStandardHat.getHatDescription());

        System.out.println("-------------------------------------------------");
        System.out.println("-------------------------------------------------");
        System.out.println("-------------------------------------------------");

        PremiumHat premiumHat = new PremiumHat("Casso",300,"Its a Premium Hat");
        System.out.println(premiumHat.getHatName());
        System.out.println(premiumHat.getHatPrice());
        System.out.println(premiumHat.getHatDescription());

        System.out.println("-----------------------------------------------");

        GoldenHat goldenPremiumHat = new GoldenHat(premiumHat);
        System.out.println(goldenPremiumHat.getHatName());
        System.out.println(goldenPremiumHat.getHatPrice());
        System.out.println(goldenPremiumHat.getHatDescription());

        System.out.println("------------------------------------------------");

        RibbonHat ribbonGoldenPremiumHat = new RibbonHat(goldenPremiumHat);
        System.out.println(ribbonGoldenPremiumHat.getHatName());
        System.out.println(ribbonGoldenPremiumHat.getHatPrice());
        System.out.println(ribbonGoldenPremiumHat.getHatDescription());

        System.out.println("-------------------------------------------------");
    }
}
