import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Exercise_Test {
    @DataProvider
    public Object[][] Abs() {
        int array_1[][] = new int[6][2];
        int a, b;
        for (int i =0; i<3; i++) {
            a = (int) (Math.random() * (Integer.MAX_VALUE-1));
            b = (int) (Math.random() * (Integer.MIN_VALUE+1));
            array_1[i*2][0] = a;
            array_1[i*2][1] = a;
            array_1[i*2 +1][0] = -b;
            array_1[i*2+1][1] = b;
        }
        return new Object[][]
                {
                        {array_1}
                };
    };
    @DataProvider
    //AddExact возвращает сумму своих аргументов, выбрасывая исключение, если результат переполняет int.
    public Object[][] Add_Exact() {
        int array_2[][] = new int[6][2];
        int a, b;
        int n = Integer.MAX_VALUE-1;
        for (int i = 0; i<6; i++) {
            a = (int) (Math.random() * (n) - Integer.MAX_VALUE/2);
            b = (int) (Math.random() * (n) - Integer.MAX_VALUE/2);
            array_2[i][0] = a;
            array_2[i][1] = b;
        }
        return new Object[][]
                {
                        {array_2}
                };
    };


    @Test(dataProvider = "Abs")
    public void TestAbs(int array1_1[][]) throws Exception {
        int n;
        for (int i = 0; i < 6; i++) {
            n = Math.abs(array1_1[i][1]);
            Assert.assertEquals(array1_1[i][0], n, "module error");
            System.out.println("take the module: " + array1_1[i][1] );
            System.out.println(array1_1[i][0]+ " = " + n );
        }
    }
    @Test (dataProvider = "Add_Exact")
    public void TestAddExact(int array2_2[][]) throws Exception {
        int n, summ;
        for (int i = 0; i < 6; i++) {
            n = Math.addExact(array2_2[i][0], array2_2[i][1]);
            summ = (array2_2[i][0] + array2_2[i][1]);
            Assert.assertEquals(summ, n, "function error addExact");
            System.out.println("Add up the numbers: " + array2_2[i][0] + " " + array2_2[i][1]);
            System.out.println(summ + " = " + n );
        }
    }

    @DataProvider
    //метод сначала делит первый аргумент на второй аргумент, а затем выполняет операцию floor ()
    // над результатом и возвращает целое число, которое меньше или равно частному.
    public Object[][] floor_Div() {
        int array_3[][] = new int[9][2];
        int a, b;
        // генерирует 3 пары случайных положительных чисел от 0 до Integer.MAX_VALUE включительно
        for (int i = 0; i<3; i++) {
            a = (int) ((Math.random() * ((double) Integer.MAX_VALUE+1)));
            b = (int) ((Math.random() * ((double) Integer.MAX_VALUE+1-1)))+1;
            array_3[i][0] = a;
            array_3[i][1] = b;
        }
        //генерирует 3 пары случайных чисел, положительное, от 0 до Integer.MAX_VALUE включительно
        //отрицательное, от Integer.MIN_VALUE до 0 не включительно )
        for (int i = 3; i<6; i++) {
            a = (int) ((Math.random() * ((double) Integer.MAX_VALUE+1)));
            b = (int) (Math.random() * (0-(double)Integer.MIN_VALUE))+ Integer.MIN_VALUE;
            array_3[i][0] = a;
            array_3[i][1] = b;
        }
        // генерация трех пар случайных отрицательных чисел от Integer.MIN_VALUE/2 до 0 включительно
        for (int i = 6; i<9; i++) {
            a = (int) (Math.random() * (1-(double)Integer.MIN_VALUE))+ Integer.MIN_VALUE;
            b = (int) (Math.random() * (0-(double)Integer.MIN_VALUE))+ Integer.MIN_VALUE;
            array_3[i][0] = a;
            array_3[i][1] = b;
        }
        return new Object[][]
                {
                        {array_3}
                };
    }

    @Test (dataProvider = "floor_Div")
    public  void TestFloorDiv(int mass3[][]) throws Exception{
        int n, fldiv;
        for (int i = 0; i < 9; i++) {
            n = Math.floorDiv(mass3[i][0], mass3[i][1]);
            if (mass3[i][0] >= 0 && mass3[i][1] < 0) {
                fldiv = (int) Math.floor ((double) mass3[i][0]/ (double) mass3[i][1]) ;
            }
            else {
                fldiv = (mass3[i][0] / mass3[i][1]);
            }
            Assert.assertEquals(fldiv, n, "function error floorDiv");
            System.out.println("Integer division of numbers: " + mass3[i][0] + " " + mass3[i][1]);
            System.out.println(fldiv + " = " + n );
        }
    }
}
