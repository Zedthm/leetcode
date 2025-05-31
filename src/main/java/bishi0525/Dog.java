package bishi0525;

/**
 * @author zedthm
 * @version 1.0
 * @date 2025/5/26 0:19
 * @description:
 */
public class Dog  extends Aniaml{

    public Dog(String gou) {
        super(gou);
    }
    @Override
    public void eat() {
        System.out.println("狗吃骨头");
    }
}
