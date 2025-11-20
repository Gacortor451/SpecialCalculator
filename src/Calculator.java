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
        return cache;
    }

    public void setCache(double cache) {
        this.cache = cache;
    }

    public static void showOptionsMenu() {
        System.out.println("Choose an option:");
        System.out.println("1. Add");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");
    }

    @Override
    public String toString() {
        return (this.name + ":cache= " + this.cache);
    }
}
