public class TestBuilder 
{
    public static void main(String[] args) 
     {
        Computer c1 = new Computer.Builder().setCPU("i5").setRAM("8GB").setStorage("512GB").build();
        Computer c2 = new Computer.Builder().setCPU("i7").setRAM("16GB").setStorage("1TB").build();
        c1.showConfig();
        System.out.println();
        c2.showConfig();
    }
}
