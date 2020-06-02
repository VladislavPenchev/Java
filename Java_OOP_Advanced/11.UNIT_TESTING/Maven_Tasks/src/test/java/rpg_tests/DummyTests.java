package rpg_tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;

public class DummyTests {

    private static final int ATTACK = 10;
    private static final int DURABILITY = 10;
    private static final int TEN = 10;

    private Axe axe;

    @Before
    public void initializeAxe(){
        this.axe = new Axe(ATTACK, DURABILITY);
    }

    @Test
    public void dummyLosesHealthAfterAttack(){



        Dummy dummy = new Dummy(10, TEN);

        axe.attack(dummy);

        Assert.assertEquals("Wrong dummy health",5,dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void deadDummyThrowsExceptionIfAttacked(){
        Dummy dummy = new Dummy(10, TEN);

        axe.attack(dummy);
        axe.attack(dummy);

        Assert.assertTrue(dummy.getHealth() == 0);
    }

    @Test()
    public void deadDummyCanGiveXP(){
        Dummy dummy = new Dummy(10, TEN);

        axe.attack(dummy);


        Assert.assertTrue(dummy.giveExperience() == 10);
    }

    @Test(expected = IllegalStateException.class)
    public void aliveDmmyCanNotGiveXP(){
        Dummy dummy = new Dummy(10, TEN);

        axe.attack(dummy);

        dummy.giveExperience();
    }
}
