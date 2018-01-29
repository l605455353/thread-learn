package top.lfyao.thread.innerClassStudy;

/**
 * 内部类学习
 */
public class OuterClass {
    private String outerName;
    private int outerAge;

    private class InnerClass {
        private int innerName;

        public InnerClass() {
            // 内部类可访问外部类的元素（包括private)
            outerName = "I am outer class";
            outerAge = 26;
        }

        public OuterClass getOuterClass() {
            // 获取外部类的引用
            return OuterClass.this;
        }

        public void innerDisplay() {
            //内部类也可以通过外部类的引用访问外部元素
            getOuterClass().outerMethod();
        }

        public void display() {
            System.out.println(outerName + ";age：" + outerAge);
        }
    }

    public void outerMethod() {
        System.out.println("外部类的方法");
        //外部类访问内部类元素，需要通过内部类引用访问
        InnerClass innerClass = new InnerClass();
        innerClass.display();
    }

    public void outClass() {
        class  InnerMetodClass{
            private String innerMetodName;
        }
        InnerMetodClass innerMetodClass = new InnerMetodClass();

    }

    public static void main(String[] args) {
        OuterClass.InnerClass innerClass = new OuterClass().new InnerClass();
        innerClass.innerDisplay();

    }
}
