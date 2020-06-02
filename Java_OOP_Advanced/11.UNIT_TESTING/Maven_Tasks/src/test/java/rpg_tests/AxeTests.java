package rpg_tests;

import org.junit.Assert;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;

public class AxeTests {


    @Test
    public void weaponAttacksLosesDurability(){

        Axe axe = new Axe(10, 10);

        Dummy dummy = new Dummy(10, 10);

        axe.attack(dummy);

        Assert.assertTrue(axe.getDurabilityPoints()  == 9);

    }

    @Test(expected = IllegalStateException.class)
    public void attacksWithBrokenWeapon(){
        Axe axe = new Axe(10,0);

        Dummy dummy = new Dummy(10, 10);

        axe.attack(dummy);

    }
}
