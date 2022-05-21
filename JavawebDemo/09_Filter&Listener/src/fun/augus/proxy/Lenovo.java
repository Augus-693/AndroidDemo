package fun.augus.proxy;

/**
 * @author: Augus
 * @progect: JavawebDemo
 * @package: com.augus.proxy
 * @FileName: computer
 * @date 2021年11月24日 13:20
 * @version: 1.0
 */


public class Lenovo implements SaleComputer{

    @Override
    public String sale(double money) {
        System.out.println("花费"+money+"元买了一台电脑");
        return "电脑";
    }

    @Override
    public void show() {
        System.out.println("展示电脑");
    }
}
