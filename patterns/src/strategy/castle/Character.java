package strategy.castle;

public abstract class Character {

    WeaponBehavior weapon;

    public void setWeapon(WeaponBehavior weapon) {
        this.weapon = weapon;
    }

    abstract public void fight();
}
