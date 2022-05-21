package fun.augus.proxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author: Augus
 * @progect: JavawebDemo
 * @package: com.augus.proxy
 * @FileName: ProxyTest
 * @date 2021年11月24日 13:24
 * @version: 1.0
 */


public class ProxyTest {
    public static void main(String[] args) {
       //创建真实对象
        Lenovo lenovo = new Lenovo();

        /*
        * 三个参数
        *   1.类加载器：真实对象.getClass().getClassLoader()
        *   2.接口数组：真实对象.getClass().getInterfaces()
        *   3.处理器：new InvocationHandler()
        * */
        //动态代理增强lenovo对象
        SaleComputer proxy_lenovo = (SaleComputer) Proxy.newProxyInstance(lenovo.getClass().getClassLoader(), lenovo.getClass().getInterfaces(), new InvocationHandler() {
            /*
            * 代理逻辑编写的方法，代理对象调用的所有方法都会触发该方法执行
            *   参数
            *       1.proxy：代理对象
            *       2.method：代理对象调用方法时，被封装为的对象
            *       3.args：代理对象调用方法时，传递的实际参数
            * */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                /*System.out.println("该方法被执行了");
                System.out.println(method.getName());
                System.out.println(args[0]);*/

                //判断是否是sale方法
                if (method.getName().equals("sale")) {
                    //增强参数
                    double money = (double) args[0];
                    money *= 0.85;
                    //使用真实对象调用该方法
                    String obj = (String) method.invoke(lenovo, money);
                    //增强返回值
                    return obj+"，键鼠套装";
                }else {
                    Object obj = method.invoke(lenovo, args);
                    return obj;
                }
            }
        });
        //调用方法
        String computer = proxy_lenovo.sale(8000);
        System.out.println(computer);
        proxy_lenovo.show();

    }
}
