package exam.part6;

public class GameCharacter {
    private String name;
    private int level;
    private int hp;
    private int maxHp;

    GameCharacter(String name) {
        this.name = name;
        this.level = 1;
        this.maxHp = 100;
        this.hp = 100;
    }

    public void takeDamage(int damage) {
        if (damage > hp) {
            hp = 0;
        } else {
            hp -= damage;
        }
        System.out.println(name + "이(가) " + damage + "의 피해를 입었습니다! (남은 HP:" + hp + ")");
    }

    public void recoverHp(int amount) {
        if (amount + hp > maxHp) {
            hp = maxHp;
        } else {
            hp += amount;
        }
        System.out.println(name + "이(가) HP를 " + amount + "만큼 회복했습니다! (현재 HP:" + hp + ")");
    }

    public void levelUp() {
        level++;
        maxHp += 20;
        hp = maxHp;
        System.out.println("레벨 업!" + name + "의 레벨이 " + level + "이 되었습니다. (최대 HP:" + maxHp + ")");
    }

    public void getCharacterInfo() {
        System.out.println("이름: " + name + ", 레벨: " + level + ", HP: " + hp + "/" + maxHp);
    }
}
