package sber;

public class InheritanceTask {

    public static void changeX(classWithXValue clazz){
        clazz.x =1;
        classWithXValue newClazz = new classWithXValue();
        newClazz.x =2;

    }

    public static void main(String[] args) {
        classWithXValue myClazz = new classWithXValue();
        myClazz.x =3;
        changeX(myClazz);
        System.out.println(myClazz.x);
    }
}

class classWithProtectedMethod{
    protected void method(){}
}
class classWithInheritedProtectedMethod extends classWithProtectedMethod{
    protected void method(){};//method might be public too
}



class classWithXValue{
    int x;
}