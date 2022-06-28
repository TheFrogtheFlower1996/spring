package com.zh.七大原则.开闭;

/**
 * @author zh
 * @date 2022/6/22 10:47
 * @description:说明 开闭原则
 */
public class Test01 {
    public static void main(String[] args) {

        Use use = new Use();
        use.useFa(new A());

    }
}

//调用类 使用方（修改关闭）
class Use{
    //根据基类调用子类
    public void useFa(Father f){
            f.show();
    }
}


//基类 c抽象类
abstract class Father{
    int type;
    public abstract void show();

}

//子类 A
class A extends Father{

    @Override
    public void show() {
        System.out.println("子类A 实现父类方法 show()");
    }
}

//子类 B
class B extends Father{

    @Override
    public void show() {
        System.out.println("子类B 实现父类方法 show()");
    }
}

//子类 扩展类 提供方（扩展开放）
class K extends Father{

    @Override
    public void show() {
        System.out.println("子类B 实现父类方法 show()");
    }
}


