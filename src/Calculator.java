public class Calculator {
    String name;
    double cache;

    public Calculator(String nombre) {
        this.name = nombre;
        cache = 0;
    }

    public String getName() {
        return this.name;
    }

    public double getCache() {
        return this.cache;
    }

    public void setCache(double cache) {
        this.cache = cache;
    }

    public static void showOptionsMenu() {
        System.out.println("| Available options: ");
        System.out.println("| 1. Add: num + num");
        System.out.println("| 2. Subtract: num - num");
        System.out.println("| 3. Multiply: num * num");
        System.out.println("| 4. Divide: num / num");
    }

    @Override
    public String toString() {
        return (this.name + ". Cache = " + this.cache);
    }
}
